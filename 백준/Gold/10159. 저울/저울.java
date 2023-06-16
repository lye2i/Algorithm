import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int A[][] = new int[N][N];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			A[n1][n2] = 1;
			A[n2][n1] = -1;
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(A[i][k] == 1 && A[k][j] == 1) {
						A[i][j] = 1;
						A[j][i] = -1;
					}
					if(A[i][k] == -1 && A[k][j] == -1) {
						A[i][j] = -1;
						A[j][i] = 1;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			int cnt = N-1;
			for(int j=0; j<N; j++) {
				if(A[i][j] != 0)	cnt--;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
}