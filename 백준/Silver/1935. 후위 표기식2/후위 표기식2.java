import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		char str[] = br.readLine().toCharArray();
		Stack<Double> stack = new Stack<Double>();
		
		for(int i=0; i<N; i++)
			num[i] = Integer.parseInt(br.readLine());
		
		for(int i=0; i<str.length; i++) {
			if(str[i] >= 'A' && str[i] <= 'Z')	stack.push((double)num[str[i] - 'A']);
			else {
				double n2 = stack.pop();
				double n1 = stack.pop();
				
				switch(str[i]) {
					case '+':
						stack.push(n1+n2);
						break;
					case '-':
						stack.push(n1-n2);
						break;
					case '*':
						stack.push(n1*n2);
						break;
					case '/':
						stack.push(n1/n2);
						break;
				}
			}
		}
		
		System.out.printf("%.2f", stack.pop());
	}
}