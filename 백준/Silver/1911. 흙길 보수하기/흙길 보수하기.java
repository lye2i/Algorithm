import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Holl implements Comparable<Holl> {
		int s, e;
		Holl(int s, int e) {
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(Holl h) {
			return this.e - h.e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		ArrayList<Holl> list = new ArrayList<Holl>();
		int ans = 0, cur = -1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Holl(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		for(Holl h : list) {
			if(cur >= h.e)	continue;
			
			int n = cur < h.s ? h.e - h.s : h.e - h.s - (cur - h.s + 1);
			int cnt = 0;
			
			cnt += n / L;
			if(n % L > 0)	cnt++;
			
			cur = cur < h.s ? h.s + cnt*L - 1 : cur + cnt*L;
			ans += cnt;
		}
		
		System.out.print(ans);
	}
}