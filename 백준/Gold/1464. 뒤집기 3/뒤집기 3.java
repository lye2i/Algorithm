import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> deque = new ArrayDeque<Character>();
		String S = br.readLine();
		
		deque.add(S.charAt(0));
		for(int i=1; i<S.length(); i++) {
			if(deque.peekLast() < S.charAt(i))	deque.addFirst(S.charAt(i));
			else	deque.addLast(S.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!deque.isEmpty()) {
			sb.append(deque.pollLast());
		}
		
		System.out.print(sb);
	}
}