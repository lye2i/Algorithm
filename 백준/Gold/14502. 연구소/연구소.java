import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans=0, vCnt=Integer.MAX_VALUE, map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static LinkedList<int[]> V = new LinkedList<int[]> ();
	
	static void wall_DFS(int i, int j,int wall) {		
		if(wall==3) {
			int tmp[][] = new int[N][M];
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++)
					tmp[r][c] = map[r][c];
			}
			virus(tmp);
			return;
		}
		
		if(i==N && j==0)	return;
		
		if(j==M)	wall_DFS(i+1, 0,wall);
		
		else {
			if(map[i][j]==0) {
				map[i][j] = 1;
				wall_DFS(i, j+1, wall+1);
				map[i][j] = 0;
			}
			wall_DFS(i, j+1, wall);
		}
	}

	static void virus(int tmp[][]) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean visit[][] = new boolean[N][M];
		int cnt = V.size();
		for(int i=0; i<V.size(); i++) {
			int r = V.get(i)[0];
			int c = V.get(i)[1];
			visit[r][c] = true;
			q.offer(new int[] {r,c});
		}
		
		while(!q.isEmpty()) {
			int v[] =q.poll();
			for(int d=0; d<4; d++) {
				int r = v[0]+dr[d];
				int c = v[1]+dc[d];
				if(r>=0 && r<N && c>=0 && c<M && !visit[r][c] && tmp[r][c]==0) {
					tmp[r][c] = 2;
					visit[r][c] = true;
					cnt++;
					q.add(new int[] {r,c});
				}
			}
		}

		if(vCnt>cnt) {
			ans = safeCnt(tmp);
			vCnt = cnt;
		}
	}
	
	static int safeCnt(int[][] tmp) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tmp[i][j]==0)	cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2)	V.offer(new int[] {i,j});
			}
		}
		
		wall_DFS(0,0,0);
		System.out.println(ans);
	}
}