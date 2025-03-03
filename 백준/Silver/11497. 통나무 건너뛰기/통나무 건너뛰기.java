import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(--T >= 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[N];
			int map[] = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			map[N/2] = arr[N-1];
			map[0] = arr[0];
			
			int idx = N-2;
			for(int i=1; i<N/2+N%2; i++) {
				map[N/2+i] = arr[idx--];
				map[N/2-i] = arr[idx--];
			}
			
			int min = Math.abs(map[0] - map[N-1]);
			for(int i=0; i<N-1; i++) {
				min = Math.max(min, Math.abs(map[i] - map[i+1]));
			}
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
}