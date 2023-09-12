import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-1,0,0,1}, c[] = {0,-1,1,0};
	static int N, M, map[][];
	static Queue<Point> waitPerson, walkPerson;
	static Queue<Integer> arrivePerson;
	static Store store[];
	
	static class Point implements Comparable<Point>{
		int x, y, t;
		
		Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
		
		@Override
		public int compareTo(Point p) {
			if(p.t != this.t)	return this.t-p.t;
			else if(p.x != this.x)	return this.x-p.x;
			else	return this.y-p.y;
		}
	}
	
	static class Store {
		int x, y;
		Store(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void findCamp() {
		boolean visit[][] = new boolean[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		Point start = waitPerson.poll();
		visit[start.x][start.y] = true;
		pq.add(new Point(start.x, start.y, 0));
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(map[p.x][p.y] == 1)	{
				map[p.x][p.y] = -1;
				walkPerson.add(new Point(p.x, p.y, start.t));
				break;
			}
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc] || map[dr][dc] == -1)	continue;
				
				visit[dr][dc] = true;
				pq.add(new Point(dr, dc, p.t+1));
			}
		}
	}
	
	static void walk() {
		int size = walkPerson.size();
		while(size-- > 0) {
			Point person = walkPerson.poll();
			Store dest = store[person.t];
			if(Math.abs(person.x - dest.x) + Math.abs(person.y - dest.y) == 1)	arrivePerson.add(person.t);
			else	walking(dest, person);
		}
	}
	
	static void walking(Store dest, Point person) {
		boolean visit[][] = new boolean[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		visit[dest.x][dest.y] = true;
		pq.add(new Point(dest.x, dest.y, 0));
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				
				if(dr >= 0 && dr < N && dc >= 0 && dc < N && !visit[dr][dc]) {
					if(dr == person.x && dc == person.y) {
						walkPerson.add(new Point(p.x, p.y, person.t));
						return;
					}
					else if(map[dr][dc] == -1)	continue;
					
					visit[dr][dc] = true;
					pq.add(new Point(dr, dc, p.t+1));
				}
			}
		}
	}
	
	static void arrive() {
		while(!arrivePerson.isEmpty()) {
			Store s = store[arrivePerson.poll()];
			map[s.x][s.y] = -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		waitPerson = new LinkedList<Point>();
		walkPerson = new LinkedList<Point>();
		arrivePerson = new LinkedList<Integer>();
		store = new Store[M];
		int time = 1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			waitPerson.add(new Point(x, y, i));
			store[i] = new Store(x, y);
		}
		
		while(true) {
			if(!waitPerson.isEmpty())	findCamp();
			time++;
			walk();
			if(!arrivePerson.isEmpty())	arrive();
			
			if(waitPerson.isEmpty() && walkPerson.isEmpty())	break;
		}
		
		System.out.print(time);
	}
}
