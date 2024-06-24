import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Asciibyte {
    int charsPerLine = 72;
    int startCharCode = 33;
    int endCharCode = 126;

    public void writeAscii(OutputStream out) throws IOException {
        int start = startCharCode;
        while (start <= endCharCode - charsPerLine) {
            byte[] dataBytes = generateAsciiBytes(start);
            out.write(dataBytes);
            out.write('\r');
            out.write('\n');
            ++start;
        }
    }

    private byte[] generateAsciiBytes(int start) {
        byte[] dataBytes = new byte[charsPerLine + 2]; 
        for (int i = 0; i <= charsPerLine; i++) {
            dataBytes[i] = (byte) (start + i);
        }
        dataBytes[charsPerLine] = (byte) '\r';
        dataBytes[charsPerLine + 1] = (byte) '\n';
        return dataBytes;
    }

    public static void main(String[] args) {
        try (OutputStream fout = new FileOutputStream("./byte.txt")) {
            Asciiint ag = new Asciiint();
            for (int i = 0; i < 200; i++) {
                ag.writeAscii(fout);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
