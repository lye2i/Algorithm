import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, A[], ans;
	
	static void permutation(int idx, int num[], boolean visit[]) {
		if(idx == N) {
			int max = 0;
			for(int i=0; i<N-1; i++) {
				max += Math.abs(num[i] - num[i+1]);
			}
			ans = Math.max(max, ans);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				num[idx] = A[i];
				permutation(idx+1, num, visit);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0, new int[N], new boolean[N]);
		System.out.print(ans);
	}
}