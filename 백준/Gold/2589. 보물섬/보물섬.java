import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int N, M;
	static char map[][];
	
	static int search(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[][] = new boolean[N][M];
		int dist = 0;
		visit[x][y] = true;
		queue.add(new int[] {x, y, 0});
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			
			if(dist < p[2])	dist = p[2];
			
			for(int d=0; d<4; d++) {
				int dr = p[0] + r[d];
				int dc = p[1] + c[d];
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= M || visit[dr][dc] || map[dr][dc] == 'W')	continue;
				
				visit[dr][dc] = true;
				queue.add(new int[] {dr, dc, p[2]+1});
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L')	max = Math.max(max, search(i, j));
			}
		}
		
		System.out.print(max);
	}
}