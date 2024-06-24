import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReadBY {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("reader.txt")) {
           
            byte[] buffer1 = new byte[1024]; 
            int bytesRead1;
            while ((bytesRead1 = in.read(buffer1)) != -1) {
                String characters1 = new String(buffer1, 0, bytesRead1);
                System.out.print(characters1);
            }

          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
