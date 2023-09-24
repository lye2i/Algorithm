import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N;
	static String p, num[];
	static Deque<Integer> deque;
	static boolean reverse;
	
	static boolean func() {
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == 'R')	reverse = !reverse;
			else {
				if(deque.size() == 0)	return false;
				if(reverse)	deque.pollLast();
				else	deque.pollFirst();
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		deque = new ArrayDeque<Integer>();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			p = br.readLine();
			N = Integer.parseInt(br.readLine());
			num = br.readLine().split(",|\\[|\\]");
			reverse = false;
			
			for(String n : num) {
				if(n.length() > 0)	deque.add(Integer.parseInt(n));
			}
			
			if(!func())	sb.append("error\n");
			else {
				sb.append('[');
				
				while(reverse && !deque.isEmpty()) {
					sb.append(deque.pollLast()).append(',');
				}
				
				while(!reverse && !deque.isEmpty()) {
					sb.append(deque.pollFirst()).append(',');
				}
				
				if(sb.charAt(sb.length()-1) == ',')	sb.deleteCharAt(sb.length()-1);
				sb.append("]\n");
			}
		}
		
		System.out.print(sb);
	}
}