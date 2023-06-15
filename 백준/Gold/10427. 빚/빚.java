import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A[] = new int[N];
			long S[] = new long[N+1];
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			
			for(int i=1; i<=N; i++) {
				S[i] = S[i-1] + (long)A[i-1];
			}

			long answer = 0;
			for(int i=1; i<N; i++) {
				long min = Long.MAX_VALUE;
				for(int j=i; j<N; j++) {
					min = Math.min(min, (long)A[j]*(i+1)-(S[j+1]-S[j-i]));
				}
				answer += min;
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
}