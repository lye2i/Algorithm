import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean check(HashMap<Character, Integer> target, HashMap<Character, Integer> map, int targetLength, int wordLength) {
		int diff = 0, same = 0;
		
		for(char c : target.keySet()) {
			if(!map.containsKey(c))	diff += target.get(c);
			else if(target.get(c) == map.get(c))	same += target.get(c);
			else same += Math.min(target.get(c), map.get(c));
		}

		return diff > 1 || wordLength - same > 1 ? false : true;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> target = new HashMap<Character, Integer>();
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int ans = 0;
		
		for(int i=0; i<str.length(); i++)
			target.put(str.charAt(i), target.getOrDefault(str.charAt(i), 0)+1);
	
		while(--N > 0) {
			String word = br.readLine();
			
			if(Math.abs(word.length()-str.length()) > 1)	continue;
			
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			
			for(int i=0; i<word.length(); i++)
				map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
			
			if(check(target, map, str.length(), word.length()))	ans++;
			
		}
		
		System.out.print(ans);
	}
}