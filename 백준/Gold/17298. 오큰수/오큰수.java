import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		int ans[] = new int[N];
		Stack<Integer> stack = new Stack<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek() <= A[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty())	ans[i] = -1;
			else	ans[i] = stack.peek();
			
			stack.push(A[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : ans) {
			sb.append(i).append(" ");
		}
		System.out.print(sb);
	}
}