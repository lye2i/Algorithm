import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int idx = 0;
		long answer = 0;
		Stack<int[]> stack = new Stack<int[]>();
		
		while(idx++ < N) {
			int building[] = {idx, Integer.parseInt(br.readLine())};
			while(!stack.isEmpty()) {
				if(stack.peek()[1] <= building[1])	answer += building[0]-stack.pop()[0]-1;
				else	break;
			}
			stack.push(building);
		}
		
		stack.pop();
		while(!stack.isEmpty()) {
			answer += idx-stack.pop()[0]-1;
		}
		
		System.out.print(answer);
	}
}