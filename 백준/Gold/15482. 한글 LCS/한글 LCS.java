import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int N = str1.length(), M = str2.length(), answer = 0;
		int LCS[][] = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1))	LCS[i][j] = LCS[i-1][j-1] + 1;
				else	LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
				answer = Math.max(answer, LCS[i][j]);
			}
		}
		
		System.out.print(LCS[N][M]);
	}
}