import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char ball[] = br.readLine().toCharArray();
		int R = 0, B = 0, rCnt = 0, bCnt = 0, answer = 500000;
		
		for(int i=0; i<N; i++) {
			if(ball[i] == 'R') {
				rCnt++;
				B += bCnt;
				bCnt = 0;
			} else {
				bCnt++;
				R += rCnt;
				rCnt = 0;
			}
		}
		
		answer = Math.min(R, B);
		
		R = 0; B = 0; rCnt = 0; bCnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(ball[i] == 'R') {
				rCnt++;
				B += bCnt;
				bCnt = 0;
			} else {
				bCnt++;
				R += rCnt;
				rCnt = 0;
			}
		}
		
		answer = Math.min(answer, Math.min(R, B));
		
		System.out.print(answer);
	}
}