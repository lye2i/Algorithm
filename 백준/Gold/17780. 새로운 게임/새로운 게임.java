import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int r[] = {0,0,-1,1};
	static int c[] = {1,-1,0,0};
	static int N = 0, K = 0;
	static ArrayList<Deque<int[]>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<Deque<int[]>>();
		int map[][] = new int[N][N];
		int turn = 0;
		boolean flag = false;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			Deque<int[]> deque = new LinkedList<int[]>();
			deque.add(new int[] {i, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1});
			list.add(deque);
		}
		
		while(!flag && turn++ <= 1000)
			flag = game(map);
		
		System.out.print(turn > 1000 ? -1 : turn);
	}
	
	private static boolean game(int[][] map) {
		for(int i=0; i<K; i++) {
			if(list.get(i).size() == 0)	continue;
			
			Deque<int[]> deque = list.get(i);
			int[] chess = deque.peekFirst();
			int dr = chess[1] + r[chess[3]];
			int dc = chess[2] + c[chess[3]];
			
			if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == 2) {
				if(chess[3] % 2 == 0)	chess[3]++;
				else	chess[3]--;
				dr = chess[1] + r[chess[3]];
				dc = chess[2] + c[chess[3]];
			}
			
			if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == 2) {
				deque.removeFirst();
				deque.addFirst(chess);
			} else {
				boolean plus = false;
				
				for(int k=0; k<K; k++) {
					if(list.get(k).size() == 0 || k == i)	continue;
					
					int chess2[] = list.get(k).peekFirst();
					if(chess2[1] == dr && chess2[2] == dc) {
						if(plusChess(map[dr][dc], deque, dr, dc, k))	return true;
						plus = true;
						break;
					}
				}
				
				if(!plus) {
					if(map[dr][dc] == 1)	moveChess1(deque, dr, dc);
					else	moveChess0(deque, dr, dc);
				}
			}
			list.set(i, deque);
		}
		
		return false;
	}
	
	private static boolean plusChess(int i, Deque<int[]> deque, int dr, int dc, int k) {
		while(!deque.isEmpty()) {
			int chess[] = i == 0 ? deque.pollFirst() : deque.pollLast();
			chess[1] = dr;
			chess[2] = dc;
			list.get(k).add(chess);
		}
		return list.get(k).size() > 3 ? true : false;
	}
	
	private static void moveChess0(Deque<int[]> deque, int dr, int dc) {
		int cnt = 0;
		while(cnt++ < deque.size()) {
			int chess[] = deque.pollFirst();
			chess[1] = dr;
			chess[2] = dc;
			deque.add(chess);
		}
	}
	
	private static void moveChess1(Deque<int[]> deque, int dr, int dc) {
		int cnt = deque.size(), k = deque.peekLast()[0];
		while(cnt-- > 0) {
			int chess[] = deque.pollLast();
			chess[1] = dr;
			chess[2] = dc;
			list.get(k).add(chess);
		}
	}
}