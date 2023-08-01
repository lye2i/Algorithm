import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N/2+1];
		int B[] = new int[N/2+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			if(i%2 == 0) A[i/2+1] = A[i/2] + Integer.parseInt(st.nextToken());
			else	B[i/2+1] = B[i/2] + Integer.parseInt(st.nextToken());
		}

		int max = Math.max(A[N/2], B[N/2]);
		for(int i=1; i<N/2; i++) {
			max = Math.max(B[N/2]-B[i]+A[i], max);
			max = Math.max(A[i]+(B[N/2-1]-B[i-1]), max);
		}
		
		System.out.print(max);
	}
}