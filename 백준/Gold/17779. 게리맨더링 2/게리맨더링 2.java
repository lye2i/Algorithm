import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, min, total, A[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N+1][N+1];
		min = Integer.MAX_VALUE;
		total = 0;
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				total += A[i][j];
			}
		}
		
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				for(int d1 = 1; d1 < N; d1++) {
					for(int d2 = 1; d2 < N; d2++) {
						if(x+d1+d2 > N || y-d1 < 1 || y+d2 > N)	break;
						divide(x, y, d1, d2);
					}
				}
			}
		}
		
		System.out.print(min);
	}
	
	public static void divide(int x, int y, int d1, int d2) {
		boolean edge[][] = new boolean[N+1][N+1];
		int sum[] = new int[5];
		
		for(int i=0; i<=d1; i++) {
			edge[x+i][y-i] = true;
			edge[x+d2+i][y+d2-i] = true;
		}
		
		for(int i=0; i<=d2; i++) {
			edge[x+i][y+i] = true;
			edge[x+d1+i][y-d1+i] = true;
		}
		
		for(int r=1; r<x+d1; r++) {
			for(int c=1; c<=y; c++) {
				if(edge[r][c])	break;
				sum[0] += A[r][c];
			}
		}
		
		for(int r=1; r<=x+d2; r++) {
			for(int c=N; c>y; c--) {
				if(edge[r][c])	break;
				sum[1] += A[r][c];
			}
		}
		
		for(int r=x+d1; r<=N; r++) {
			for(int c=1; c<y-d1+d2; c++) {
				if(edge[r][c])	break;
				sum[2] += A[r][c];
			}
		}
		
		for(int r=x+d2+1; r<=N; r++) {
			for(int c=N; c>=y-d1+d2; c--) {
				if(edge[r][c])	break;
				sum[3] += A[r][c];
			}
		}
		
		sum[4] = total;
		for(int i=0; i<4; i++) {
			sum[4] -= sum[i];
		}
		
		Arrays.sort(sum);
		min = Math.min(min, sum[4]-sum[0]);
	}

}