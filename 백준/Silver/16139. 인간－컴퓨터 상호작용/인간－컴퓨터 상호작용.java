import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char word[] = br.readLine().toCharArray();
		int alpha[][] = new int[26][word.length+1];
		
		for(int i=0; i<26; i++) {
			for(int j=0; j<word.length; j++) {
				alpha[i][j+1] = alpha[i][j];
				if(word[j] == i + 'a')	alpha[i][j+1]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0)-97;
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			sb.append(alpha[a][r+1]-alpha[a][l]).append("\n");
		}
		
		System.out.print(sb);
	}
}