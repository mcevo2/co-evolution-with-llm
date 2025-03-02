import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testcours {

	public static void main(String[] args) {
		try {
			inputInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}
	static int inputInt() throws IOException {
		  boolean correct = false;
		  int res = 0;
		  InputStreamReader is = new InputStreamReader(System.in);
		  BufferedReader br = new BufferedReader(is);
		  while (true) {
		    try {
		      String stringRes = br.readLine();
		      res = Integer.parseInt(stringRes);
		      return res;
		     // correct = true;
		    } catch(NumberFormatException e) {
		      System.out.println("Incorrect number format " + e.getMessage());
		    }
		  }
		//return res;
		  
		}

}
