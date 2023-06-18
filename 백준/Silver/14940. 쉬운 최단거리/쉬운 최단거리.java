import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		int ans[][] = new int[N][M];
		int sr = 0, sc = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					sr = i;
					sc = j;
				}
			}
		}
		
		boolean visit[][] = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[sr][sc] = true;
		queue.add(new int[] {sr, sc, 0});
		while(!queue.isEmpty()) {
			int b[] = queue.poll();
			ans[b[0]][b[1]] = b[2];
			
			for(int i=0; i<4; i++) {
				int dr = b[0] + r[i];
				int dc = b[1] + c[i];
				if(dr < 0 || dr >= N || dc < 0 || dc >= M || visit[dr][dc] || map[dr][dc] == 0)	continue;
				visit[dr][dc] = true;
				queue.add(new int[] {dr,dc,b[2]+1});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j])	sb.append(ans[i][j]+" ");
				else if(map[i][j] == 0)	sb.append(0).append(" ");
				else sb.append(-1).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}