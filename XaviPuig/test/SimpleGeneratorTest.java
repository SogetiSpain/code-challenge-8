import generator.simple.SimpleGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleGeneratorTest {
    @Test
    @DisplayName("Test only letters")
    void allLetters() {
        SimpleGenerator generator = new SimpleGenerator(8, 0, 0, false);
        String password = generator.generate();
        Assertions.assertTrue(password.matches("^[a-zA-Z]{8}$"), password);
    }

    @Test
    @DisplayName("Test only numbers")
    void allNumbers() {
        SimpleGenerator generator = new SimpleGenerator(10, 0, 10, false);
        String password = generator.generate();
        Assertions.assertTrue(password.matches("^[0-9]{10}$"), password);
    }

    @Test
    @DisplayName("Test only special chars")
    void allSpecial() {
        SimpleGenerator generator = new SimpleGenerator(10, 10, 0, false);
        String password = generator.generate();
        Assertions.assertTrue(password.matches("^[\\!\\?\\#\\@\\€\\*\\-\\_\\.\\+\\/\\£]{10}$"), password);
    }

    @Test
    @DisplayName("Test leet speak")
    void leetSpeak() {
        SimpleGenerator generator = new SimpleGenerator(10, 0, 0, true);
        String password = generator.generate();
        Assertions.assertTrue(password.matches("^[\\£0-9cCdDfFhHjJkKmMnNqQrRuUvVwWxXyY]{10}$"), password);
    }

    @Test
    @DisplayName("Test multiple passwords with only letters")
    void multiAllLetters() {
        SimpleGenerator generator = new SimpleGenerator(100, 0, 0, false);
        String[] passwords = generator.generate(1000);
        Assertions.assertEquals(1000, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[a-zA-Z]{100}$"), password);
    }

    @Test
    @DisplayName("Test multiple passwords with only numbers")
    void multiAllNumbers() {
        SimpleGenerator generator = new SimpleGenerator(100, 0, 100, false);
        String[] passwords = generator.generate(1000);
        Assertions.assertEquals(1000, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[0-9]{100}$"), password);
    }

    @Test
    @DisplayName("Test multiple passwords with only special chars")
    void multiAllSpecialChars() {
        SimpleGenerator generator = new SimpleGenerator(100, 100, 0, false);
        String[] passwords = generator.generate(1000);
        Assertions.assertEquals(1000, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[\\!\\?\\#\\@\\€\\*\\-\\_\\.\\+\\/\\£]{100}$"), password);
    }

    @Test
    @DisplayName("Test multiple passwords with leet speak")
    void multiLeet() {
        SimpleGenerator generator = new SimpleGenerator(100, 0, 0, true);
        String[] passwords = generator.generate(1000);
        Assertions.assertEquals(1000, passwords.length);
        for (String password : passwords )
            Assertions.assertTrue(password.matches("^[\\£0-9cCdDfFhHjJkKmMnNqQrRuUvVwWxXyY]{100}$"), password);
    }
}
