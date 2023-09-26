import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] edge;
	static boolean visit[];
	static Queue<Integer> queue;
	
	private static void BFS() {
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int e : edge[v]) {
				if(!visit[e]) {
					visit[e] = true;
					queue.add(e);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new ArrayList[N];
		visit = new boolean[N];
		queue = new LinkedList<Integer>();
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			edge[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			edge[u].add(v);
			edge[v].add(u);
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				cnt++;
				visit[i] = true;
				queue.add(i);
				BFS();
			}
		}
		
		System.out.print(cnt);
	}
}