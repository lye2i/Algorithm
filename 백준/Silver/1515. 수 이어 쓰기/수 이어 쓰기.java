import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = 0;
		int ptr = 0;
		
		while(true) {
			String num = String.valueOf(++n);
			
			for(int i=0; i<num.length(); i++) {
				if(num.charAt(i) == str.charAt(ptr))	ptr++;
				if(ptr == str.length())	break;
			}
			
			if(ptr >= str.length())	break;
		}
		
		System.out.print(n);
	}
}