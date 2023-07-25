import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int l[] = {0,0,0,0,-1,1}, r[] = {-1,0,1,0,0,0}, c[] = {0,1,0,-1,0,0};
	static int L, R, C;
	static char B[][][];
	
	static int move(int sl, int sr, int sc) {
		boolean visit[][][] = new boolean[L][R][C];
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[sl][sr][sc] = true;
		queue.add(new int[] {sl, sr, sc, 0});
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			if(B[p[0]][p[1]][p[2]] == 'E')	return p[3];
			
			for(int d=0; d<6; d++) {
				int dl = p[0] + l[d];
				int dr = p[1] + r[d];
				int dc = p[2] + c[d];
				if(dl < 0 || dl >= L || dr < 0 || dr >= R || dc < 0 || dc >= C || visit[dl][dr][dc] || B[dl][dr][dc] == '#')	continue;
				
				visit[dl][dr][dc] = true;
				queue.add(new int[] {dl, dr, dc, p[3]+1});
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			B = new char[L][R][C];

			if(L == 0)	break;
			
			int sl = 0, sr = 0, sc = 0;
			for(int i=0; i<L; i++) {
				for(int j=0; j<=R; j++) {
					String floor = br.readLine();
					if(j == R)	break;
					
					for(int k=0; k<C; k++) {
						B[i][j][k] = floor.charAt(k);
						if(B[i][j][k] == 'S') {
							sl = i;
							sr = j;
							sc = k;
						}
					}
				}
			}
			
			int m = move(sl, sr, sc);
			if(m == 0)	sb.append("Trapped!\n");
			else	sb.append("Escaped in ").append(m).append(" minute(s).\n");
		}
			
		System.out.print(sb);
	}
}