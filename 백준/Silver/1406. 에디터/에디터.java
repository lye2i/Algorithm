import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		char c[] = br.readLine().toCharArray();
		int N = Integer.parseInt(br.readLine());
		Stack<Character> leftStack = new Stack<Character>();
		Stack<Character> rightStack = new Stack<Character>();
		
		for(int i=0; i<c.length; i++)
			leftStack.add(c[i]);
		
		while(N-- > 0) {
			c = br.readLine().toCharArray();
			
			if(c[0] == 'L' && !leftStack.isEmpty())	rightStack.add(leftStack.pop());
			else if(c[0] == 'D' && !rightStack.isEmpty()) leftStack.add(rightStack.pop());
			else if(c[0] == 'B' && !leftStack.isEmpty()) leftStack.pop();
			else if(c[0] == 'P') leftStack.add(c[2]);
		}
		
		while(!leftStack.isEmpty())
			sb.append(leftStack.pop());
		
		bw.write(sb.reverse().toString());
		while(!rightStack.isEmpty())
			bw.write(rightStack.pop());
		
		bw.flush();
	}
}