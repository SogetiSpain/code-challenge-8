package utils;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Utils {

    public static String[] getPasswords(ByteArrayOutputStream ps) {
        String[] splits = ps.toString().split("\n");
        String[] passwords = Arrays.copyOfRange(splits, 8, splits.length);
        return trim(passwords);
    }

    public static String[] getPasswords(String s) {
        String[] splits = s.split("\n");
        return trim(splits);

    }

    private static String[] trim(String[] passwords) {
        for (int i = 0; i<passwords.length;++i) {
            passwords[i] = passwords[i].trim();
        }
        return passwords;
    }
}
