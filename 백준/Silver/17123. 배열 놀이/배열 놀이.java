import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int A[][] = new int[N][N];
			int S[][] = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					S[i][0] += A[i][j];
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					S[i][1] += A[j][i];
				}
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken())-1;
				int c1 = Integer.parseInt(st.nextToken())-1;
				int r2 = Integer.parseInt(st.nextToken())-1;
				int c2 = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				
				for(int r=r1; r<=r2; r++) {
					S[r][0] += v * (c2 - c1 + 1);
				}
				
				for(int c=c1; c<=c2; c++) {
					S[c][1] += v * (r2 - r1 + 1);
				}
			}
			
			for(int i=0; i<N; i++) {
				sb.append(S[i][0]+" ");
			}
			sb.append("\n");
			for(int i=0; i<N; i++) {
				sb.append(S[i][1]+" ");
			}
			sb.append("\n");			
		}
		
		System.out.print(sb.toString());
	}
}