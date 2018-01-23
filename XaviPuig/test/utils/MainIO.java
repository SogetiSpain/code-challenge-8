package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class MainIO {

    private ByteArrayOutputStream output;
    private ByteArrayOutputStream error;

    // El stream de entrada necesita obligatoriamente un valor, así que no tiene sentido un constructor vacio.
    private MainIO() {}

    public MainIO(String text) {
        InputStream input = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        this.output = new ByteArrayOutputStream(); // Stream de salida (System.out)
        this.error = new ByteArrayOutputStream();  // Stream de error (System.err)
        // Reasignamos la entrada a nuestro stream Input, la salida y el error
        System.setIn(input);
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(error));
    }

    public ByteArrayOutputStream getOutput() {
        return this.output;
    }

    public ByteArrayOutputStream getError() {
        return this.error;
    }
}