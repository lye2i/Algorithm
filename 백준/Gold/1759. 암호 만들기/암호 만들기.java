import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char pw[];
	static StringBuilder sb;
	
	public static void makePW(int n, int idx, String s, boolean visit[]) {
		if(n == L) {
			if(check(s))	sb.append(s).append("\n");
			return;
		}
		
		for(int i=idx; i<C; i++) {
			if(!visit[i]) {
				visit[i] = true;
				makePW(n+1, i, s+pw[i], visit);
				visit[i] = false;
			}
		}
	}
	
	public static boolean check(String s) {
		int a = 0, b = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')	a++;
			else	b++;
		}
		return a == 0 || b < 2 ? false : true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pw = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			pw[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(pw);
		
		makePW(0, 0, "", new boolean[C]);
		System.out.print(sb);		
	}
}