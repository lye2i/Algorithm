import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sushi[] = new int[N+K];
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		map.put(C, 1);
		for(int i=0; i<K; i++) {
			sushi[N+i] = sushi[i];
			map.put(sushi[i], map.getOrDefault(sushi[i], 0)+1);
		}
		answer = map.size();
		
		for(int i=K; i<N+K-1; i++) {
			map.put(sushi[i-K], map.get(sushi[i-K])-1);
			map.put(sushi[i], map.getOrDefault(sushi[i], 0)+1);
			if(map.get(sushi[i-K]) == 0)	map.remove(sushi[i-K]);
			answer = Math.max(answer, map.size());
		}
		
		System.out.print(answer);
	}
}