import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static int N, arr[][], ans = Integer.MIN_VALUE;
	
	static void baseball(int idx, boolean visit[], int game[]) {
		if(idx==3) {
			game[idx] = 0;
			baseball(idx+1, visit, game);
		}
		
		if(idx==9) {
			ans = Math.max(ans, Score(game));
			return;
		}
		
		for(int i=1; i<9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				game[idx] = i;
				baseball(idx+1, visit, game);
				visit[i] = false;
			}
		}
	}
	
	static int Score(int game[]) {
		int idx=0, score=0;		
		for(int n=0; n<N; n++) {
			boolean base[] = new boolean[4];
			int zero=0;
			
			while(zero<3) {
				int turn = arr[n][game[idx++%9]];
				if(turn==0) {
					zero++;
					continue;
				}
			
				for(int i=3; i>=0; i--) {
					if(i!=0 && !base[i])	continue;
					if(i+turn>=4)	score++;
					else	base[i+turn] = true;
					base[i] = false;
				}
			}		
		}
		
		return score;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		baseball(0,new boolean[9], new int[9]);
		System.out.println(ans);
	}
}