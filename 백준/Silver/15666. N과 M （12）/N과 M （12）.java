import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> num;
	static HashSet<String> per;
	static StringBuilder sb;
	
	public static void permutation(int idx, int cnt, int[] a) {
		if(cnt == M) {
			StringBuilder str = new StringBuilder();
			for(int i=0; i<M-1; i++) {
				str.append(a[i]).append(" ");
			}
			str.append(a[M-1]);
			
			if(!per.contains(str.toString())) {
				per.add(str.toString());
				sb.append(str.toString()).append("\n");
			}
			return;
		}
		
		for(int i=idx; i<num.size(); i++) {
			a[cnt] = num.get(i);
			permutation(i, cnt+1, a);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<Integer>();
		per = new HashSet<String>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		num = new ArrayList<Integer>(set);
		Collections.sort(num);
		permutation(0, 0, new int[M]);
		System.out.print(sb);
	}
}