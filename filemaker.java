

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class filemaker {
	public static void main(String[] args) {
		
		
		int i =33;
		int j =126;
		while(true) {
			ascii(i,j);
			i++;
			j++;
			if(j>=126 ) {
				j = i;
			}
			if(i>126) {
				i =33;
			}
		}
		
	}public static void ascii(int i, int j) {
		
		
		char c = (char) (i) ;
		String s = "";
		for (int k = i;k<=126;k++) {
			c = (char)(k);
			s +=c;
			if(s.length()>72) {
				System.out.println(s);
				
				String data = s;

		        try {
		            OutputStream out = new FileOutputStream("output.txt", true);

		            // Converts the string into bytes
		            byte[] dataBytes = s.getBytes();

		            // Writes data to the output stream
		            out.write(dataBytes);
		            
		            

		            // Closes the output stream
		            out.close();
		        }

		        catch (Exception e) {
		            e.getStackTrace();
		        }
				
				
				break;
			}
		}
		
		
		
	}
}