import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = new int[N];
		int left = 0, right = 0, ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			T[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, T[i]);
		}
		
		while(left <= right) {
			int h = (left + right) / 2;
			long cnt = 0;
			
			for(int t : T) {
				if(t > h)	cnt += t - h;
			}
			
			if(cnt < M)	right = h - 1;
			else {
				ans = Math.max(ans, h);
				left = h + 1;
			}
		}
		
		System.out.print(ans);
	}
}