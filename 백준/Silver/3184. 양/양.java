import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int r[] = {-1, 0, 1, 0};
	final static int c[] = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char map[][] = new char[R][C];
		boolean visit[][] = new boolean[R][C];
		int S = 0, W = 0;
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!visit[i][j] && map[i][j] != '#') {
					int s = 0, w = 0;
					Queue<int[]> queue = new LinkedList<int[]>();
					visit[i][j] = true;
					queue.add(new int[] {i, j});
					
					while(!queue.isEmpty()) {
						int g[] = queue.poll();
						
						if(map[g[0]][g[1]] == 'o')	s++;
						else if(map[g[0]][g[1]] == 'v')	w++;
						
						for(int d=0; d<4; d++) {
							int dr = g[0] + r[d];
							int dc = g[1] + c[d];
							
							if(dr < 0 || dr >= R || dc < 0 || dc >= C || visit[dr][dc] || map[dr][dc] == '#')	continue;
							
							visit[dr][dc] = true;
							queue.add(new int[] {dr,dc});
						}
					}
					
					if(s > w)	w = 0;
					else	s = 0;
					
					S += s;
					W += w;
				}
			}
		}
		
		System.out.print(S + " " + W);
	}
}