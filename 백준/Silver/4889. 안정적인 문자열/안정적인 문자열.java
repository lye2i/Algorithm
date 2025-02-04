import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		
		while(++idx > 0) {
			char str[] = br.readLine().toCharArray();
			if(str[0] == '-')	break;
			
			Stack<Character> stack = new Stack<Character>();
			int cnt = 0;
			
			for(int i=0; i<str.length; i++) {
				if(str[i] == '{') {
					stack.push('{');
				} else {
					if(stack.isEmpty()) {
						cnt++;
						stack.push('{');
					} else if(stack.peek() == '{') {
						stack.pop();
					} else {
						stack.push('{');
					}
				}
			}
			
			sb.append(idx+". "+(cnt+stack.size()/2)+"\n");
		}
		
		System.out.print(sb);
	}
}