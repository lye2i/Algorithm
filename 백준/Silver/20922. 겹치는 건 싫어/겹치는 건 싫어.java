import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		int num[] = new int[100001];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0;
		while(start < N) {
			if(++num[A[end]] > K) {
				answer = Math.max(answer, end-start);
				while(start < end && num[A[start]] != num[A[end]]) {
					num[A[start]]--;
					start++;
				}
				num[A[start]]--;
				start++;
			}
			if(++end == N) {
				answer = Math.max(answer, end-start);
				break;
			}
		}
		
		System.out.print(answer);
	}
}