// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.InputStream;

// public class FileReadAvailable {
//     public static void main(String[] args) {
//         try (InputStream in = new FileInputStream("novel.txt")) {
//             int availableBytes = in.available();
//             System.out.println("Available Bytes: " + availableBytes);

//             int data;
//             while ((data = in.read()) != -1) {
//                 char character = (char) data;
//                 System.out.print(character);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReadAvailable{

    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("novel.txt")) {
            int availableBytes = inputStream.available();
            
            System.out.println("Available Bytes: " + availableBytes);

            byte[] data = new byte[availableBytes];
            
         
            int bytesRead = inputStream.read(data);
            
            System.out.println("Bytes Read: " + bytesRead);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

