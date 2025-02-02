import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int r[] = {-1, 0, 1, 0};
	final static int c[] = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());
		int clean = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(map[sr][sc] == 0) {
				map[sr][sc] = 2;
				clean++;
			}
			
			boolean go = false;
			
			for(int d=0; d<4; d++) {
				int dr = sr + r[d];
				int dc = sc + c[d];
				if(dr >= 0 && dr < N && dc >= 0 && dc < M && map[dr][dc] == 0)	go = true;
			}
			
			if(!go) {
				int gr = sr + r[(sd+2)%4];
				int gc = sc + c[(sd+2)%4];
				if(gr < 0 || gr >= N || gc < 0 || gc >= M || map[gr][gc] == 1)	break;
				else {
					sr = gr;
					sc = gc;
				}
			} else {
				for(int k=3; k>=0; k--) {
					int gr = sr + r[(sd + k) % 4];
					int gc = sc + c[(sd + k) % 4];
					if(gr >= 0 && gr < N && gc >= 0 && gc < M && map[gr][gc] == 0) {
						sr = gr;
						sc = gc;
						sd = (sd + k) % 4;
						break;
					}
				}
			}
		}
		
		System.out.print(clean);
	}
}