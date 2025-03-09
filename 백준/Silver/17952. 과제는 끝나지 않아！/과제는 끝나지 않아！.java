import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		int score = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 1) {
				int hw[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1};
				if(hw[1] != 0) {
					stack.add(hw);
				} else {
					score += hw[0];
				}
			} else if(!stack.isEmpty() && --stack.peek()[1] == 0) {
				score += stack.peek()[0];
				stack.pop();
			}
		}
		
		System.out.print(score);
	}
}