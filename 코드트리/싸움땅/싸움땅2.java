import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C_싸움땅 {
	static int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int N, M, K, map[][];
	static Person person[];
	static PriorityQueue<Integer> gun[][];
	static class Person {
		int x, y, d, s, g, p;
		Person(int x, int y, int d, int s, int g, int p) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
			this.g = g;
			this.p = p;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		person = new Person[M];
		gun = new PriorityQueue[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				gun[i][j] = new PriorityQueue<Integer>(Collections.reverseOrder());
				int g = Integer.parseInt(st.nextToken());
				if(g > 0)	gun[i][j].add(g);
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, 0);
			map[person[i].x][person[i].y] = i+1;
		}
		
		while(K-- > 0) {
			for(Person p : person) {
				move(p);
			}
		}
		
		for(Person p : person) {
			sb.append(p.p).append(' ');
		}
		System.out.print(sb);
	}
	
	private static void move(Person p) {
		int idx = map[p.x][p.y];
		int dr = p.x + r[p.d];
		int dc = p.y + c[p.d];
		map[p.x][p.y] = 0;
		
		if(dr < 0 || dr >= N || dc < 0 || dc >= N) {
			p.d = (p.d + 2) % 4;
			dr = p.x + r[p.d];
			dc = p.y + c[p.d];
		}
		
		p.x = dr;
		p.y = dc;
		
		if(map[dr][dc] == 0) {
			getGun(dr, dc, p);
			map[dr][dc] = idx;
		} else {
			Person e = person[map[dr][dc]-1];
			int point = Math.abs((p.s + p.g) - (e.s + e.g));
			if(fight(p, e)) {
				p.p += point;
				loseMove(e, map[dr][dc]);
				getGun(dr, dc, p);
				map[dr][dc] = idx;
			} else {
				e.p += point;
				loseMove(p, idx);
				getGun(dr, dc, e);
			}
		}
	}
	
	private static void getGun(int dr, int dc, Person p) {
		if(gun[dr][dc].size() > 0 && p.g < gun[dr][dc].peek()) {
			if(p.g != 0)	gun[dr][dc].offer(p.g);
			p.g = gun[dr][dc].poll();
		}
	}
	
	private static boolean fight(Person p1, Person p2) {
		if((p1.s + p1.g) == (p2.s + p2.g))	return p1.s > p2.s;
		return (p1.s + p1.g) > (p2.s + p2.g);
	}
	
	private static void loseMove(Person p, int idx) {
		gun[p.x][p.y].add(p.g);
		p.g = 0;
		
		while(true) {
			int dr = p.x + r[p.d];
			int dc = p.y + c[p.d];
			if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] != 0)	p.d = (p.d+1)%4;
			else {
				map[dr][dc] = idx;
				p.x = dr;
				p.y = dc;
				getGun(dr, dc, p);
				break;
			}
		}
	}
}
