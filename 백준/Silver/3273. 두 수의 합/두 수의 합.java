import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int left = 0, right = N-1, cnt = 0;
		
		while(left < right) {
			if(arr[left] + arr[right] == sum) {
				cnt++;
				left++;
			} else if(arr[left] + arr[right] < sum) {
				left++;
			} else {
				right--;
			}
		}
		
		System.out.print(cnt);
	}
}