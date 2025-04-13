import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int r[] = {-1, 0, 1, 0}, c[] = {0, 1, 0, -1};
	static int R, C, K, answer;
	static char map[][];
	
	public static void search(int x, int y, int k, boolean visit[][]) {
		if(x == 0 && y == C-1 && k == K) {
			answer++;
			return;
		}
		
		for(int d=0; d<4; d++) {
			int dr = x + r[d];
			int dc = y + c[d];
			if(dr < 0 || dr >= R || dc < 0 || dc >= C || map[dr][dc] == 'T' || visit[dr][dc] || k + 1 > K)	continue;
			visit[dr][dc] = true;
			search(dr, dc, k+1, visit);
			visit[dr][dc] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		boolean visit[][] = new boolean[R][C];
		visit[R-1][0] = true;
		search(R-1, 0, 1, visit);
		
		System.out.print(answer);	
	}
}