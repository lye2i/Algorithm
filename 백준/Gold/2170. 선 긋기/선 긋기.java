import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point>{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point p) {
			if(p.x == this.x)	return this.y - p.y;
			return this.x - p.x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> point = new ArrayList<Point>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(point);
		
		int ans = point.get(0).y - point.get(0).x, cur = point.get(0).y;
		for(Point p : point) {
			if(p.y <= cur)	continue;
			
			if(p.x > cur)	ans += p.y - p.x;
			else	ans += p.y - cur;
			cur = p.y;
		}
		
		System.out.print(ans);
	}
}