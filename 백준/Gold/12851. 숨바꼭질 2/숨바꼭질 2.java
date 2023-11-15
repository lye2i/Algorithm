import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int t = Integer.MAX_VALUE, cnt = 0;
		int visit[] = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE);
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {M, 0});
		
		while(!queue.isEmpty()) {
			int p[] = queue.poll();
			
			if(p[0] == N) {
				if(t == p[1])	cnt++;
				else if(t > p[1]) {
					t = p[1];
					cnt = 1;
				}
				continue;
			}
			
			if(p[0]%2 == 0 && visit[p[0]/2] >= p[1]+1) {
				visit[p[0]/2] = p[1]+1;
				queue.add(new int[] {p[0]/2, p[1]+1});
			}
			
			if(p[0]+1 <= 100000 && visit[p[0]+1] >= p[1]+1) {
				visit[p[0]+1] = p[1] + 1;
				queue.add(new int[] {p[0]+1, p[1]+1});
			}
			
			if(p[0]-1 >= 0 && visit[p[0]-1] >= p[1]+1) {
				visit[p[0]-1] = p[1] + 1;
				queue.add(new int[] {p[0]-1, p[1]+1});
			}
		}
		
		System.out.print(t+"\n"+cnt);
	}
}