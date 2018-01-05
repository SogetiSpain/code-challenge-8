package generator.simple;

public class StatusHolder {

    private int letters;
    private int specialChars;
    private int numbers;

    public StatusHolder(int letters, int specialChars, int numbers) {
        this.letters = letters;
        this.specialChars = specialChars;
        this.numbers = numbers;
    }

    public int getLetters() {
        return letters;
    }

    public int getSpecialChars() {
        return specialChars;
    }

    public int getNumbers() {
        return numbers;
    }

    public void decrementLetters() {
        --letters;
    }

    public void decrementNumbers() {
        --numbers;
    }

    public void decrementSpecialChars() {
        --specialChars;
    }
}
