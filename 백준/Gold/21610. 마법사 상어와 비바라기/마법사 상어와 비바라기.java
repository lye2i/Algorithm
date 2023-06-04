import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, A[][];
	static int r[] = {0, -1, -1, -1, 0, 1, 1, 1}, c[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static boolean C[][];
	static Queue<int[]> queue;
	static ArrayList<int[]> list;
	
	public static void move(int d, int s) {
		while(!queue.isEmpty()) {
			int b[] = queue.poll();
			b[0] = (b[0] + (r[d]*s) + (N*s)) % N;
			b[1] = (b[1] + (c[d]*s) + (N*s)) % N;
			
			C[b[0]][b[1]] = true;
			list.add(b);
		}
	}
	
	public static void grow() {
		for(int i[] : list) {
			A[i[0]][i[1]]++;
		}
	}
	
	public static void magic() {
		for(int i[] : list) {
			int cnt = 0;
			for(int j=1; j<8; j+=2) {
				int dr = i[0] + r[j];
				int dc = i[1] + c[j];
				if(dr >=0 && dr < N && dc >= 0 && dc < N && A[dr][dc] > 0)	cnt++;
			}
			A[i[0]][i[1]] += cnt;
		}
	}
	
	public static void make() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!C[i][j] && A[i][j] > 1) {
					queue.add(new int[] {i, j});
					A[i][j] -= 2;
				}
			}
		}
	}
	
	public static void disappear() {
		for(int i[] : list) {
			C[i[0]][i[1]] = false;
		}
		list.clear();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		C = new boolean[N][N];
		queue = new LinkedList<int[]>();
		list = new ArrayList<int[]>();
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		queue.add(new int[] {N-1, 0});
		queue.add(new int[] {N-1, 1});
		queue.add(new int[] {N-2, 0});
		queue.add(new int[] {N-2, 1});
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			move(d,s);
			grow();
			magic();
			make();
			disappear();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += A[i][j];
			}
		}
		System.out.print(sum);
	}
}