import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int acnt = 0, ans = 1000, length = str.length();
		
		for(int i=0; i<length; i++) {
			if(str.charAt(i) == 'a')	acnt++;
		}
		
		for(int i=0; i<length; i++) {
			int bcnt = 0;
			for(int j=0; j<acnt; j++) {
				if(str.charAt((j+i)%length) == 'b')	bcnt++;
			}
			ans = Math.min(bcnt, ans);
		}
		
		System.out.print(ans);
	}
}