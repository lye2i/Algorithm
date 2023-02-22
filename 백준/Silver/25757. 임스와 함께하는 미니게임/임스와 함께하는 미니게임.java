import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> set = new HashSet<String>();
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0, plus = 1, answer = 0;
		String game = st.nextToken();
		
		if(game.equals("F"))	plus = 2;
		else if(game.equals("O")) plus = 3;
		
		while(N-- > 0) {
			set.add(br.readLine());
			if(set.size() == cnt+plus) {
				answer++;
				cnt += plus;
			}
		}
		
		System.out.print(answer);
	}

}