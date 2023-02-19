import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int zero = 0, one = 0, z = 0, o = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '0')	zero++;
			else	one++;
		}
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '0' && z < zero/2) {
				sb.append('0');
				z++;
			}
			
			else if(str.charAt(i) == '1') {
				if(o < one/2)	o++;
				else	sb.append('1');
			}
		}
		
		System.out.print(sb);
	}
}