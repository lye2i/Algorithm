import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M[][] = new int[R][C];
		int S[][] = new int[R+1][C+1];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + M[i-1][j-1];
			}
		}
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			sb.append((S[r2][c2] - S[r1-1][c2] - S[r2][c1-1] + S[r1-1][c1-1]) / ((r2-r1+1)*(c2-c1+1))).append("\n");
		}
		
		System.out.print(sb);
	}
}