import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C_메이즈러너 {
	static final int r[] = {-1,1,0,0}, c[] = {0,0,-1,1};
	static int N, M, K, map[][], dx, dy, sum;
	static Queue<Person> persons;
	static class Person {
		int x, y;
		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sum = 0;
		map = new int[N][N];
		persons = new LinkedList<Person>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			persons.add(new Person(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
		}
		
		st = new StringTokenizer(br.readLine());
		dx = Integer.parseInt(st.nextToken())-1; dy = Integer.parseInt(st.nextToken())-1;
		
		while(K-- > 0) {
			move();
			if(persons.size() == 0)	break;
			getRect();
		}
		
		sb.append(sum).append('\n').append(dx+1).append(' ').append(dy+1);
		System.out.print(sb);
	}

	private static void move() {
		int size = persons.size();
		while(size-- > 0) {
			Person person = persons.poll();
			int tx = person.x, ty = person.y, min = Math.abs(person.x - dx) + Math.abs(person.y - dy);

			for(int d=0; d<4; d++) {
				int dr = person.x + r[d];
				int dc = person.y + c[d];
				if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] != 0)	continue;
				
				int dist = Math.abs(dr - dx) + Math.abs(dc - dy);
				if(min > dist) {
					min = dist;
					tx = dr;
					ty = dc;
				}
			}
			
			if(tx != person.x || ty != person.y) {
				sum++;
				person.x = tx;
				person.y = ty;
			}
			if(person.x != dx || person.y != dy)	persons.add(person);
		}
	}
	
	private static void getRect() {
		for(int k=1; k<N; k++) {
			for(int i=0; i+k<N; i++) {
				for(int j=0; j+k<N; j++) {
					if(dx < i || dx > i+k || dy < j || dy > j+k)	continue;
					if(rotatePerson(i, j, i+k, j+k)) {
						rotateDoor(i, j, i+k, j+k, k);
						return;
					};
				}
			}
		}
	}
	
    private static void rotateDoor(int sr, int sc, int er, int ec, int n) {
		int tx = dx, tmp[][] = new int[n+1][n+1];
		dx = sr + dy - sc;
		dy = er - tx + sc;
		
		for(int i = sr; i <= er; i++) {
			for(int j = sc; j <= ec; j++) {
				tmp[i - sr][j - sc] = map[er - (j-sc)][sc + (i-sr)];
			}
		}
		
		for(int i = sr; i <= sr+n; i++) {
			for(int j = sc; j <= sc+n; j++) {
				map[i][j] = tmp[i-sr][j-sc];
				if(map[i][j] > 0)	map[i][j]--;
			}
		}
	}
	
	private static boolean rotatePerson(int sr, int sc, int er, int ec) {
		boolean flag = false;
		int size = persons.size();
		while(size -- > 0) {
			Person person = persons.poll();
			if(person.x >= sr && person.x <= er && person.y >= sc && person.y <= ec) {
				int tx = person.x;
				person.x = sr + person.y - sc;
				person.y = er - tx + sc;
				flag = true;
			}
			
			persons.add(person);
		}
		
		return flag;
	}
}
