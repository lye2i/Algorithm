import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, num[], min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	
	public static void cal(int idx, int op[], int arr[]) {
		if(idx == N-1) {
			int n = num[0];
			for(int i=0; i<N-1; i++) {
				if(arr[i] == 0)	n += num[i+1];
				else if(arr[i] == 1) n -= num[i+1];
				else if(arr[i] == 2) n *= num[i+1];
				else {
					n = (n > 0) ? n/num[i+1] : -(Math.abs(n)/num[i+1]);
				}
			}
			
			min = Math.min(min, n);
			max = Math.max(max, n);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				arr[idx] = i;
				op[i]--;
				cal(idx+1, op, arr);
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		int op[] = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		cal(0, op, new int[N-1]);
		
		System.out.print(max+"\n"+min);
	}
}