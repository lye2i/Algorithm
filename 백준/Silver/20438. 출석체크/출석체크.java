import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> std = new ArrayList<Integer>();
		boolean visit[] = new boolean[N+3];
		int student[] = new int[N+3];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			std.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Q; i++) {
			int s = Integer.parseInt(st.nextToken());
			if(std.contains(s))	continue;
			for(int j=s; j<N+3; j+=s) {
				if(std.contains(j))	continue;
				visit[j] = true;
			}
		}
		
		for(int i=3; i<N+3; i++) {
			student[i] = visit[i] ? student[i-1] : student[i-1]+1;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(student[E] - student[S-1]).append("\n");
		}
		
		System.out.print(sb);
	}
}