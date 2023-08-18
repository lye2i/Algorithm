import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, C, map[][];
	static int r[] = {-1,0,0,1,-1,1,1,-1};
	static int c[] = {0,-1,1,0,1,-1,1,-1};
	static ArrayList<int[]> trees;
	
	public static void getTrees() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > 0 && map[i][j] != Integer.MAX_VALUE)	trees.add(new int[] {i, j, 0});
			}
		}
	}
	
	public static void growthTree() {
		for(int i=0; i<trees.size(); i++) {
			int cnt = 0, zero = 0;
			int tree[] = trees.get(i);
			
			for(int d=0; d<4; d++) {
				int dr = tree[0] + r[d];
				int dc = tree[1] + c[d];
				if(dr >= 0 && dr < N && dc >= 0 && dc < N) {
					if(map[dr][dc] == 0)	zero++;
					else if(map[dr][dc] > 0 && map[dr][dc] != Integer.MAX_VALUE)	cnt++;
				}
			}
			
			map[tree[0]][tree[1]] += cnt;
			tree[2] = zero;
		}
	}
	
	public static void stretchTree() {
		Queue<int[]> newTrees = new LinkedList<int[]>();
		
		for(int i=0; i<trees.size(); i++) {
			int tree[] = trees.get(i);
			
			if(tree[2] == 0)	continue;
			
			for(int d=0; d<4; d++) {
				int dr = tree[0] + r[d];
				int dc = tree[1] + c[d];
				if(dr >= 0 && dr < N && dc >= 0 && dc < N && map[dr][dc] == 0)	newTrees.add(new int[] {dr, dc, map[tree[0]][tree[1]]/tree[2]});
			}
		}
		
		while(!newTrees.isEmpty()) {
			int tree[] = newTrees.poll();
			map[tree[0]][tree[1]] += tree[2];
		}
	}
	
	public static int[] findTree() {
		int max = 0, x = 0, y = 0;
		
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>=0; j--) {
				if(map[i][j] > 0 && map[i][j] != Integer.MAX_VALUE) {
					int sum = map[i][j];

					for(int d=4; d<8; d++) {
						for(int k=1; k<=K; k++) {
							int dr = i + r[d]*k;
							int dc = j + c[d]*k;
							
							if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == Integer.MAX_VALUE || map[dr][dc] <= 0)	break;
							sum += map[dr][dc];
						}
					}

					if(sum >= max) {
						max = sum;
						x = i;
						y = j;
					}
				}
			}
		}
		return new int[] {x, y, max};
	}
	
	public static void dieTree(int[] tree) {
		map[tree[0]][tree[1]] = -C;
		
		for(int d=4; d<8; d++) {
			for(int k=1; k<=K; k++) {
				int dr = tree[0] + r[d]*k;
				int dc = tree[1] + c[d]*k;
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == Integer.MAX_VALUE)	break;
				if(map[dr][dc] <= 0) {
					map[dr][dc] = -C;
					break;
				}
				map[dr][dc] = -C;
			}
		}
	}
	
	public static void plusYear() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] < 0)	map[i][j]++;
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		trees = new ArrayList<int[]>();
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1)	map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		while(M-- > 0) {
			getTrees();
			growthTree();
			stretchTree();

			int tree[] = findTree();
			plusYear();
			dieTree(tree);
			ans += tree[2];
			trees.clear();
		}
		
		System.out.print(ans);
	}
}
