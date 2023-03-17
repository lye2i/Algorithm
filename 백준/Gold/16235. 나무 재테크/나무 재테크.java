import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R[] = {0,0,1,-1,-1,-1,1,1};
	static int C[] = {1,-1,0,0,1,-1,1,-1};
	
	static class Tree implements Comparable<Tree>{
		int r, c, a;
		Tree(int r, int c, int a) {
			this.r = r;
			this.c = c;
			this.a = a;
		}
		@Override
		public int compareTo(Tree o) {
			return this.a-o.a;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int G[][] = new int[N][N];
		int A[][] = new int[N][N];
		Deque<Tree> trees = new ArrayDeque<Tree>();
		PriorityQueue<Tree> list = new PriorityQueue<Tree>();
		Queue<Tree> fall = new LinkedList<Tree>();
		Queue<Tree> die = new LinkedList<Tree>();
		
		for(int i=0; i<N; i++)
			Arrays.fill(G[i], 5);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Tree(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		while(!list.isEmpty())
			trees.add(list.poll());
		
		while(K-- > 0) {
			int s = trees.size();
			for(int i=0; i<s; i++) {
				Tree t = trees.poll();

				if(G[t.r][t.c] >= t.a) {
					G[t.r][t.c] -= t.a;
					trees.add(new Tree(t.r, t.c, t.a+1));
					if((t.a+1) % 5 == 0)	fall.add(new Tree(t.r, t.c, t.a+1));
				}
				else	die.add(t);
			}

			while(!die.isEmpty()) {
				Tree t = die.poll();
				G[t.r][t.c] += t.a/2;
			}
			
			while(!fall.isEmpty()) {
				Tree t = fall.poll();
				for (int j = 0; j < 8; j++) {
					int dr = t.r + R[j];
					int dc = t.c + C[j];
					if(dr>=0 && dr<N && dc>=0 && dc<N)
						trees.addFirst(new Tree(dr, dc, 1));
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					G[i][j] += A[i][j];
			}
		}
		
		System.out.print(trees.size());
	}
}