import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[H][W];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			int h = Integer.parseInt(st.nextToken());
			for(int j=H-1; j>=H-h; j--) {
				map[j][i] = true;
			}
		}
		
		for(int i=H-1; i>=0; i--) {
			boolean flag = false;
			int cnt = 0;
			
			for(int j=0; j<W; j++) {
				if(map[i][j]) {
					if(!flag)	flag = true;
					else {
						answer += cnt;
						cnt = 0;
					}
				} else if(flag){
					cnt++;
				}
			}
		}
		
		System.out.print(answer);
	}
}