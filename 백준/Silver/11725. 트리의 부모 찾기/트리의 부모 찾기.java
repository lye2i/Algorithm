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
		ArrayList<Integer>[] tree = new ArrayList[N];
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visit[] = new boolean[N];
		int parent[] = new int[N];
		visit[0] = true;
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int n : tree[node]) {
				if(!visit[n]) {
					parent[n] = node;
					visit[n] = true;
					queue.add(n);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N; i++) {
			sb.append(parent[i]+1).append('\n');
		}
		System.out.print(sb);
	}
}