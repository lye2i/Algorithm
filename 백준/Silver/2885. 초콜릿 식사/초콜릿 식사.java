import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int N = 1, cnt = 0;
		
		while(K > N) {
			N *= 2;
		}
		
		System.out.print(N+" ");
		
		while(K > 0) {
			if(K >= N)	K -= N;
			else {
				N /= 2;
				cnt++;
			}
		}
		
		System.out.print(cnt);
	}
}