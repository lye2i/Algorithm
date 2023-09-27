import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S, cnt, num[];
	
	static void dfs(int idx, int sum) {
		if(idx == N) {
			if(sum == S)	cnt++;
			return;
		}
		
		dfs(idx + 1, sum + num[idx]);
		dfs(idx + 1, sum);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.print(S == 0 ? cnt-1 : cnt);
	}
}