import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r[] = {1,0,-1,0};
	static int c[] = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int answer = K * (K-1) / 2;
		int map[][] = new int[N][N];
		boolean visit[][] = new boolean[N][N];
		ArrayList<int[]> road = new ArrayList<int[]>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			road.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1});
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = i+1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					int cow = 0;
					Queue<int[]> queue = new LinkedList<int[]>();
					queue.add(new int[] {i,j});
					visit[i][j] = true;
					
					while(!queue.isEmpty()) {
						int g[] = queue.poll();
						if(map[g[0]][g[1]] != 0)	cow++;
						
						for (int d = 0; d < 4; d++) {
							int dr = g[0] + r[d];
							int dc = g[1] + c[d];
							
							if(dr >= 0 && dr < N && dc >= 0 && dc < N && !visit[dr][dc]) {
								for (int l = 0; l < road.size(); l++) {
									int street[] = road.get(l);
									
									if((street[0] == dr && street[1] == dc && street[2] == g[0] && street[3] == g[1]) || (street[0] == g[0] && street[1] == g[1] && street[2] == dr && street[3] == dc)) {
										break;
									}
									
									if(l == road.size()-1) {
										visit[dr][dc] = true;
										queue.add(new int[] {dr, dc});
									}
								}
							}
						}
					}
					
					answer -= cow * (cow-1) / 2;
				}
			}
		}
		
		System.out.print(answer);
	}
}