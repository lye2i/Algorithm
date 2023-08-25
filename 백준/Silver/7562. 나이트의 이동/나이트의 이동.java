import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int r[] = {-2, -2, -1, -1, 1, 1, 2, 2}, c[] = {-1, 1, -2, 2, -2, 2, -1, 1}; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()), sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int fr = Integer.parseInt(st.nextToken()), fc = Integer.parseInt(st.nextToken());			
			
			Queue<int[]> queue = new LinkedList<int[]>();
			boolean visit[][] = new boolean[N][N];
			visit[sr][sc] = true;
			queue.add(new int[] {sr, sc, 0});
			int cnt = 0;
			
			while(!queue.isEmpty()) {
				int p[] = queue.poll();
				
				if(p[0] == fr && p[1] == fc)	{
					cnt = p[2];
					break;
				}
				
				for(int i=0; i<8; i++) {
					int dr = p[0] + r[i];
					int dc = p[1] + c[i];
					
					if(dr < 0 || dr >= N || dc < 0 || dc >= N || visit[dr][dc])	continue;
					
					visit[dr][dc] = true;
					queue.add(new int[] {dr, dc, p[2]+1});
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.print(sb);
	}
}