import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long A[] = new long[N];
		int S[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			S[i] = S[i-1];
			if(A[i-1] > A[i])	S[i]++;
		}
		
		int Q = Integer.parseInt(br.readLine());
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int q1 = Integer.parseInt(st.nextToken())-1;
			int q2 = Integer.parseInt(st.nextToken())-1;
			sb.append(S[q2]-S[q1]).append("\n");
		}
		
		System.out.print(sb);
	}
}