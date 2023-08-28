import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int N, M, B, T, map[][];
	static ArrayList<Point> virus, blank;
	static Queue<Point> queue;
	static boolean visit[][];
	
	static class Point {
		int x, y, t;
		Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	static void choose(int idx, int cnt, boolean select[]) {
		if(cnt == M) {
			selectVirus(select);
			T = Math.min(T, spreadVirus());
			return;
		}
		
		for(int i=idx; i<virus.size(); i++) {
			if(!select[i]) {
				select[i] = true;
				choose(i, cnt+1, select);
				select[i] = false;
			}
		}
	}
	
	static void selectVirus(boolean select[]) {
		visit = new boolean[N][N];
		
		for(int i=0; i<virus.size(); i++) {
			if(select[i]) {
				Point v = virus.get(i);
				queue.add(v);
				visit[v.x][v.y] = true;
			}
		}
	}
	
	static int spreadVirus() {
		int time = 0, cnt = 0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc] || map[dr][dc] == 1)	continue;
				if(map[dr][dc] == 0) {
					cnt++;
					time = Math.max(time, p.t+1);
				}
				
				visit[dr][dc] = true;
				queue.add(new Point(dr, dc, p.t+1));
			}
		}
		
		return cnt == B ? time : Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.MAX_VALUE;
		B = 0;
		map = new int[N][N];
		virus = new ArrayList<>();
		queue = new LinkedList<Point>();
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2)	virus.add(new Point(i, j, 0));
				else if(map[i][j] == 0) B++;
			}
		}
		
		choose(0, 0, new boolean[virus.size()]);
		
		System.out.print(T == Integer.MAX_VALUE ? -1 : T);
	}
}