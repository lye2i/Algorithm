import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		boolean visit[] = new boolean[100001];
		
		Deque<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {N, 0});
		visit[N] = true;
		
		while(!queue.isEmpty()) {
			int[] subin = queue.poll();
			
			if(subin[0] == K) {
				answer = subin[1];
				break;
			}
			
			if(subin[0]*2 <= 100000 && !visit[subin[0]*2]) {
				visit[subin[0]*2] = true;
				queue.addFirst(new int[] {subin[0]*2, subin[1]});
			}
			
			if(subin[0]+1 <= 100000 && !visit[subin[0]+1]) {
				visit[subin[0]+1] = true;
				queue.add(new int[] {subin[0]+1, subin[1]+1});
			}
			
			if(subin[0]-1 >= 0 && !visit[subin[0]-1]) {
				visit[subin[0]-1] = true;
				queue.add(new int[] {subin[0]-1, subin[1]+1});
			}
			
		}
		
		System.out.print(answer);
	}
}