import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, H;
	static int dr[] = {-1,1,0,0,0,0};
	static int dc[] = {0,0,1,-1,0,0};
	static int dh[] = {0,0,0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int T[][][] = new int[H][N][M];
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[][][] = new boolean[H][N][M];
		int answer = 0;
		
		for(int h=0; h<H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					T[h][i][j] = Integer.parseInt(st.nextToken());
					if(T[h][i][j] == 1) {
						visit[h][i][j] = true;
						queue.offer(new int[] {h, i, j, 0});
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int tomato[] = queue.poll();
			answer = Math.max(answer, tomato[3]);
			for (int d = 0; d < dr.length; d++) {
				int h = tomato[0] + dh[d];
				int r = tomato[1] + dr[d];
				int c = tomato[2] + dc[d];
				
				if(h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M && !visit[h][r][c] && T[h][r][c] == 0) {
					visit[h][r][c] = true;
					T[h][r][c] = 1;
					queue.offer(new int[] {h,r,c,tomato[3]+1});
				}
			}
		}
		
		for(int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(T[h][i][j] == 0) {
						answer = -1;
						break;
					}
				}
			}
		}
		
		System.out.print(answer);
	}
}