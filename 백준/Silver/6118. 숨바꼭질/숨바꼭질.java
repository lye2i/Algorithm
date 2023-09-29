import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, num[], ans2;
	static ArrayList<Integer> road[];
	
	static void search() {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[] = new boolean[N+1];
		visit[1] = true;
		queue.add(new int[] {1, 0});
		
		while(!queue.isEmpty()) {
			int v[] = queue.poll();
			
			for(int n : road[v[0]]) {
				if(!visit[n]) {
					visit[n] = true;
					num[n] = v[1]+1;
					queue.add(new int[] {n, v[1]+1});
				}
			}
			
			ans2 = Math.max(ans2, v[1]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans2 = 0;
		num = new int[N+1];
		road = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			road[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			road[v1].add(v2);
			road[v2].add(v1);
		}
		
		search();
		
		int ans1 = 0, ans3 = 0;
		for(int i=N; i>1; i--) {
			if(num[i] == ans2) {
				ans1 = i;
				ans3++;
			}
		}
		
		System.out.print(ans1+" "+ans2+" "+ans3);
	}
}