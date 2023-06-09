import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static Top[][] map;
	static Top[][] route;
	static PriorityQueue<Top> pq;
	static Top strong, week;
	static ArrayList<Top> list;
	static int R[] = {0,1,0,-1,1,-1,1,-1}, C[] = {1,0,-1,0,1,1,-1,-1};
	
	static class Top implements Comparable<Top>{
		int s, r, c, k;
		
		Top(int s, int r, int c, int k) {
			this.s = s;
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		@Override
		public int compareTo(Top a) {
			if(this.s != a.s)	return a.s - this.s;
			if(this.k != a.k)	return a.k - this.k;
			if((this.r+this.c) != (a.r+a.c))	return (this.r+this.c) - (a.r+a.c);
			return this.c - a.c;
		}	
	}
	
	private static void searchTop() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == null)	continue;
				else if(map[i][j].s <= 0)	map[i][j] = null;
				else	pq.add(map[i][j]);
			}
		}
	}
	
	private static void getTop() {
		strong = pq.poll();
		while(pq.size() > 1) {
			pq.poll();
		}
		week = pq.poll();
		week.s += (N+M);
		week.k = K;
	}
	
	private static void init() {
		route = new Top[N][M];
		list = new ArrayList<Top>();
		list.add(week);
		list.add(strong);
	}
	
	private static boolean laserCheck() {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[][] = new boolean[N][M];
		visit[week.r][week.c] = true;
		queue.add(new int[] {week.r, week.c});
		
		while(!queue.isEmpty()) {
			int t[] = queue.poll();
			if(t[0] == strong.r && t[1] == strong.c)	return true;
			
			for(int i=0; i<4; i++) {
				int dr = t[0] + R[i];
				int dc = t[1] + C[i];
				
				if(dr == -1)	dr = N-1;
				else if(dr == N)	dr = 0;
				if(dc == -1)	dc = M-1;
				else if(dc == M)	dc = 0;
				
				if(!visit[dr][dc] && map[dr][dc] != null){
					visit[dr][dc] = true;
					route[dr][dc] = map[t[0]][t[1]];
					queue.add(new int[] {dr,dc});
				}
			}
		}
		
		return false;
	}
	
	private static void laserAttack() {
		strong.s -= week.s;
		strong = route[strong.r][strong.c];
		while(strong != week) {
			list.add(strong);
			strong.s -= (week.s/2);
			strong = route[strong.r][strong.c];
		}
	}
	
	private static void bomb() {
		strong.s -= week.s;
		for(int i=0; i<8; i++) {
			int dr = strong.r + R[i];
			int dc = strong.c + C[i];
			
			if(dr == -1)	dr = N-1;
			else if(dr == N)	dr = 0;
			if(dc == -1)	dc = M-1;
			else if(dc == M)	dc = 0;
			
			if(map[dr][dc] == null || map[dr][dc] == week)	continue;
			
			map[dr][dc].s -= (week.s/2);
			list.add(map[dr][dc]);
		}
	}
	
	private static void destroyOrPlus() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == null)	continue;
				else if(map[i][j].s <= 0)	map[i][j] = null;
				else map[i][j].s++;
			}
		}
		
		for(Top t : list) {
			t.s--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Top[N][M];
		pq = new PriorityQueue<Top>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int s = Integer.parseInt(st.nextToken());
				if(s > 0)	map[i][j] = new Top(s, i, j, K);
			}
		}
		
		while(true) {
			searchTop();
			if(K-- == 0 || pq.size() == 1)	break;
			getTop();
			init();
			if(laserCheck())	laserAttack();
			else	bomb();
			destroyOrPlus();
		}
		
		System.out.print(pq.poll().s);
	}
}
