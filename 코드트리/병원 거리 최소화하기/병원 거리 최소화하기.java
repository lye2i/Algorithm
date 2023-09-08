package CodeTree;
// 삼성 SW 역량테스트 2018 상반기 오후 2번 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C_병원거리최소화하기 {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int N, M, ans, map[][];
	static ArrayList<Point> hospital, person;
	static Point hp[];
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void combination(int idx, int cnt, boolean visit[]) {
		if(cnt == M) {
			int sum = 0;
			for(Point p : person) {
				sum += getDistance(p);
				if(sum >= ans) break;
			}
			
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i=idx; i<hospital.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				hp[cnt] = hospital.get(i);
				combination(i, cnt+1, visit);
				visit[i] = false;
			}
		}
	}
	
	static int getDistance(Point p) {
		int min = Integer.MAX_VALUE;
		for(Point h : hp) {
			min = Math.min(min, Math.abs(p.x - h.x)+Math.abs(p.y - h.y));
		}
		return min;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		hospital = new ArrayList<Point>();
		person = new ArrayList<Point>();
		hp = new Point[M];
		ans = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1)	person.add(new Point(i, j));
				else if(map[i][j] == 2)	hospital.add(new Point(i, j));
			}
		}
		
		combination(0, 0, new boolean[hospital.size()]);
		
		System.out.print(ans);
	}
}
