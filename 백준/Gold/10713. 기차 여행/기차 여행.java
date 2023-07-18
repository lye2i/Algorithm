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
		int B[] = new int[N];
		int C[] = new int[N];
		int D[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken())-1;
		for(int i=1; i<M; i++) {
			int p2 = Integer.parseInt(st.nextToken())-1;
			if(p1 > p2) {
				D[p1]--;
				D[p2]++;
			} else {
				D[p1]++;
				D[p2]--;
			}
			p1 = p2;
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0, cnt = 0;
		for(int i=1; i<N; i++) {
			cnt += D[i-1];
			answer += Math.min(A[i]*cnt, B[i]*cnt+C[i]);
		}
		
		System.out.print(answer);
	}
}