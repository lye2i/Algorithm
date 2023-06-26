import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		if(K < N) {
			Arrays.sort(A);
			
			int D[] = new int[N-1];
			for(int i=0; i<N-1; i++) {
				D[i] = A[i+1] - A[i];
			}
			Arrays.sort(D);
			
			for(int i=0; i<N-K; i++) {
				answer += D[i];
			}
		}
		
		System.out.print(answer);
	}
}