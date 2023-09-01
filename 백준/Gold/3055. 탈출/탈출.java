import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int R, C;
	static char map[][];
	static boolean visitW[][], visitS[][];
	static Queue<Point> water, animal;
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void getPoint() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '*') {
					visitW[i][j] = true;
					water.add(new Point(i, j));
				} else if(map[i][j] == 'S') {
					visitS[i][j] = true;
					animal.add(new Point(i, j));
				}
			}
		}
	}
	
	static void moveWater() {
		int size = water.size();
		while(size-- > 0) {
			Point p = water.poll();
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				if(dr < 0 || dr >= R || dc < 0 || dc >= C || visitW[dr][dc] || map[dr][dc] == 'X' || map[dr][dc] == 'D')	continue;
				
				visitW[dr][dc] = true;
				map[dr][dc] = '*';
				water.add(new Point(dr, dc));
			}
		}
	}
	
	static boolean moveAnimal() {
		int size = animal.size();
		while(size-- > 0) {
			Point p = animal.poll();
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				
				if(dr < 0 || dr >= R || dc < 0 || dc >= C || visitS[dr][dc] || map[dr][dc] == 'X' || map[dr][dc] == '*')	continue;
				if(map[dr][dc] == 'D')	return true;
				visitS[dr][dc] = true;
				animal.add(new Point(dr, dc));
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visitW = new boolean[R][C];
		visitS = new boolean[R][C];
		water = new LinkedList<Point>();
		animal = new LinkedList<Point>();
		int T = 0;
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		getPoint();
		
		while(++T > 0) {
			moveWater();
			if(moveAnimal())	break;
			if(animal.size() == 0) {
				T = 0;
				break;
			}
		}
		
		System.out.println(T == 0 ? "KAKTUS" : T);
	}
}