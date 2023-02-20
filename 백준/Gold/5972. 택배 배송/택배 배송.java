import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int i, c;
		
		Node(int i, int c) {
			this.i = i;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.c - n.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();
		
		for(int i=0; i<N; i++)
			map.add(new ArrayList<Node>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			map.get(a).add(new Node(b, c));
			map.get(b).add(new Node(a, c));
		}
		
		boolean visit[] = new boolean[N];
		int cost[] = new int[N];
		Arrays.fill(cost, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		cost[0] = 0;
		pq.add(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(!visit[node.i])	visit[node.i] = true;
			else continue;
			
			for(int i=0; i<map.get(node.i).size(); i++) {
				Node next = map.get(node.i).get(i);
				if(cost[next.i] > cost[node.i] + next.c) {
					cost[next.i] = cost[node.i] + next.c;
					pq.offer(new Node(next.i, cost[next.i]));
				}
			}
		}
		
		System.out.print(cost[N-1]);
	}
}