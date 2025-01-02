import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int r[] = {1, 1, 0};
	final static int c[] = {0, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		int answer = 1;
		
		for(int i=0; i<N; i++) {
			char arr[] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = (int)arr[j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int t = 1;
				boolean flag = true;
				
				while(flag) {
					int cnt = 0;
					
					for(int k=0; k<3; k++) {
						int dr = i + r[k]*t;
						int dc = j + c[k]*t;
						
						if(dr < 0 || dr >= N || dc < 0 || dc >= M) {
							flag = false;
							break;
						} else if(map[dr][dc] == map[i][j]){
							cnt++;
						}
					}
					
					if(cnt == 3)	answer = Math.max(answer, (t+1));
					t++;
				}
			}
		}
		
		System.out.print(answer*answer);	
	}
}