import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, ans, arr[][];
	
	static void player(int n, int idx, int p[]) {
		if(n==3) {
			ans = Math.max(ans, game(p));
			return;
		}
		
		for(int i=idx; i<M; i++) {
			p[n] = i;
			player(n+1, i+1, p);			
		}
	}
	
	static int game(int p[]) {
		int m[][] = new int[N][M];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				m[i][j] = arr[i][j];
			}
		}
		
		while(!end(m)) {
			int enemy[][] = find(p,m);
			cnt += kill(enemy, m);
			move(m);
		}
		
		return cnt;
	}
	
	static int[][] find(int[] p, int[][] m) {
		int e[][] = new int[3][2];		
		for(int i=0; i<3; i++) {
			e[i][0] = -1;
		}
		
		for(int k=0; k<3; k++) {
			int r = N;
			int c = p[k];
			int min_d = D, min_c=M;

			for(int i=N-1; i>=0; i--) {
				for(int j=0; j<M; j++) {
					int d = Math.abs(r-i)+Math.abs(c-j);
					if(m[i][j]==1 && d<=min_d) {
						if(d<min_d) {
							min_d = d;
							min_c = j;
							e[k][0] = i;
							e[k][1] = j;
						}
						
						else if(min_d==d && min_c > j) {
							min_c = j;
							e[k][0] = i;
							e[k][1] = j;
						}
					}
				}
			}
		}
		
		return e;
	}
	
	static int kill(int[][] e, int[][] m) {
		int cnt = 0;
		for(int i=0; i<3; i++) {
			int r = e[i][0];
			int c = e[i][1];
			if(r!=-1 && m[r][c]==1) {
				m[r][c] = 0;
				cnt++;
			}
		}
		return cnt;
	}
	
	static void move(int[][] m) {
		for(int j=0; j<M; j++) {
			m[N-1][j] = 0;
			for(int i=N-2; i>=0; i--) {
				if(m[i][j]==1) {
					m[i+1][j] = 1;
					m[i][j] = 0;
				}
			}
		}
	}
	
	static boolean end(int m[][]) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(m[i][j]==1)	return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		ans = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		player(0,0,new int[3]);
		System.out.println(ans);
	}
}