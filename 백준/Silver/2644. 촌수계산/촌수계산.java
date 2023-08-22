import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(br.readLine());
		int ans = -1;
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken())-1;
			int p2 = Integer.parseInt(st.nextToken())-1;
			list[p1].add(p2);
			list[p2].add(p1);
		}
		
		boolean visit[] = new boolean[N];
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[x] = true;
		queue.add(new int[] {x, 0});
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			
			if(p[0] == y) {
				ans = p[1];
				break;
			}
			
			for(int i : list[p[0]]) {
				if(!visit[i]) {
					visit[i] = true;
					queue.add(new int[] {i, p[1]+1});
				}
			}
		}
		
		System.out.print(ans);
	}
}