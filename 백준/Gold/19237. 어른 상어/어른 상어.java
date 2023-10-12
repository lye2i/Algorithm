import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-1,1,0,0}, c[] = {0,0,-1,1};
	static int N, M, K, S, map[][], dir[][][];
	static Queue<int[]> queue;
	static Smell[][] smells;
	static Shark[] sharks;
	static class Shark {
		int n, x, y, d;
		
		Shark(int n, int x, int y, int d) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static class Smell {
		int n, k;
		
		Smell(int n, int k) {
			this.n = n;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		dir = new int[M][4][4];
		queue = new LinkedList<int[]>();
		smells = new Smell[N][N];
		sharks = new Shark[M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				smells[i][j] = new Smell(0, K);
				
				if(map[i][j] != 0) {
					sharks[map[i][j]-1] = new Shark(map[i][j]-1, i, j, 0);
					smells[i][j].n = map[i][j];
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sharks[i].d = Integer.parseInt(st.nextToken())-1;
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<4; k++) {
					dir[i][j][k] = Integer.parseInt(st.nextToken())-1;
				}
			}
		}
		
		int T = 0;
		while(T++ < 1000) {
			move();
			if(S == 1)	break;
			smell();
		}
		
		System.out.print(S == 1 ? T : -1);
	}

	private static void move() {
		for(Shark s : sharks) {
			if(s.x == -1)	continue;
			
			int mr = -1, mc = -1, md = -1;
			for(int d=0; d<4; d++) {
				int dr = s.x + r[dir[s.n][s.d][d]];
				int dc = s.y + c[dir[s.n][s.d][d]];
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= N) continue;
				
				if(smells[dr][dc].n == 0) {
					mr = dr;
					mc = dc;
					md = dir[s.n][s.d][d];
					break;
				}
				
				if(mr == -1 && smells[dr][dc].n == (s.n+1)) {
					mr = dr;
					mc = dc;
					md = dir[s.n][s.d][d];
				}
			}
			
			if(mr != -1) {
				map[s.x][s.y] = 0;
				
				if(map[mr][mc] == 0) {
					map[mr][mc] = s.n+1;
					s.x = mr; s.y = mc; s.d = md;
					queue.add(new int[] {s.n+1, mr, mc});
				} else {
					S--;
					s.x = -1;
				}
			}
		}
	}
	
	private static void smell() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(smells[i][j].n != 0 && --smells[i][j].k == 0) {
					smells[i][j].n = 0;
					smells[i][j].k = K;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			smells[p[1]][p[2]].n = p[0];
			smells[p[1]][p[2]].k = K;
		}
	}
}