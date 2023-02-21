import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		
		for(int i=0; i<N; i++)
			map.put(br.readLine(), 1);
		
		for(int i=0; i<M; i++) {
			String word[] = br.readLine().split(",");
			
			for(int j=0; j<word.length; j++) {
				if(map.containsKey(word[j]) && map.get(word[j]) == 1) {
					map.put(word[j], 0);
					N--;
				}
			}
			
			sb.append(N).append('\n');
		}
		
		System.out.print(sb);
	}
}