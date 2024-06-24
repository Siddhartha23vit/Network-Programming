import java.io.FileInputStream;

public class MultiThread extends Thread {
    static int charRead = 0;
    static FileInputStream fin;

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.print((char) fin.read());
            }
            charRead += 5;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        MultiThread john = new MultiThread();
        MultiThread tom = new MultiThread();
        fin = new FileInputStream("associated.txt");

        System.out.print("John -  ");
        john.start();

        while (charRead == 0) {
            sleep(100);
        }

        System.out.print("Tom:- ");
        tom.start();
    }
}