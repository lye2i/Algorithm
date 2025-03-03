import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			deque.add(i);
		}
		
		while(deque.size() > 1 && deque.size() >= K) {
			int first = deque.pollFirst();
			for(int i=1; i<K; i++) {
				deque.pollFirst();
			}
			deque.addLast(first);
		}
		
		System.out.print(deque.pollFirst());
	}
}