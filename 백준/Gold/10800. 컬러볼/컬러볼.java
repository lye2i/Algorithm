import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Ball implements Comparable<Ball>{
		int n, c, s;
		
		Ball(int n, int c, int s) {
			this.n = n;
			this.c = c;
			this.s = s;
		}
		
		@Override
		public int compareTo(Ball b) {
			return this.s - b.s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Ball> list = new ArrayList<Ball>();
		int sum[] = new int[N+1];
		int answer[] = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		for(int i=0, j=0; i<N; i++) {
			Ball ball = list.get(i);
			
			while(list.get(j).s < ball.s) {
				Ball next = list.get(j++);
				sum[0] += next.s;
				sum[next.c] += next.s;
			}
			
			answer[ball.n] = sum[0] - sum[ball.c];
		}
		
		for(int ans : answer) {
			sb.append(ans).append('\n');
		}
		System.out.print(sb);
	}
}