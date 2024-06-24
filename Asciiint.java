import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Asciiint {
    int bufferLength = 72;
    int startCharCode = 33;
    int endCharCode = 126;

    public void writeAscii(OutputStream out) throws IOException {
        int start = startCharCode;
        while (start <= endCharCode - bufferLength) {
            for (int i = start; i <= start + bufferLength; i++) {
                out.write(i);
            }
            out.write('\r');
            out.write('\n');
            ++start;
        }
    }

    public static void main(String[] args) {
        try (OutputStream fout = new FileOutputStream("./hello.txt")) {
            Asciiint cg = new Asciiint();
            for (int i = 0; i < 200; i++) {
                cg.writeAscii(fout);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
