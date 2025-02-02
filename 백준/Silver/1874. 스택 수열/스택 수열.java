import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0, n = 1;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(idx < N) {
			while(n <= num[idx]) {
				stack.push(n);
				sb.append("+\n");
				n++;
			}
			
			if(!stack.isEmpty()) {
				if(stack.peek() != num[idx])	break;
				else {
					stack.pop();
					sb.append("-\n");
					idx++;
				}
			}
		}
		
		System.out.print(idx == N ? sb : "NO");
	}
}