import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r[] = {-1, 0, 1, 0};
	static int c[] = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(map[i][j] == 'I') {
					boolean visit[][] = new boolean[N][M];
					Queue<int[]> queue = new LinkedList<int[]>();
					visit[i][j] = true;
					queue.add(new int[] {i, j});
					
					while(!queue.isEmpty()) {
						int p[] = queue.poll();
						
						for(int d=0; d<4; d++) {
							int dr = p[0] + r[d];
							int dc = p[1] + c[d];
							
							if(dr < 0 || dr >= N || dc < 0 || dc >= M || visit[dr][dc] || map[dr][dc] == 'X')	continue;
							if(map[dr][dc] == 'P')	cnt++;
							visit[dr][dc] = true;
							queue.add(new int[] {dr, dc});
						}
					}
					
					break;
				}
			}
		}
		
		System.out.print(cnt == 0 ? "TT" : cnt);
	}
}