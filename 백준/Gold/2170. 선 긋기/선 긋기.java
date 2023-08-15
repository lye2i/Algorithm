import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		Point point[] = new Point[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(point);
		
		int ans = point[0].y - point[0].x, cur = point[0].y;
		for(Point p : point) {
			if(p.y <= cur)	continue;
			
			if(p.x > cur)	ans += p.y - p.x;
			else	ans += p.y - cur;
			cur = p.y;
		}
		
		System.out.print(ans);
	}
}