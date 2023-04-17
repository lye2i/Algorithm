import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, L[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		L = new int[M];
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1, right = N;
		while(left <= right) {
			int mid = (left+right)/2;
			
			if(possible(mid)) {
				answer = mid;
				right = mid - 1;
			}
			else	left = mid + 1;
		}
		
		System.out.print(answer);
	}
	
	private static boolean possible(int mid) {
		int prev = 0;
		for(int i=0; i<M; i++) {
			if(L[i] - mid <= prev)	prev = L[i] + mid;
			else	return false;
		}
		return N-prev <= 0;
	}
}