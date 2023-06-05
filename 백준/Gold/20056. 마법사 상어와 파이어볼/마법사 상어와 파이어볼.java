import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, idx;
	static int R[] = {-1, -1, 0, 1, 1, 1, 0, -1}, C[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static Queue<Fire> fire;
	static Queue<Fire>[][] map;
	
	static class Fire {
		int r, c, m, s, d;
		
		Fire(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static void init() {
		fire = new LinkedList<Fire>();
		map = new LinkedList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new LinkedList<Fire>();
			}
		}
	}
	
	static void move() {
		while(!fire.isEmpty()) {
			Fire f = fire.poll();
			f.r = (f.r + R[f.d]*f.s + N*f.s) % N;
			f.c = (f.c + C[f.d]*f.s + N*f.s) % N;
			
			map[f.r][f.c].add(f);
		}
	}
	
	static void combine() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() == 1)	fire.add(map[i][j].poll());
				
				else if(map[i][j].size() > 1) {
					int max = 0, sum = 0, dir = 0, size = map[i][j].size();
					while(!map[i][j].isEmpty()) {
						Fire f = map[i][j].poll();
						max += f.m;
						dir += f.d%2;
						sum += f.s;
					}
					if(max/5 > 0)	divide(i, j, max/5, dir%size, sum/size);
				}
			}
		}
	}
	
	static void divide(int r, int c, int m, int d, int s) {
		if(d == 0)	d = 0;
		else	d = 1;
		
		for(; d<8; d+=2) {
			fire.add(new Fire(r, c, m, s, d));
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		init();
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			fire.add(new Fire(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(K-- > 0) {
			move();
			combine();
		}
		
		int ans = 0;
		while(!fire.isEmpty()) {
			ans += fire.poll().m;
		}
		System.out.print(ans);
	}
}