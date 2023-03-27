import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r[] = {-1,0,1,0};
	static int c[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int A[][] = new int[N][M];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			if(A[R][C] == 0) {
				A[R][C] = 2;
				cnt++;
			}
			
			boolean flag = false;
			
			for(int d=0; d<4; d++) {
				int dr = R + r[d];
				int dc = C + c[d];
				if(dr >= 0 && dr < N && dc >= 0 && dc < M && A[dr][dc] == 0)	flag = true;
			}
			
			if(!flag) {
				int dr = R + r[(D+2)%4];
				int dc = C + c[(D+2)%4];
				if(dr >= 0 && dr < N && dc >= 0 && dc < M && A[dr][dc] != 1) {
					R = dr;
					C = dc;
				} 
				else	break;
			} else {
				for(int d=0; d<4; d++) {
					int dr = R + r[(D-d+3)%4];
					int dc = C + c[(D-d+3)%4];
					if(dr >= 0 && dr < N && dc >= 0 && dc < M && A[dr][dc] == 0) {
						R = dr;
						C = dc;
						D = (D-d+3)%4;
						break;
					}
				}
			}
		}
		
		System.out.print(cnt);
	}
}