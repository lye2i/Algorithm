import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		int idx = 0, cnt = 0;
		
		while(idx < P.length()) {
			int max = 1;
			
			for(int i=0; i<S.length(); i++) {
				if(S.charAt(i) == P.charAt(idx)) {
					int j = 1;
					
					while(i+j < S.length() && idx+j < P.length()) {
						if(S.charAt(i+j) != P.charAt(idx+j))	break;
						j++;
					}
					
					max = Math.max(max, j);
				}
			}
			
			idx += max;
			cnt++;
		}
		
		System.out.print(cnt);
	}
}