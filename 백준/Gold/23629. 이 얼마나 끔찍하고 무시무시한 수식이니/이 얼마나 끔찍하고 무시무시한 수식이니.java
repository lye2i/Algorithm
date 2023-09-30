import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static final String number[] = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
	static ArrayDeque<Long> num;
	static ArrayDeque<Character> exp;
	
	static boolean check(String str) {
		ArrayDeque<String> deque = new ArrayDeque<String>();
		int start = 0, end = 0;

		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')	end++;
			else {
				if(end - start > 0)	deque.add(str.substring(start, end));
				exp.add(str.charAt(i));
				start = end = i+1;
			}
		}
		
		if(deque.size() != exp.size())	return false;
		
		while(!deque.isEmpty()) {
			long n = stringToLong(deque.poll());
			if(n == 0)	return false;
			num.add(n);
		}
		return true;
	}
	
	static long stringToLong(String str) {
		for(int i=0; i<10; i++) {
			str = str.replaceAll(number[i], String.valueOf(i));
		}
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9')	return 0;
		}
		return Long.parseLong(str);
	}
	
	static String longToString(String str) {
		for(int i=0; i<10; i++) {
			str = str.replaceAll(String.valueOf(i), number[i]);
		}
		return str;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		num = new ArrayDeque<Long>();
		exp = new ArrayDeque<Character>();
		
		if(!check(br.readLine()))	sb.append("Madness!");
		else {
			long answer = num.poll();
			sb.append(answer);
			
			while(!num.isEmpty()) {
				long n = num.poll();
				char c = exp.poll();
				
				if(c == 'x')	answer *= n;
				else if(c == '/')	answer /= n;
				else if(c == '+')	answer += n;
				else	answer -= n;
				
				sb.append(c).append(n);
			}
			
			sb.append("=\n").append(longToString(String.valueOf(answer)));
		}
		
		System.out.print(sb);
	}
}