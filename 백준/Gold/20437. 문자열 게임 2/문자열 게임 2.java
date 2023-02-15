import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			char word[] = new char[26];
			int min = W.length(), max = 0;
			
			for(int i=0; i<W.length(); i++)
				word[W.charAt(i)-'a']++;
			
			for(int i=0; i<W.length(); i++) {
				if(word[W.charAt(i)-'a'] < K) continue;
				int cnt = 0;
				
				for(int j=i; j<W.length(); j++) {
					if(W.charAt(j) == W.charAt(i))	cnt++;
					if(cnt == K) {
						min = Math.min(min, j-i+1);
						max = Math.max(max, j-i+1);
						break;
					}
				}
			}
			
			if(max == 0)	sb.append(-1).append("\n");
			else	sb.append(min).append(" ").append(max).append("\n");
		}
		
		System.out.print(sb);
	}
}