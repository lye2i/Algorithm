import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int N, M, A[][];
	static boolean visit[][];
	
	static int picture(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			cnt++;
			for(int d=0; d<4; d++) {
				int dr = p[0] + r[d];
				int dc = p[1] + c[d];
				if(dr < 0 || dr >= N || dc < 0 || dc >= M || A[dr][dc] == 0 || visit[dr][dc])	continue;
				
				visit[dr][dc] = true;
				queue.add(new int[] {dr, dc});
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visit = new boolean[N][M];
		int cnt = 0, max = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					cnt++;
					max = Math.max(max, picture(i, j));
				}
			}
		}
		
		System.out.println(cnt);
		System.out.print(max);
	}
}