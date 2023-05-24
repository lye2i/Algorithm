import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		boolean V[] = new boolean[N+1];
		long F[] = new long[N+1];
		
		Arrays.fill(F, 1);
		for(int i=1; i<=N; i++) {
			F[i] = F[i-1]*i;
		}
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		
		if(P == 1) {
			long K = Long.parseLong(st.nextToken());
			for(int i=0; i<N; i++) {
				for(int j=1; j<=N; j++) {
					if(V[j])	continue;
					if(F[N-i-1] < K)	K -= F[N-i-1];
					else {
						A[i] = j;
						V[j] = true;
						break;
					}
				}
			}
			
			for(int i : A) {
				sb.append(i).append(" ");
			}
		} else {
			long ans = 1;			
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				for(int j=1; j<A[i]; j++) {
					if(!V[j])	ans += F[N-i-1];
				}
				V[A[i]] = true;
			}
			
			sb.append(ans);
		}
		
		System.out.print(sb);
	}
}