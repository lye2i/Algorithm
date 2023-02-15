import java.io.*;
import java.util.*;

public class Main {
	static int d[] = {-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		int min = 600;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<3; j++) {
				if(i+d[j] >= 0 && i+d[j]<M)	queue.offer(new int[] {map[0][i], 0, i, j});
			}
		}
		
		while(!queue.isEmpty()) {
			int s[] = queue.poll();
			if(s[1] == N-1) {
				min = Math.min(min, s[0]);
				continue;
			}
			
			for(int i=0; i<3; i++) {
				if(i != s[3] && s[2]+d[i] >= 0 && s[2]+d[i] < M)
					queue.offer(new int[] {s[0]+map[s[1]+1][s[2]+d[i]], s[1]+1, s[2]+d[i], i});
			}
		}
		
		System.out.println(min);
	}
}