import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, P, X, answer, num[];
	static boolean number[][] = {{true, true, true, true, true, true, false}, {false, true, true, false, false, false, false}, 
			{true, true, false, true, true, false, true}, {true, true, true, true, false, false, true},
			{false, true, true, false, false, true, true}, {true, false, true, true, false, true, true},
			{true, false, true, true, true, true, true}, {true, true, true, false, false, false, false},
			{true, true, true, true, true, true, true}, {true, true, true, true, false, true, true}};
	
	static void reverse(int cnt, int idx, int floor, int led[]) {
		if(idx == K) {
			if(floor != 0 && floor != X)	answer++;
			return;
		}
		
		for(int i=0; i<10; i++) {
			int n = (int)Math.pow(10, (K-idx-1)) * i + floor;
			
			if(n <= N) {
				int r = 0;
				for(int j=0; j<7; j++) {
					if(number[num[idx]][j] != number[i][j])	r++;
				}

				if(r+cnt <= P) {
					led[idx] = i;
					reverse(cnt+r, idx+1, n, led);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		num = new int[K];
		int idx = K, n = X;
		
		while(idx-- > 0) {
			num[idx] = n % 10;
			n /= 10;
		}
		
		reverse(0, 0, 0, new int[K]);
		
		System.out.print(answer);
	}
}