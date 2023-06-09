import java.io.*;
import java.util.*;

class Group {
	int n, cnt;
	Group(int n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}
}

public class Main {
	static int N, M[][], G[][], idx, ans;
	static ArrayList<Group> list;
	static HashMap<Integer, Integer> map;
	static int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	
	static void findGroup() {
		G = new int[N][N];
		list = new ArrayList<Group>();
		idx = 0;
		boolean visit[][] = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					Queue<int[]> queue = new LinkedList<int[]>();
					visit[i][j] = true;
					queue.add(new int[] {i, j});
					idx++;
					int cnt = 0;
					
					while(!queue.isEmpty()) {
						int p[] = queue.poll();
						G[p[0]][p[1]] = idx;
						cnt++;
						for(int d=0; d<4; d++) {
							int dr = p[0] + r[d];
							int dc = p[1] + c[d];
							if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc] || M[dr][dc] != M[p[0]][p[1]])	continue;
							visit[dr][dc] = true;
							queue.add(new int[] {dr, dc});
						}
					}
					
					list.add(new Group(M[i][j], cnt));
				}
			}
		}
	}
	
	static void findComb() {
		map = new HashMap<Integer, Integer>();
		boolean visit[][] = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					Queue<int[]> queue = new LinkedList<int[]>();
					visit[i][j] = true;
					queue.add(new int[] {i, j});
					
					while(!queue.isEmpty()) {
						int p[] = queue.poll();
						
						for(int d=0; d<4; d++) {
							int dr = p[0] + r[d];
							int dc = p[1] + c[d];
							if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc])	continue;
							
							if(G[dr][dc] > G[i][j]) {
								int g = G[i][j]*1000+G[dr][dc];
								map.put(g, map.getOrDefault(g, 0)+1);
							} else if(G[dr][dc] == G[i][j]) {
								visit[dr][dc] = true;
								queue.add(new int[] {dr, dc});
							}
						}
					}
				}
			}
		}
	}
	
	static void getSum() {
		for(int i : map.keySet()) {
			Group a = list.get(i/1000-1);
			Group b = list.get(i%1000-1);
			int sum = (a.cnt + b.cnt) * a.n * b.n * map.get(i);
			ans += sum;
		}
	}

	static void rotateCross() {
		int tmp[] = new int[N/2];
		for(int i=0; i<N/2; i++) {
			tmp[i] = M[i][N/2];
		}
		
		for(int i=0; i<N/2; i++) {
			M[i][N/2] = M[N/2][N-i-1];
		}
		
		for(int i=N/2+1; i<N; i++) {
			M[N/2][i] = M[i][N/2];
		}
		
		for(int i=0; i<N/2; i++) {
			M[N-i-1][N/2] = M[N/2][i];
		}
		
		for(int i=0; i<N/2; i++) {
			M[N/2][i] = tmp[i];
		}
	}
	
	static void rotateRect(int r, int c) {
		int tmp[][] = new int[N/2][N/2];
		for(int i = 0; i < N/2; i++) {
			for(int j=0; j < N/2; j++) {
				tmp[i][j] = M[r+N/2-1-j][c+i];
			}
		}
		
		for(int i=r; i<r+N/2; i++) {
			for(int j=c; j<c+N/2; j++) {
				M[i][j] = tmp[i-r][j-c];
			}
		}
	}
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(M[i][j]+" ");
			}System.out.println();
		}System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t=0; t<4; t++) {
			findGroup();
			findComb();
			getSum();

			if(t == 3)	break;
			rotateCross();
			for(int i=0; i<N; i+=N/2+1) {
				for(int j=0; j<N; j+=N/2+1) {
					rotateRect(i, j);
				}
			}
		}
		
		System.out.println(ans);
	}
}
