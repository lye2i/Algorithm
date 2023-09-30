import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean sign[];
	static String min, max;
	
	static void permutation(int idx, int n, int num[], boolean visit[]) {
		if(idx == N+1) {
			StringBuilder sb = new StringBuilder();
			for(int i : num) {
				sb.append(i);
			}
			
			if(min.compareTo(sb.toString()) > 0)	min = sb.toString();
			if(max.compareTo(sb.toString()) < 0)	max = sb.toString();
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(visit[i])	continue;
			if(idx == 0 || (sign[idx-1] && n < i) || (!sign[idx-1] && n > i)) {
				num[idx] = i;
				visit[i] = true;
				permutation(idx+1, i, num, visit);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sign = new boolean[N];
		min = "999999999"; max = "";
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sign[i] = st.nextToken().equals("<") ? true : false;
		}
		
		permutation(0, 0, new int[N+1], new boolean[10]);
		
		System.out.print(max+"\n"+min);
	}
}