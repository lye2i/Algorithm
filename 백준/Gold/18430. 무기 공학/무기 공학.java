import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B[][], ans = 0;
	static int r[][] = {{0,1}, {0,-1}, {-1,0}, {0,1}};
	static int c[][] = {{-1,0}, {-1,0}, {0,1}, {1,0}};
	
	public static void make(boolean visit[][], int i, int j, int cnt) {
		if(i == N-1 && j == M) {
			ans = Math.max(ans, cnt);
			return;
		}
		
		if(j == M) {
			i++;
			j = 0;
		}
		
		if(!visit[i][j]) {
			for(int d=0; d<4; d++) {
				if(checkRange(visit, i, j, d)) {
					int sum = checkVisit(visit, i, j, d);
					make(visit, i, j+1, cnt+sum);
					backVisit(visit, i, j, d);
				}
			}
		}
		
		make(visit, i, j+1, cnt);
	}
	
	public static boolean checkRange(boolean visit[][], int x, int y, int d) {
		for(int i=0; i<2; i++) {
			int dr = x + r[d][i];
			int dc = y + c[d][i];
			if(dr < 0 || dr >= N || dc < 0 || dc >= M || visit[dr][dc])	return false;
		}
		return true;
	}
	
	public static int checkVisit(boolean visit[][], int x, int y, int d) {
		int sum = 2*B[x][y];
		visit[x][y] = true;
		
		for(int i=0; i<2; i++) {
			int dr = x + r[d][i];
			int dc = y + c[d][i];
			visit[dr][dc] = true;
			sum += B[dr][dc];
		}
		
		return sum;
	}
	
	public static void backVisit(boolean visit[][], int x, int y, int d) {
		visit[x][y] = false;
		for(int i=0; i<2; i++) {
			int dr = x + r[d][i];
			int dc = y + c[d][i];
			visit[dr][dc] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		make(new boolean[N][M], 0, 0, 0);
		
		System.out.print(ans);
	}
}