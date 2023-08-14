import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(A);
		
		int left = 0, right = 1, ans = Integer.MAX_VALUE;
		while(right < N && left <= right) {
			if(A[right] - A[left] < M)	right++;
			else {
				ans = Math.min(ans, A[right] - A[left]);
				left++;
			}
		}
		
		System.out.print(ans);
	}
}