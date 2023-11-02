import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int sticker[][] = new int[2][N+1];
			sticker[0][0] = 0; sticker[1][0] = 0;
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=2; i<=N; i++) {
				sticker[0][i] = Math.max(sticker[1][i-1], sticker[1][i-2]) + sticker[0][i];
				sticker[1][i] = Math.max(sticker[0][i-1], sticker[0][i-2]) + sticker[1][i];
			}
			
			sb.append(Math.max(sticker[0][N], sticker[1][N])).append('\n');
		}
		
		System.out.print(sb);
	}
}