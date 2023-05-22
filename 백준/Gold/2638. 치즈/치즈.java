import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][];
	static boolean visit[][];
	static int r[] = {0,0,1,-1,1,1,-1,-1}, c[] = {1,-1,0,0,-1,1,1,-1};
	
	public static void outside() {
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[0][0] = true;
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int b[] = queue.poll();
			
			for(int i=0; i<4; i++) {
				int dr = b[0] + r[i];
				int dc = b[1] + c[i];
				if(dr >= 0 && dr < N && dc >= 0 && dc < M && map[dr][dc] == 0 && !visit[dr][dc]) {
					visit[dr][dc] = true;
					queue.add(new int[] {dr, dc});
				}
			}
		}
	}
	
	public static void cheese(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[x][y] = true;
		queue.add(new int[] {x, y});
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		while(!queue.isEmpty()) {
			int b[] = queue.poll();
			int cnt = 0;
			
			for(int i=0; i<8; i++) {
				int dr = b[0] + r[i];
				int dc = b[1] + c[i];
				if(dr < 0 || dr >= N || dc < 0 || dc >= M)	continue;
				
				if(i < 4 && map[dr][dc] == 0 && visit[dr][dc])	cnt++;
				else if(map[dr][dc] == 1 && !visit[dr][dc]) {
					visit[dr][dc] = true;
					queue.add(new int[] {dr, dc});
				}
			}
			
			if(cnt > 1)	list.add(new int[] {b[0],b[1]});
		}
		
		for(int i[] : list) {
			map[i[0]][i[1]] = 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			boolean flag = false;
			visit = new boolean[N][M];
			outside();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						flag = true;
						cheese(i, j);
					}
				}
			}
			
			if(!flag)	break;
			answer++;
		}
		
		System.out.print(answer);
	}
}