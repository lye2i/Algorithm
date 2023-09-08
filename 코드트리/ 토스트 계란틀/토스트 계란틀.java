package CodeTree;
// 삼성 SW 역량테스트 2018 하반기 오전 2번 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C_토스트계란틀 {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int N, L, R, map[][];
	static boolean visit[][];
	static Queue<Point> egg;
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean check() {
		visit = new boolean[N][N];
		boolean flag = false;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					int sum = moveEgg(new Point(i, j));
					
					if(egg.size() > 0) {
						egg.add(new Point(i, j));
						combineEgg(sum+map[i][j]);
						flag = true;
					}
				}
			}
		}
		
		return flag;
	}
	
	static int moveEgg(Point start) {
		int sum = 0;
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc])	continue;
				
				int e = Math.abs(map[dr][dc] - map[p.x][p.y]);
				if(e >= L && e <= R) {
					visit[dr][dc] = true;
					queue.add(new Point(dr, dc));
					egg.add(new Point(dr, dc));
					sum += map[dr][dc];
				}
			}
		}
		
		return sum;
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}System.out.println();
	}
	
	static void combineEgg(int sum) {
		int size = egg.size();
		
		while(!egg.isEmpty()) {
			Point p = egg.poll();
			map[p.x][p.y] = sum / size;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		egg = new LinkedList<Point>();
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(check()) {
			print();
			answer++;
		}
		
		System.out.print(answer);
	}
}
