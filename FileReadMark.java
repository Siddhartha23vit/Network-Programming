import java.io.*;

public class FileReadMark{
    public static void main(String[] args) {
        // File path to write the output
        String outputPath = "novel.txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {

            // Character range to be repeated
            int startChar = 10;
            int endChar = 30;

            // Number of repetitions
            int repetitions = 10;

            // Create input stream with mark support
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(outputPath));
            bufferedInputStream.mark(repetitions * (endChar - startChar + 1) + 1);

            for (int i = 0; i < repetitions; i++) {
                for (int j = startChar; j <= endChar; j++) {
                    bufferedOutputStream.write(j);
                }
            }

            // Reset to the marked position
            bufferedInputStream.reset();

            // Repeat writing the characters to complete 10 repetitions
            for (int i = 0; i < repetitions; i++) {
                for (int j = startChar; j <= endChar; j++) {
                    bufferedOutputStream.write(j);
                }
            }

            // Flush the stream and close
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            System.out.println("Output written to " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
