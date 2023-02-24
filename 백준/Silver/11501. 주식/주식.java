import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day[] = new int[N];
			long buy = 0;
			int max = 0;
			
			for(int i=0; i<N; i++)
				day[i] = Integer.parseInt(st.nextToken());
			
			for(int i=N-1; i>=0; i--) {
				if(max < day[i])	max = day[i];
				else	buy += (max - day[i]);
			}
			
			sb.append(buy).append("\n");
		}
		
		System.out.print(sb);
	}
}