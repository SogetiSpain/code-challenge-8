package generator.simple;

import generator.Generator;
import java.util.Random;

public class SimpleGenerator extends Generator {

    Random random;

    public SimpleGenerator(int length, int specialChars, int numbers) {
        this(length, specialChars, numbers, false);
    }

    public SimpleGenerator(int length, int specialChars, int numbers, boolean leetSpeak) {
        this.length = length;
        this.specialChars = specialChars;
        this.numbers = numbers;
        this.letters = length - numbers - specialChars;
        this.leetSpeak = leetSpeak;
        this.random = new Random();
    }

    @Override
    public String generate() {
        return generate(new StatusHolder(letters, specialChars, numbers));
    }

    @Override
    public String[] generate(int howMany) {
        String[] passwords = new String[howMany];
        for (int i=0; i<howMany; ++i) {
            passwords[i] = generate();
        }
        return passwords;
    }

    private String generate(StatusHolder status) {
        StringBuilder password = new StringBuilder();
        for (int i=0; i<length; ++i) {
            password.append(nextChar(status));
        }
        return password.toString();
    }

    private char nextChar(StatusHolder status) {
        while (true) {
            int val = random.nextInt();
            switch(val % 4) {
                case 0:
                    if (status.getLetters() > 0) {
                        status.decrementLetters();
                        return getLetter();
                    }
                    break;
                case 1:
                    if (status.getSpecialChars() > 0) {
                        status.decrementSpecialChars();
                        return getSpecial();
                    }
                    break;
                case 2:
                    if (status.getNumbers() > 0) {
                        status.decrementNumbers();
                        return getNumber();
                    }
                    break;
                case 3:
                    if (status.getLetters() > 0) {
                        status.decrementLetters();
                        return Character.toUpperCase(getLetter());
                    }
                    break;
            }
        }
    }

    private char getLetter() {
        char letter = LETTERS[random.nextInt(LETTERS.length)];
        if (leetSpeak) return toLeet(letter);
        return letter;
    }

    private char getSpecial() {
        return SPECIAL[random.nextInt(SPECIAL.length)];
    }

    private char getNumber() {
        return NUMBERS[random.nextInt(NUMBERS.length)];
    }

    private char toLeet(char c) {
        switch (c) {
            case 'o':
            case 'O':
                return '0';
            case 'i':
            case 'I':
                return '1';
            case 'z':
            case 'Z':
                return '2';
            case 'e':
            case 'E':
                return '3';
            case 'a':
            case 'A':
                return '4';
            case 's':
            case 'S':
                return '5';
            case 'g':
            case 'G':
                return '6';
            case 't':
            case 'T':
                return '7';
            case 'b':
            case 'B':
                return '8';
            case 'p':
            case 'P':
                return '9';
            case 'l':
            case 'L':
                return '£';
            default:
                return c;
        }
    }
}
