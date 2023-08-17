import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static final int N = 12, M = 6, r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static char map[][] = new char[N][M];
	static boolean visit[][], visited[][];
	static Queue<int[]> group;
	
	private static void check() {
		visit = new boolean[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visit[i][j] && map[i][j] != '.' && count(visit, i, j) >= 4) {
					visited[i][j] = true;
					group.add(new int[] {i, j});
				}
			}
		}
	}
	
	private static int count(boolean visit[][], int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		visit[x][y] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			cnt++;
			
			for(int d=0; d<4; d++) {
				int dr = p[0] + r[d];
				int dc = p[1] + c[d];
				if(dr < 0 || dr >= N || dc < 0 || dc >= M || map[dr][dc] != map[p[0]][p[1]] || visit[dr][dc])	continue;
				
				visit[dr][dc] = true;
				queue.add(new int[] {dr, dc});
			}
		}
		return cnt;
	}
	
	private static void bomb() {
		while(!group.isEmpty()) {
			int p[] = group.poll();
            
			for(int d=0; d<4; d++) {
				int dr = p[0] + r[d];
				int dc = p[1] + c[d];
				if(dr < 0 || dr >= N || dc < 0 || dc >= M || map[dr][dc] != map[p[0]][p[1]] || visited[dr][dc])	continue;
				
				visited[dr][dc] = true;
				group.add(new int[] {dr, dc});
			}
			
			map[p[0]][p[1]] = '.';
		}
	}
	
	private static void down() {
		for(int j=0; j<M; j++) {
			int cnt = 0;
			for(int i=N-1; i>=0; i--) {
				if(map[i][j] == '.')	cnt++;
				else if(cnt > 0){
					map[i+cnt][j] = map[i][j];
					map[i][j] = '.';
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		group = new LinkedList<int[]>();
		int ans = 0;
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		while(true) {
			check();
			if(group.size() == 0)	break;
			bomb();
			down();
			ans++;
		}
		
		System.out.print(ans);
	}
}