import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int T[][] = new int[N][M];
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[][] = new boolean[N][M];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				T[i][j] = Integer.parseInt(st.nextToken());
				if(T[i][j] == 1) {
					visit[i][j] = true;
					queue.offer(new int[] {i, j, 0});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int tomato[] = queue.poll();
			answer = Math.max(answer, tomato[2]);
			for (int d = 0; d < dr.length; d++) {
				int r = tomato[0] + dr[d];
				int c = tomato[1] + dc[d];
				
				if(r >= 0 && r < N && c >= 0 && c < M && !visit[r][c] && T[r][c] == 0) {
					visit[r][c] = true;
					T[r][c] = 1;
					queue.offer(new int[] {r,c,tomato[2]+1});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(T[i][j] == 0) {
					answer = -1;
					break;
				}
			}
		}
		
		System.out.print(answer);
	}
}