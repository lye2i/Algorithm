import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int []arr;
	static int N;
	static int M;
	
	public static void P(int cnt, boolean[] check) {
		
		if(cnt==M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<cnt; i++)
				sb.append(arr[i]+" ");
			System.out.println(sb);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(check[i-1]==false) {
				check[i-1]=true;
				arr[cnt]=i;
				P(cnt+1, check);
				check[i-1]=false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		P(0,new boolean[N]);
	}
}