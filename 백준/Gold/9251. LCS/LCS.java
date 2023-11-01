import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str1[] = br.readLine().toCharArray();
		char str2[] = br.readLine().toCharArray();
		int N = str1.length, M = str2.length;
		int LCS[][] = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(str1[i-1] == str2[j-1])	LCS[i][j] = LCS[i-1][j-1]+1;
				else	LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		
		System.out.print(LCS[N][M]);
	}
}