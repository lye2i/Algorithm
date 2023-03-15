import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, T[][], S[], L[], ans = Integer.MAX_VALUE;
	
	public static void divideTeam(boolean team[], int idx, int cnt) {
		if(cnt == N/2) {
			int s = 0, l = 0;
			for(int i=0; i<N; i++) {
				if(team[i])	S[s++] = i;
				else	L[l++] = i;
			}
			
			ans = Math.min(ans, score());
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!team[i]) {
				team[i] = true;
				if(team[0] && ans != 0)	divideTeam(team, i, cnt+1);
				team[i] = false;
			}
		}
	}
	
	public static int score() {
		int sumS = 0, sumL = 0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				if(i == j)	continue;
				sumS += T[S[i]][S[j]];
				sumL += T[L[i]][L[j]];
			}
		}
		
		return Math.abs(sumS - sumL);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N][N];
		S = new int[N/2];
		L = new int[N/2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				T[i][j] = Integer.parseInt(st.nextToken());
		}
		
		divideTeam(new boolean[N], 0, 0);
		
		System.out.print(ans);
	}
}