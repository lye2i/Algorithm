import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int cnt = -1;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[] = new boolean[F+1];
		
		visit[S] = true;
		queue.add(new int[] {S, 0});
		
		while(!queue.isEmpty()) {
			int f[] = queue.poll();

			if(f[0] == G) {
				cnt = f[1];
				break;
			}
			
			if(f[0] + U <= F && !visit[f[0]+U]) {
				visit[f[0]+U] = true;
				queue.add(new int[] {f[0]+U, f[1]+1});
			}
			
			if(f[0] - D >= 1 && !visit[f[0]-D]) {
				visit[f[0]-D] = true;
				queue.add(new int[] {f[0]-D, f[1]+1});
			}
		}
		
		System.out.print(cnt == -1 ? "use the stairs" : cnt);
	}
}