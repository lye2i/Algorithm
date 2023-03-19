import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int current = 0, time = 0, idx = 0;
		int truck[] = new int[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			truck[i] = Integer.parseInt(st.nextToken());
		
		while(true) {
			time++;
			
			if(queue.size() == W) current -= queue.poll();
			if(idx < N && current + truck[idx] <= L) {
				current += truck[idx];
				queue.add(truck[idx++]);
			}
			else	queue.add(0);
			
			if(current == 0)	break;
		}
		
		System.out.print(time);
	}
}