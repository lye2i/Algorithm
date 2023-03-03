import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, ans, P[];
	static boolean arr[][];
	
	static void divide(int n, char D[], int idxA, int idxB) {
		if(n==N) {
			if(idxA!=-1 && idxB!=-1) {
				if(connect(D,idxA)+connect(D,idxB)==N)
					ans = Math.min(ans, count(D));
			}
			return;
		}
		
		D[n] = 'A';
		divide(n+1,D,n,idxB);
		
		D[n] = 'B';
		divide(n+1, D,idxA,n);
	}
	
	private static int count(char[] d) {
		int cntA = 0, cntB = 0;
		for(int i=0; i<N; i++) {
			if(d[i]=='A')	cntA+=P[i];
			else	cntB+=P[i];
		}
		return Math.abs(cntA-cntB);
	}

	private static int connect(char[] d, int idx) {
		Queue<Integer> q = new LinkedList<>();
		boolean visit[] = new boolean[N];
		int cnt=0;		
		visit[idx] = true;
		q.offer(idx);
		
		while(!q.isEmpty()) {
			int D = q.poll();
			cnt++;
			for(int i=0; i<N; i++) {
				if(arr[D][i] && !visit[i] && d[idx]==d[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = new int[N];
		arr = new boolean[N][N];
		ans = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			for (int j = 0; j < S; j++)
				arr[i][Integer.parseInt(st.nextToken())-1] = true;
		}
		
		divide(0, new char[N], -1, -1);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
}