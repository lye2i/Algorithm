import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W, O, F, Xs, Ys, Xe, Ye, M[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static boolean search() {
		boolean visit[][] = new boolean[H+1][W+1];
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[Xs][Ys] = true;
		queue.offer(new int[] {Xs, Ys, F});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(cur[2]<=0)	continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr>=1 && nr<=H && nc>=1 && nc<=W && !visit[nr][nc]) {
					int h = M[nr][nc] - M[cur[0]][cur[1]];
					if(cur[2]>=h) {
						if(nr==Xe && nc==Ye)	return true;
						visit[nr][nc] = true;
						queue.offer(new int[] {nr, nc, cur[2]-1});
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
			Xs = Integer.parseInt(st.nextToken());
			Ys = Integer.parseInt(st.nextToken());
			Xe = Integer.parseInt(st.nextToken());
			Ye = Integer.parseInt(st.nextToken());
			M = new int[H+1][W+1];
			
			for (int i = 0; i < O; i++) {
				st = new StringTokenizer(br.readLine());
				M[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(search()?"잘했어!!":"인성 문제있어??").append("\n");
		}
		System.out.print(sb);
	}
}