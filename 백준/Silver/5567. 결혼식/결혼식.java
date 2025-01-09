import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean friend[][] = new boolean[N][N];
		boolean person[] = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			friend[a][b] = true;
			friend[b][a] = true;
		}
		
		for(int i=1; i<N; i++) {
			if(friend[0][i]) {
				queue.add(i);
				person[i] = true;
				cnt++;
			}
		}
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			for(int i=1; i<N; i++) {
				if(friend[p][i] && !person[i]) {
					person[i] = true;
					cnt++;
				}
			}
		}
		
		System.out.print(cnt);
	}
}