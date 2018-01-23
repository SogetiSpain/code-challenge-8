import main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.MainIO;
import utils.Utils;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainTest {

    @Test
    @DisplayName("Test clipboard contains the generated passwords")
    void clipboard() throws IOException, UnsupportedFlavorException {
        String input = "8\n2\n2\n\n\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        String clipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        String[] clipBoardPasswords = Utils.getPasswords(clipboard);
        Assertions.assertArrayEquals(passwords, clipBoardPasswords);
    }

    @Test
    @DisplayName("Test only letters")
    void allLetters() {
        String input = "8\n0\n0\n\n\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertTrue(passwords[0].matches("^[a-zA-Z]{8}$"), passwords[0]);
    }

    @Test
    @DisplayName("Test only numbers")
    void allNumbers() {
        String input = "10\n0\n10\n\n\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertTrue(passwords[0].matches("^[0-9]{10}$"), passwords[0]);
    }

    @Test
    @DisplayName("Test only special chars")
    void allSpecial() {
        String input = "10\n10\n0\n\n\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertTrue(passwords[0].matches("^[\\!\\?\\#\\@\\€\\*\\-\\_\\.\\+\\/\\£]{10}$"), passwords[0]);
    }

    @Test
    @DisplayName("Test leet speak")
    void leetSpeak() {
        String input = "10\n0\n0\nyes\n\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertTrue(passwords[0].matches("^[\\£0-9cCdDfFhHjJkKmMnNqQrRuUvVwWxXyY]{10}$"), passwords[0]);
    }

    @Test
    @DisplayName("Test multiple passwords with only letters")
    void multiAllLetters() {
        String input = "8\n0\n0\n\n10\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertEquals(10, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[a-zA-Z]{8}$"), password);
    }

    @Test
    @DisplayName("Test multiple passwords with only numbers")
    void multiAllNumbers() {
        String input = "10\n0\n10\n\n10\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertEquals(10, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[0-9]{10}$"), password);
    }

    @Test
    @DisplayName("Test multiple passwords with only special chars")
    void multiAllSpecialChars() {
        String input = "12\n12\n0\n\n10\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertEquals(10, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[\\!\\?\\#\\@\\€\\*\\-\\_\\.\\+\\/\\£]{12}$"), password);
    }

    @Test
    @DisplayName("Test multiple passwords with leet speak")
    void multiLeetSpeak() {
        String input = "12\n0\n0\ny\n10\n";
        MainIO mainIO = new MainIO(input);
        Main.main(new String[0]);
        String[] passwords = Utils.getPasswords(mainIO.getOutput());
        Assertions.assertEquals(10, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[\\£0-9cCdDfFhHjJkKmMnNqQrRuUvVwWxXyY]{12}$"), password);
    }
}
