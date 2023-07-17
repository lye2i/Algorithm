import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		char map[][] = new char[N][M];
		int area[][][] = new int[N+1][M+1][3];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				area[i][j][0] = area[i-1][j][0] + area[i][j-1][0] - area[i-1][j-1][0];
				area[i][j][1] = area[i-1][j][1] + area[i][j-1][1] - area[i-1][j-1][1];
				area[i][j][2] = area[i-1][j][2] + area[i][j-1][2] - area[i-1][j-1][2];
				
				if(map[i-1][j-1] == 'J')	area[i][j][0]++;
				else if(map[i-1][j-1] == 'O')	area[i][j][1]++;
				else	area[i][j][2]++;
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			sb.append(area[c][d][0]-area[a-1][d][0]-area[c][b-1][0]+area[a-1][b-1][0]).append(" ");
			sb.append(area[c][d][1]-area[a-1][d][1]-area[c][b-1][1]+area[a-1][b-1][1]).append(" ");
			sb.append(area[c][d][2]-area[a-1][d][2]-area[c][b-1][2]+area[a-1][b-1][2]).append("\n");
		}
		
		System.out.print(sb);
	}
}