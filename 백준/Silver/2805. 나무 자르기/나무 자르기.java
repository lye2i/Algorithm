import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			T[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(T);
		
		int left = 0, right = T[N-1], ans = 0;
		while(left <= right) {
			int h = (left + right) / 2;
			
			if(!check(h))	right = h - 1;
			else {
				ans = Math.max(ans, h);
				left = h + 1;
			}
		}
		
		System.out.print(ans);
	}
	
	public static boolean check(int h) {
		long cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(T[i] - h > 0)	cnt += (long)(T[i] - h);
			else	break;
		}
		return cnt >= M ? true : false;
	}
}