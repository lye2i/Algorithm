import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, max, answer[], origin[];
	
	static void permutation(int k, int idx, boolean visit[], int num[]) {
		if(idx == k) {
			dfs(k, 0, num, origin);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				num[idx] = i;
				visit[i] = true;
				permutation(k, idx+1, visit, num);
				visit[i] = false;
			}
		}
	}
	
	static void dfs(int k, int idx, int num[], int omr[]) {
		if(idx == k) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(answer[i] == omr[i])	cnt++;
			}
			max = Math.max(cnt, max);
			return;
		}
		
		int pull[] = new int[N];
		int push[] = new int[N];
		for(int i=0; i<num[idx]; i++) {
			pull[i] = push[i] = omr[i];
		}
		for(int i=num[idx]; i<N-1; i++) {
			pull[i] = omr[i+1];
			push[i+1] = omr[i];
		}
		
		dfs(k, idx+1, num, pull);
		dfs(k, idx+1, num, push);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		max = 0;
		answer = new int[N];
		origin = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int k=0; k<=K; k++) {
			permutation(k, 0, new boolean[N], new int[k]);
		}

		System.out.print(max);
	}
}