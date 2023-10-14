package CodeTree;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C_포탑부수기 {
	static final int r[] = {0,1,0,-1,1,-1,1,-1}, c[] = {1,0,-1,0,1,-1,-1,1};
	static int N, M, K;
	static Top t1, t2, map[][];
	static LinkedList<Top> tops;
	static class Top implements Comparable<Top>{
		int x, y, p, k, t;
		Top(int x, int y, int p, int k, int t) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.k = k;
			this.t = t;
		}
		@Override
		public int compareTo(Top top) {
			if(top.p != this.p)	return this.p - top.p;
			else if(top.k != this.k)	return this.k - top.k;
			else if(top.x+top.y != this.x+this.y)	return (top.x+top.y) - (this.x+this.y);
			else	return top.y - this.y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Top[N][M];
		tops = new LinkedList<Top>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				Top top = new Top(i, j, Integer.parseInt(st.nextToken()), K, K);
				map[i][j] = top;
				if(top.p != 0)	tops.add(top);
			}
		}
		
		Collections.sort(tops);
		
		while(K-- > 0) {
			if(tops.size() == 1)	break;
			select();
			Point visit[][] = new Point[N][M];
			if(check(visit))	laserAttack(visit);
			else	bombAttack();
			destroyAndPlus();
		}
		
		System.out.print(tops.peekLast().p);
	}

	private static void destroyAndPlus() {
		Collections.sort(tops);
		
		while(tops.peekFirst().p <= 0) {
			tops.pollFirst();
		}
		
		for(Top t : tops) {
			if(t.t != K)	t.p++;
		}
		
		Collections.sort(tops);
	}

	private static void bombAttack() {
		for(int d=0; d<8; d++) {
			int dr = getPoint(t2.x + r[d], N);
			int dc = getPoint(t2.y + c[d], M);
			
			if(map[dr][dc].p > 0 && (dr != t1.x || dc != t1.y)) {
				map[dr][dc].p -= t1.p/2;
				map[dr][dc].t = K;
			}
		}
	}

	private static void laserAttack(Point visit[][]) {
		Point p = visit[t2.x][t2.y];
		while(p.x != t1.x || p.y != t1.y) {
			map[p.x][p.y].p -= t1.p/2;
			map[p.x][p.y].t = K;
			p = visit[p.x][p.y];
		}
	}

	private static boolean check(Point visit[][]) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(t1.x, t1.y));
		visit[t1.x][t1.y] = new Point(-1, -1);
		boolean flag = false;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == t2.x && p.y == t2.y) {
				flag = true;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int dr = getPoint(p.x + r[d], N);
				int dc = getPoint(p.y + c[d], M);
				
				if(visit[dr][dc] != null || map[dr][dc].p <= 0)	continue;
				
				visit[dr][dc] = p;
				queue.add(new Point(dr, dc));
			}
		}
		
		t2.p -= t1.p;
		t2.t = K;
		
		return flag;
	}
	
	private static int getPoint(int p, int n) {
		if(p < 0)	return	n-1;
		else if(p >= n)	return	0;
		else	return p;
	}

	private static void select() {
		t1 = tops.peekFirst();
		t2 = tops.peekLast();
		
		t1.p += (N+M);
		t1.k = K;
		t1.t = K;
	}
}
