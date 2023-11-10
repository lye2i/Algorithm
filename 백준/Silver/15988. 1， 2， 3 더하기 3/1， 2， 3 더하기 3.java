import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[1000001];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		
		for(int i=4; i<=1000000; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
		}
		
		while(N-- > 0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
		}
		
		System.out.print(sb);
	}
}