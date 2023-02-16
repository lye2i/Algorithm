import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {0,1,1};
	static int dc[] = {1,0,1};
	static int N, ans, map[][];
	
	static void move(int r, int c, int flag) {
		
		if(r==N-1 && c==N-1) {
			ans++;
			return;
		}
		
		if(flag!=1) { //세로가 아니라면
			int nr = r+dr[0];
			int nc = c+dc[0];
			if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==0)
				move(nr,nc,0);
		}
		
		if(flag!=0) { //가로가 아니라면
			int nr = r+dr[1];
			int nc = c+dc[1];
			if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==0)
				move(nr,nc,1);
		}
		
		if(check(r,c)) // 모든 방향에서 대각선 확인
			move(r+dr[2], c+dc[2], 2);
			
	}
	
	static boolean check(int r, int c) {
		for(int d=0; d<3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];			
			if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==0)
				continue;
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(0,1,0);
		System.out.println(ans);
	}
}