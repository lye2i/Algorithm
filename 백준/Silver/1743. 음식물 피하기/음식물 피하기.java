import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int r[] = {-1, 1, 0, 0};
	static final int c[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[N][M];
		boolean visit[][] = new boolean[N][M];
		int answer = 0;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j] || !map[i][j])	continue;
				
				Queue<int[]> queue = new LinkedList<int[]>();
				queue.add(new int[] {i, j});
				visit[i][j] = true;
				int cnt = 0;
				
				while(!queue.isEmpty()) {
					int food[] = queue.poll();
					cnt++;
					
					for(int d=0; d<4; d++) {
						int dr = food[0] + r[d];
						int dc = food[1] + c[d];
						
						if(dr < 0 || dr >= N || dc < 0 || dc >= M || !map[dr][dc] || visit[dr][dc])	continue;
						
						queue.add(new int[] {dr, dc});
						visit[dr][dc] = true;
					}
				}
				
				answer = Math.max(answer, cnt);
			}
		}
		
		System.out.print(answer);
	}
}