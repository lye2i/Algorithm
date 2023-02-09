import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			if(word.length() >= M)	map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		ArrayList<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(map.get(s1) != map.get(s2))	return map.get(s2) - map.get(s1);
				else if(s1.length() != s2.length())	return s2.length() - s1.length();
				else	return s1.compareTo(s2);
			}
		});
		
		for(String s : list) {
			sb.append(s).append("\n");
		}
		
		System.out.print(sb);
	}

}