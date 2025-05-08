import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, num[], ans;
	
	static void game(int cnt, boolean visit[], int sum) {
		if(cnt == N) {
			ans++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i] && sum + num[i] >= 0) {
				visit[i] = true;
				game(cnt+1, visit, sum+num[i]);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken()) - K;
		}
		
		game(0, new boolean[N], 0);
		System.out.print(ans);
	}
}