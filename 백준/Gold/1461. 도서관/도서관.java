import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> minus = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> plus = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int book = Integer.parseInt(st.nextToken());
			if(book < 0)	minus.add(-book);
			else	plus.add(book);
		}
		
		int ans = 0, min = minus.isEmpty() ? 0 : minus.peek(), max = plus.isEmpty() ? 0 : plus.peek();
		
		while(!minus.isEmpty()) {
			ans += 2*minus.peek();
			for(int i=0; i<M; i++) {
				if(!minus.isEmpty())	minus.poll();
				else	break;
			}
		}
		
		while(!plus.isEmpty()) {
			ans += 2*plus.peek();
			for(int i=0; i<M; i++) {
				if(!plus.isEmpty())		plus.poll();
				else	break;
			}
		}
		
		if(min >= max)	ans -= min;
		else	ans -= max;
		
		System.out.print(ans);
	}
}