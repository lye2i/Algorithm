import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, idx;
	static int R[] = {-1, -1, 0, 1, 1, 1, 0, -1}, C[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static HashMap<Integer, Fire> fire;
	static ArrayList<Integer>[][] map;
	
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
		map = new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new ArrayList<Integer>();
			}
		}
	}
	
	static void move() {
		for(int i : fire.keySet()) {
			Fire f = fire.get(i);
			f.r = (f.r + R[f.d]*f.s + N*f.s) % N;
			f.c = (f.c + C[f.d]*f.s + N*f.s) % N;
			
			map[f.r][f.c].add(i);
			fire.put(i, f);
		}
	}
	
	static void combine() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() < 2)	continue;
				
				int max = 0, sum = 0, dir = 0, size = map[i][j].size();
				for(int k : map[i][j]) {
					Fire f = fire.get(k);
					max += f.m;
					dir += f.d%2;
					sum += f.s;
				}
				
				remove(map[i][j]);
				if(max/5 > 0)	divide(i, j, max/5, dir%size, sum/size);
			}
		}
	}
	
	static void divide(int r, int c, int m, int d, int s) {
		if(d == 0)	d = 0;
		else	d = 1;
		
		for(int i=d; i<8; i+=2) {
			fire.put(idx++, new Fire(r, c, m, s, i));
		}
	}
	
	static void remove(ArrayList<Integer> list) {
		for(int i : list) {
			fire.remove(i);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fire = new HashMap<Integer, Fire>();
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			fire.put(idx++, new Fire(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(K-- > 0) {
			init();
			move();
			combine();
		}
		
		int ans = 0;
		for(int i : fire.keySet()) {
			ans += fire.get(i).m;
		}
		System.out.print(ans);
	}
}