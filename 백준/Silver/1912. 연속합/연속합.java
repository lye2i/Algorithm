import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = -1000;
		int DP[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			int n = Integer.parseInt(st.nextToken());
			DP[i] = Math.max(DP[i-1] + n, n);
			max = Math.max(DP[i], max);
		}
		
		System.out.print(max);
	}
}