import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int N, M, map[][], B[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,1,-1};
	
	static boolean edge(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(check(nr,nc) && map[nr][nc]==0)
				return true;
		}
		return false;
	}
	
	static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M)	return true;
		return false;
	}
	
	static void divide(int r, int c, int n) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean visit[][] = new boolean[N][M];
		visit[r][c] = true;
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int G[] = q.poll();
			map[G[0]][G[1]] = n;
			for(int d=0; d<4; d++) {
				int nr = G[0]+dr[d];
				int nc = G[1]+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visit[nr][nc] && map[nr][nc]!=0) {
					visit[nr][nc] = true;
					q.add(new int[] {nr,nc});
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int cnt = 1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1)	divide(i, j, ++cnt);
			}
		}
		
		int n = cnt-1;
		B = new int[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(B[i], 10);
		
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>1 && edge(i,j))	makeBridge(i,j);
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(B[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
		
		System.out.println(prim(n));

	}

	private static int prim(int n) {
		int ans = 0;
		int[] node = new int[n];
		boolean[] v = new boolean[n];
		Arrays.fill(node, Integer.MAX_VALUE);
		node[0] = 0;
		for(int i=0; i<n-1; i++) {
			int idx = -1, D = Integer.MAX_VALUE;
			for(int j=0; j<n; j++) {
				if(node[j]<D && !v[j]) {
					idx = j;
					D = node[j];
				}
			}
			
			if(idx==-1)	break;
			v[idx] = true;
			
			for(int j=0; j<n; j++) {
				if(B[idx][j]<10 && !v[j] && B[idx][j]<node[j])
					node[j] = B[idx][j];
			}
//			System.out.println(Arrays.toString(node));
			
		}
//		System.out.println(Arrays.toString(node));
		for(int i=0; i<n; i++) {
			if(node[i]==Integer.MAX_VALUE) {
				return -1;
			}
			ans += node[i];
		}
		return ans;
	}

	private static void makeBridge(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			int length = 0;
			while(check(nr,nc) && map[nr][nc]==0) {
				length++;
				nr += dr[d];
				nc += dc[d];
				if(check(nr,nc) && map[nr][nc]!=0 && map[r][c]!=map[nr][nc] && length>1) {
					int s = map[r][c]-2;
					int e = map[nr][nc]-2;
					if(B[s][e]>length) {
						B[s][e] = length;
						B[e][s] = length;
					}
				}
			}
		}
	}
}