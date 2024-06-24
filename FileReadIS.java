import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReadIS {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("reader.txt")) {
            int data;
            while ((data = in.read()) != -1) {
                char character = (char) data;
                System.out.print(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
