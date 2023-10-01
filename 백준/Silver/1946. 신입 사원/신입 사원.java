import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int person[][] = new int[N][2];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				person[i][0] = Integer.parseInt(st.nextToken());
				person[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(person, (a, b) -> a[0] - b[0]);
			
			int min = N+1, cnt = 0;
			for(int p[] : person) {
				if(p[1] < min) {
					min = p[1];
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.print(sb);
	}
}