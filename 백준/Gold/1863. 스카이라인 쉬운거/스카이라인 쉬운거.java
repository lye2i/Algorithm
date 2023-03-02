import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int h = Integer.parseInt(st.nextToken());

			while(!stack.isEmpty() && stack.peek() > h) {
				stack.pop();
				answer++;
			}
			
			if(h != 0 && (stack.isEmpty() || stack.peek() < h))	stack.add(h);
		}
		
		System.out.print(answer+stack.size());
	}
}