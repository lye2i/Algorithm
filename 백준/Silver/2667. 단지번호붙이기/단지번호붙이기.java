import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int r[] = {-1,0,1,0}, c[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char M[][] = new char[N][N];
		boolean visit[][] = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			M[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j] || M[i][j] == '0')	continue;
				
				Queue<int[]> queue = new LinkedList<int[]>();
				int cnt = 0;
				visit[i][j] = true;
				queue.add(new int[] {i, j});
				
				while(!queue.isEmpty()) {
					int p[] = queue.poll();
					cnt++;
					
					for(int d=0; d<4; d++) {
						int dr = p[0] + r[d];
						int dc = p[1] + c[d];
						if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc] || M[dr][dc] == '0')	continue;
						visit[dr][dc] = true;
						queue.add(new int[] {dr, dc});
					}
				}
				
				list.add(cnt);
			}
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(int i : list) {
			sb.append(i).append("\n");
		}
		System.out.print(sb);
	}
}