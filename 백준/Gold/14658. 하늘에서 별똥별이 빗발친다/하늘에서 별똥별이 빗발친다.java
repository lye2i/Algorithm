import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Star {
		int x, y;
		Star(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 0;
		ArrayList<Star> list = new ArrayList<Star>();
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(Star s1 : list) {
			for(Star s2 : list) {
				int cnt = 0;
				for(Star s : list) {
					if(s.x >= s1.x && s.x <= s1.x+L && s.y >= s2.y && s.y <= s2.y+L)	cnt++;
				}
				
				if(ans < cnt)	ans = cnt;
			}
		}
		
		System.out.print(K-ans);
	}
}