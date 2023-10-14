import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-1,1,0,0}, c[] = {0,0,1,-1};
	static int N, M, hx, hy, ex, ey;
	static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken())-1; hy = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1; ey = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)	map[i][j] = true;
			}
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[2]-b[2]);
		boolean visit[][][] = new boolean[N][M][2];
		int cnt = -1;
		visit[hx][hy][0] = true;
		queue.add(new int[] {hx, hy, 0, 0});
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			
			if(p[0] == ex && p[1] == ey) {
				cnt = p[2];
				break;
			}
			
			for(int d=0; d<4; d++) {
				int dr = p[0] + r[d];
				int dc = p[1] + c[d];
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= M || p[2]+1 > M*N|| visit[dr][dc][p[3]])	continue;
				
				if(!map[dr][dc]) {
					visit[dr][dc][p[3]] = true;
					queue.add(new int[] {dr, dc, p[2]+1, p[3]});
				} else if(p[3] == 0) {
					visit[dr][dc][1] = true;
					queue.add(new int[] {dr, dc, p[2]+1, 1});
				}
			}
		}
		
		System.out.print(cnt);
	}
}