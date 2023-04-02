import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char ball[] = br.readLine().toCharArray();
		int R = 0, B = 0, r = 0, b = 0, ans = 0;
		
		for(int i=0; i<N; i++) {
			if(ball[i] == 'R') {
				r++;
				B += b;
				b = 0;
			}
			else {
				b++;
				R += r;
				r = 0;
			}
		}
		
		ans = Math.min(R, B);
		
		R = 0; B = 0; r = 0; b = 0;		
		for(int i=N-1; i>=0; i--) {
			if(ball[i] == 'R') {
				r++;
				B += b;
				b = 0;
			}
			else {
				b++;
				R += r;
				r = 0;
			}
		}
		
		ans = Math.min(Math.min(R, B), ans);
		
		System.out.print(ans);
	}
}