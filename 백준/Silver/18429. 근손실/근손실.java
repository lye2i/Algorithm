import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, E[], cnt;
	
	public static void exercise(int idx, boolean visit[], int kg) {
		if(idx == N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i] && kg-K+E[i] >= 500) {
				visit[i] = true;
				exercise(idx+1, visit, kg-K+E[i]);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		E = new int[N];
		cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			E[i] = Integer.parseInt(st.nextToken());
		
		exercise(0, new boolean[N], 500);
		System.out.print(cnt);
	}
}