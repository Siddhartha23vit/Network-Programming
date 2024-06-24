import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class tentofifty {

    public static void main(String[] args) {
        readAndWrite();
    }

    public static void readAndWrite() {
        try {
           
            FileReader fileReader = new FileReader("file1.txt");
            
            
            char[] buffer = new char[50];

      
            int bytesRead = fileReader.read(buffer, 9, 41);


            FileWriter fileWriter = new FileWriter("file2.txt");

 
            for (int i = 0; i < 5; i++) {
                fileWriter.write(buffer, 9, bytesRead);
            }

           
            fileReader.close();
            fileWriter.close();

            System.out.println("Characters written to file2.txt successfully.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while reading/writing files.");
        }
    }
}
