import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	
	static int search() {
		Deque<int[]> deque = new LinkedList<int[]>();
		boolean visit[] = new boolean[100001];
		visit[N] = true;
		deque.add(new int[] {N, 0});
		
		while(!deque.isEmpty()) {
			int n[] = deque.poll();
			if(n[0] == M)	return n[1];

			if(n[0]*2 <= 100000 && !visit[n[0]*2]) {
				visit[n[0]*2] = true;
				deque.addFirst(new int[] {n[0]*2, n[1]});
			}
			
			if(n[0]-1 >= 0 && !visit[n[0]-1]) {
				visit[n[0]-1] = true;
				deque.add(new int[] {n[0]-1, n[1]+1});
			}
			
			if(n[0]+1 <= 100000 && !visit[n[0]+1])	{
				visit[n[0]+1] = true;
				deque.add(new int[] {n[0]+1, n[1]+1});
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		System.out.print(search());
	}
}