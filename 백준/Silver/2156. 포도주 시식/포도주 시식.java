import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int G[] = new int[N];
		int DP[] = new int[N];
		
		for(int i=0; i<N; i++) {
			G[i] = Integer.parseInt(br.readLine());
		}
		
		DP[0] = G[0];
		if(N > 1)	DP[1] = G[0] + G[1];
		if(N > 2)	DP[2] = Math.max(DP[1], Math.max(G[0]+G[2], G[1]+G[2]));
		
		for(int i=3; i<N; i++) {
			DP[i] = Math.max(DP[i-1], Math.max(DP[i-2] + G[i], DP[i-3] + G[i-1] + G[i]));
		}
		
		System.out.print(DP[N-1]);
	}
}