import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> listen = new HashSet<>();
		HashSet<String> view = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			view.add(br.readLine());
		}
		
		listen.retainAll(view);
		ArrayList<String> result = new ArrayList<>(listen);
		Collections.sort(result);
		
		System.out.println(result.size());
		for(String s : result) {
			System.out.println(s);
		}
	}
}