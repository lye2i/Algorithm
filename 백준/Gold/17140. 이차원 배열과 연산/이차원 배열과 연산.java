import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int A[][];
	static ArrayList<Num>[] list;
	
	static class Num implements Comparable<Num>{
		int n, cnt;
		Num(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Num o) {
			if(this.cnt == o.cnt)	return this.n - o.n;
			return this.cnt - o.cnt;
		}
	}
	
	public static void init(int N) {
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Num>();
		}
	}
	
	public static int sortR(int N, int M) {
		int max = 0;
		
		for(int i=0; i<N; i++) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<M; j++) {
				map.put(A[i][j], map.getOrDefault(A[i][j], 0)+1);
			}
			
			for(int j : map.keySet()) {
				if(j != 0)	list[i].add(new Num(j, map.get(j)));
			}
			Collections.sort(list[i]);
			if(max < list[i].size())	max = list[i].size();
		}
		
		return max;
	}
	
	public static int sortC(int N, int M) {
		int max = 0;
		
		for(int i=0; i<M; i++) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<N; j++) {
				map.put(A[j][i], map.getOrDefault(A[j][i], 0)+1);
			}
			
			for(int j : map.keySet()) {
				if(j != 0)	list[i].add(new Num(j, map.get(j)));
			}
			
			Collections.sort(list[i]);
			if(max < list[i].size())	max = list[i].size();
		}
		
		return max;
	}
	
	public static void arrayR(int N, int M, int max) {
		A = new int[N][max*2];
		for(int i=0; i<N; i++) {
			int k = 0;
			for(int j=0; j<list[i].size(); j++) {
				A[i][k++] = list[i].get(j).n;
				A[i][k++] = list[i].get(j).cnt;
			}
			for(int j=k; j<max*2; j++) {
				A[i][j] = 0;
			}
		}
	}
	
	public static void arrayC(int N, int M, int max) {
		A = new int[max*2][M];
		for(int i=0; i<M; i++) {
			int k = 0;
			for(int j=0; j<list[i].size(); j++) {
				A[k++][i] = list[i].get(j).n;
				A[k++][i] = list[i].get(j).cnt;
			}
			for(int j=k; j<max*2; j++) {
				A[j][i] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken())-1;
		int C = Integer.parseInt(st.nextToken())-1;
		int K = Integer.parseInt(st.nextToken());
		int T = 0;
		A = new int[3][3];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(T++ <= 100) {
			int N = A.length, M = A[0].length;
			if(N > R && M > C && A[R][C] == K)	break;
			
			if(N >= M) {
				init(N);
				arrayR(N, M, sortR(N, M));
			} else {
				init(M);
				arrayC(N, M, sortC(N, M));
			}
		}
		
		System.out.print(T == 102 ? -1 : T-1);	
	}
}