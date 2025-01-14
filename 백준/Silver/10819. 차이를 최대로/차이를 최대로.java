import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans, num[];
	
	public static void calc(int idx, int arr[], boolean visit[]) {
		if(idx == N) {
			int max = 0;
			for(int i=2; i<=N; i++) {
				max += Math.abs(arr[i-2] - arr[i-1]);
			}
			ans = Math.max(ans, max);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[idx] = num[i];
				calc(idx+1, arr, visit);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		calc(0, new int[N], new boolean[N]);
		System.out.print(ans);
	}
}