package generator;

public abstract class Generator {

    protected static final char[] LETTERS = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    protected static final char[] SPECIAL = new char[] {'!', '?', '#', '@', '€', '*', '-', '_', '.', '+', '/', '£'};
    protected static final char[] NUMBERS = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    protected int length;
    protected int letters;
    protected int specialChars;
    protected int numbers;
    protected boolean leetSpeak;

    public abstract String generate();
    public abstract String[] generate(int howMany);
}
