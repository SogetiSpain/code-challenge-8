package main;

import generator.simple.SimpleGenerator;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int length = 8, specialChars = 2, numbers = 2, howMany = 1;
        boolean leetSpeak = false;
        Scanner in = new Scanner(System.in);
        String line;
        System.out.println("What's the minimum length? [default=8]");
        line = in.nextLine().trim();
        if (!line.isEmpty()) length = Integer.parseInt(line);
        System.out.println("How many special characters? [default=2]");
        line = in.nextLine().trim();
        if (!line.isEmpty()) specialChars = Integer.parseInt(line);
        System.out.println("How many numbers? [default=2]");
        line = in.nextLine().trim();
        if (!line.isEmpty()) numbers = Integer.parseInt(line);
        System.out.println("Use 1337 speak? [default=no]");
        line = in.nextLine().trim();
        if (!line.isEmpty()) leetSpeak = line.matches("^[yY].*$");
        System.out.println("How many passwords do you want to generate? [default=1]");
        line = in.nextLine().trim();
        if (!line.isEmpty()) howMany = Integer.parseInt(line);
        System.out.println("\nGenerated password/s will be copied to clipboard.\n");

        String[] passwords = new SimpleGenerator(length, specialChars, numbers, leetSpeak).generate(howMany);
        StringBuilder passwordsSB = new StringBuilder();
        for (String password: passwords) passwordsSB.append(password).append('\n');
        copyToClipboard(passwordsSB.toString());
        System.out.print(passwordsSB.toString());
    }

    private static void copyToClipboard(String str) {
        StringSelection strSel = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
    }
}
