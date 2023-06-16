import java.io.*;
import java.util.*;

public class Main {
	static final int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	static int R, C, K, ans;
	static char M[][];
	
	static void road(int cnt, int x, int y, boolean visit[][]) {
		if(x == 0 && y == C-1) {
			if(cnt == K)	ans++;
			return;
		}

		for(int d=0; d<4; d++) {
			int dr = x + r[d];
			int dc = y + c[d];
			if(dr < 0 || dr >= R || dc < 0 || dc >= C || M[dr][dc] == 'T' || visit[dr][dc] || cnt >= K)	continue;
			visit[dr][dc] = true;
			road(cnt+1, dr, dc, visit);
			visit[dr][dc] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = new char[R][C];
		ans = 0;
		
		for(int i=0; i<R; i++) {
			M[i] = br.readLine().toCharArray();
		}
		
		boolean visit[][] = new boolean[R][C];
		visit[R-1][0] = true;
		road(1, R-1, 0, visit);
		
		System.out.print(ans);
	}
}