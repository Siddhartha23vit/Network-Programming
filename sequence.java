import java.io.OutputStream;


public class sequence {
    static int startNum = 0;

    public void writeSeqToFile(int n, int digitsPerRow) {
        while (startNum < n) {
            byte[] arr = new byte[digitsPerRow + 1];
            for (int i = startNum; i < startNum + digitsPerRow; i++) {
                arr[i - startNum] = (byte) Integer.toString(i).charAt(0);
            }
            arr[digitsPerRow] = '\n';
            startNum++;

            System.out.print(new String(arr));
        }
    }

    public static void main(String[] args) {
        sequence sd = new sequence();
        sd.writeSeqToFile(4, 7);
    }

}