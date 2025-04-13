import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		boolean queue[] = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			if(st.nextToken().equals("0")) queue[i] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			if(queue[i])	deque.addFirst(Integer.parseInt(st.nextToken()));
			else	st.nextToken();
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			deque.addLast(Integer.parseInt(st.nextToken()));
			sb.append(deque.pollFirst()+" ");
		}
		
		System.out.print(sb);
	}
}