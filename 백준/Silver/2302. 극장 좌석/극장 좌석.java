import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int S[] = new int[N+1];
		
		S[0] = 1; S[1] = 1;
		for(int i=2; i<=N; i++) {
			S[i] = S[i-1] + S[i-2];
		}
		
		int idx = 0, answer = 1;
		for(int i=0; i<M; i++) {
			int vip = Integer.parseInt(br.readLine());
			answer *= S[vip-idx-1];
			idx = vip;
		}
		
		System.out.print(answer*S[N-idx]);
	}
}