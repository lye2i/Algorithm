import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int loc[] = {0, 0, 0, 0, 0, 0};
	static int dr[] = {0, 0, 0, -1, 1};
	static int dc[] = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		while(K-- > 0) {
			int k = Integer.parseInt(st.nextToken());
			int x = X + dr[k], y = Y + dc[k];

			if(x >= 0 && x < N && y >= 0 && y < M) {
				int tmp;
				switch(k) {
					case 1 : {
						tmp = loc[0];
						loc[0] = loc[2];
						loc[2] = loc[5];
						loc[5] = loc[3];
						loc[3] = tmp;
						break;
					}
					
					case 2 : {
						tmp = loc[0];
						loc[0] = loc[3];
						loc[3] = loc[5];
						loc[5] = loc[2];
						loc[2] = tmp;
						break;
					}
					
					case 3 : {
						tmp = loc[0];
						loc[0] = loc[1];
						loc[1] = loc[5];
						loc[5] = loc[4];
						loc[4] = tmp;
						break;
					}
					
					case 4 : {
						tmp = loc[0];
						loc[0] = loc[4];
						loc[4] = loc[5];
						loc[5] = loc[1];
						loc[1] = tmp;
						break;
					}
				}
				
				if(map[x][y] == 0)	map[x][y] = loc[0];
				else {
					loc[0] = map[x][y];
					map[x][y] = 0;
				}
				X = x; Y = y;
				sb.append(loc[5]).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}