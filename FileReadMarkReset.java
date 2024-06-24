import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReadMarkReset {
    


	public static void main(String[] args) {
	    String filePath = "novel.txt";
        try{
		printCharactersRepeatedly(filePath);}
        catch(Throwable e ){}
	}
    private static void printCharactersRepeatedly(String filePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            if (inputStream.markSupported()) {
                inputStream.mark(30); // Set mark at position 30
                for (int i = 0; i < 10; i++) {
                    inputStream.reset(); // Reset to the marked position
                    byte[] buffer = new byte[20];
                    int bytesRead = inputStream.read(buffer);
                    System.out.print(new String(buffer, 0, bytesRead));
                }
                System.out.println();
            } else {
                System.out.println("Mark/reset not supported by this InputStream.");
            }
        }
    }
}

    
