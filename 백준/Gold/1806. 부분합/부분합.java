import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		int answer = N+1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right = 1, sum = A[0];
		while(left < right) {
			if(sum < S) {
				if(right < N)	sum += A[right++];
				else	break;
			} else {
				answer = Math.min(answer, right - left);
				sum -= A[left++];
			}
		}
		
		System.out.print(answer == N+1 ? 0 : answer);
	}
}