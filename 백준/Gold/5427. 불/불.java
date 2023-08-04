import java.io.*;
import java.util.*;

public class Main {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int W, H;
	static char[][] map;
	static Queue<Point> person, fire;
	static boolean visitFire[][], visitPerson[][];
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void getPoint() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] == '@') {
					visitPerson[i][j] = true;
					person.add(new Point(i, j));
				} else if(map[i][j] == '*') {
					visitFire[i][j] = true;
					fire.add(new Point(i, j));
				}
			}
		}
	}
	
	static void spreadFire() {
		int n = fire.size();
		while(n-- > 0) {
			Point p = fire.poll();
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				
				if(dr < 0 || dr >= H || dc < 0 || dc >= W || visitFire[dr][dc] || map[dr][dc] == '#')	continue;
				
				visitFire[dr][dc] = true;
				map[dr][dc] = '*';
				fire.add(new Point(dr, dc));
			}
		}
	}
	
	static boolean movePerson() {
		int n = person.size();
		while(n-- > 0) {
			Point p = person.poll();
			
			for(int d=0; d<4; d++) {
				int dr = p.x + r[d];
				int dc = p.y + c[d];
				
				if(dr < 0 || dr >= H || dc < 0 || dc >= W)	return true;
				if(visitPerson[dr][dc] || map[dr][dc] != '.')	continue;
				
				visitPerson[dr][dc] = true;
				person.add(new Point(dr, dc));
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			person = new LinkedList<Point>();
			fire = new LinkedList<Point>();
			visitFire = new boolean[H][W];
			visitPerson = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			getPoint();
			
			int cnt = 0;
			while(++cnt > 0) {
				if(person.size() == 0) {
					cnt = 0;
					break;
				}
				
				spreadFire();
				if(movePerson())	break;;
			}
			
			sb.append(cnt == 0 ? "IMPOSSIBLE" : cnt).append("\n");
		}
		
		System.out.print(sb);
	}
}