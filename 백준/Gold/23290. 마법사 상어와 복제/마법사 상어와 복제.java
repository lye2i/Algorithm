import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int N = 4, r8[] = {0,-1,-1,-1,0,1,1,1}, c8[] = {-1,-1,0,1,1,1,0,-1}, r4[] = {-1,0,1,0}, c4[] = {0,-1,0,1};
	static int M, S, sx, sy, max, route[], map[][];
	static ArrayList<Fish> fish[][];
	static Queue<Fish> copy, move;
	
	static class Fish {
		int x, y, d;
		Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		fish = new ArrayList[N][N];
		move = new LinkedList<Fish>();
		copy = new LinkedList<Fish>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				fish[i][j] = new ArrayList<Fish>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			Fish f = new Fish(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			fish[f.x][f.y].add(f);
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1; sy = Integer.parseInt(st.nextToken())-1;
		
		while(S-- > 0) {
			copyFish();
			moveFish();
			
			max = -1; route = new int[3];
			findRoute(sx, sy, new int[3], 0);
			moveShark();
			deleteSmell();
			copyMagic();
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				answer += fish[i][j].size();
			}
		}
		System.out.print(answer);
	}

	
	private static void copyMagic() {
		while(!copy.isEmpty()) {
			Fish f = copy.poll();
			fish[f.x][f.y].add(f);
		}
	}

	private static void deleteSmell() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] < 0)	map[i][j]++;
			}
		}
	}

	private static void moveShark() {
		for(int i : route) {
			sx = sx + r4[i];
			sy = sy + c4[i];

			if(fish[sx][sy].size() > 0) {
				fish[sx][sy].clear();
				map[sx][sy] = -3;
			}
		}
	}

	private static void findRoute(int sr, int sc, int dir[], int cnt) {
		if(cnt == 3) {
			boolean visit[][] = new boolean[N][N];
			int dr = sx, dc = sy, sum = 0;
			
			for(int d : dir) {
				dr += r4[d];
				dc += c4[d];
				
				if(!visit[dr][dc]) {
					visit[dr][dc] = true;
					sum += fish[dr][dc].size();
				}
			}
			
			if(sum > max) {
				max = sum;
				for(int i=0; i<3; i++) {
					route[i] = dir[i];
				}
			}
			return;
		}
		
		for(int d=0; d<N; d++) {
			int dr = sr + r4[d];
			int dc = sc + c4[d];
			if(dr < 0 || dr >= N || dc < 0 || dc >= N)	continue;
			
			dir[cnt] = d;
			findRoute(dr, dc, dir, cnt+1);
		}
	}

	private static void moveFish() {
		while(!move.isEmpty()) {
			Fish f = move.poll();
			int nx = f.x, ny = f.y, nd = f.d;

			for(int i=0; i<r8.length; i++) {
				int d = f.d - i < 0 ? f.d - i + 8 : f.d - i;
				int dr = f.x + r8[d];
				int dc = f.y + c8[d];

				if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] != 0 || (dr == sx && dc == sy))	continue;
				nx = dr; ny = dc; nd = d;
				break;
			}

			fish[nx][ny].add(new Fish(nx, ny, nd));
		}
	}

	private static void copyFish() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(Fish f : fish[i][j]) {
					move.add(f);
					copy.add(f);
				}
				
				fish[i][j].clear();
			}
		}
	}
}