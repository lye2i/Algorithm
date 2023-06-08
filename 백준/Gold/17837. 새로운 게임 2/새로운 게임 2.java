import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, K, M[][];
	static Deque<Integer> chess[][];
	static ArrayList<Horse> horse;
	static int R[] = {0,0,-1,1}, C[] = {1,-1,0,0};
	
	static class Horse {
		int r, c, d;
		Horse(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = new int[N][N];
		chess = new ArrayDeque[N][N];
		horse = new ArrayList<Horse>();
		int turn = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
				chess[i][j] = new ArrayDeque<Integer>();
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			horse.add(new Horse(r, c, Integer.parseInt(st.nextToken())-1));
			chess[r][c].add(i);
		}
		
		while(turn++ < 1000) {
			if(game())	break;
		}
		
		System.out.print(turn == 1001 ? -1 : turn);
	}

	private static boolean game() {
		for(int i=0; i<K; i++) {
			Horse h = horse.get(i);
			int dr = h.r + R[h.d];
			int dc = h.c + C[h.d];
			if(dr < 0 || dr >= N || dc < 0 || dc >= N || M[dr][dc] == 2) {
				h.d = h.d%2 == 0 ? h.d+1 : h.d-1;
				dr = h.r + R[h.d];
				dc = h.c + C[h.d];
			}
			
			if(dr >= 0 && dr < N && dc >= 0 && dc < N) {
				if(M[dr][dc] == 0 && white(h.r, h.c, i, dr, dc))	return true;
				else if(M[dr][dc] == 1 && red(h.r, h.c, i, dr, dc))	return true;
			}
		}
		
		return false;
	}
	
	private static boolean white(int r, int c, int idx, int dr, int dc) {
		if(chess[r][c].peekFirst() == idx) {
			while(!chess[r][c].isEmpty()) {
				int i = chess[r][c].pollFirst();
				chess[dr][dc].add(i);
				horse.get(i).r = dr;
				horse.get(i).c = dc;
			}
		} else {
			int f = chess[r][c].peekFirst();
			while(!chess[r][c].isEmpty() && idx != chess[r][c].peekFirst()) {
				chess[r][c].add(chess[r][c].pollFirst());
			}
			
			while(!chess[r][c].isEmpty() && f != chess[r][c].peekFirst()) {
				int i = chess[r][c].pollFirst();
				chess[dr][dc].add(i);
				horse.get(i).r = dr;
				horse.get(i).c = dc;
			}
		}
		
		return chess[dr][dc].size() > 3 ? true : false;
	}
	
	private static boolean red(int r, int c, int idx, int dr, int dc) {
		while(!chess[r][c].isEmpty() && idx != chess[r][c].peekLast()) {
			int i = chess[r][c].pollLast();
			chess[dr][dc].add(i);
			horse.get(i).r = dr;
			horse.get(i).c = dc;
		}
		
		chess[r][c].pollLast();
		chess[dr][dc].add(idx);
		horse.get(idx).r = dr;
		horse.get(idx).c = dc;
		
		return chess[dr][dc].size() > 3 ? true : false;
	}
}