import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine()), answer = 0;
		
		Arrays.sort(num);
		int left = 0, right = N-1;
		while(left < right) {
			if(num[left] + num[right] < X)	left++;
			else if(num[left] + num[right] > X)	right--;
			else {
				left++;
				answer++;
			}
		}
		
		System.out.print(answer);
	}
}