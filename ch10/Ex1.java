import java.io.*;

class Ex1 {
    public static void main(String[] args) throws IOException {
        try {
            throw new IOException();
        } catch(IOException ex) {
            try(PrintStream file = new PrintStream("error.log", "UTF-8")) {
                ex.printStackTrace(file);
            }
        }
    }
}
