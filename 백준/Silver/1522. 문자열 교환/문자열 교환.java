import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str[] = br.readLine().toCharArray();
		int ans = 1000, acnt = 0, N = str.length;
		
		for(int i=0; i<N; i++) {
			if(str[i] == 'a')	acnt++;
		}
		
		for(int i=0; i<N; i++) {
			int bcnt = 0;
			for(int j=0; j<acnt; j++) {
				if(str[(i+j)%N] == 'b')	bcnt++;
			}
			ans = Math.min(ans, bcnt);
		}
		
		System.out.print(ans);
	}
}