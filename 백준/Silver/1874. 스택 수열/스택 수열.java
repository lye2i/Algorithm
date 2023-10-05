import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		boolean flag = true;
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int n = 1, idx = 0;
		while(flag && n <= N) {
			if(n <= num[idx]) {
				stack.push(n);
				sb.append("+\n");
				n++;
			} else {
				if(!stack.isEmpty() && stack.pop() == num[idx++])	sb.append("-\n");
				else	flag = false;
			}
		}
		
		while(flag && !stack.isEmpty()) {
			if(stack.pop() == num[idx++])	sb.append("-\n");
			else	flag = false;
		}
		
		System.out.print(flag ? sb : "NO");
	}
}