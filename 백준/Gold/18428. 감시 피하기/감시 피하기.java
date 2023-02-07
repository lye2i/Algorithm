import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int r[] = {0,0,1,-1};
	static int c[] = {1,-1,0,0};
	static int N;
	static char map[][];
	
	public static boolean search(int T[], ArrayList<ArrayList<Integer>> wall) {
		for (int d = 0; d < 4; d++) {
			int dr = T[0] + r[d];
			int dc = T[1] + c[d];
			if(dr >= 0 && dr < N && dc >= 0 && dc < N) {
				 if(map[dr][dc] == 'S')	return false;
				 if(map[dr][dc] == 'X' && !check(T, d, 1)) {
					 if(d < 2)	wall.get(T[0]).add(d);
					 else	wall.get(T[1]).add(d);
				 }
			}
		}
		return true;
	}
	
	public static boolean check(int T[], int d, int i) {
		while(++i < N) {
			int dr = T[0] + r[d]*i;
			int dc = T[1] + c[d]*i;
			if(dr >= 0 && dr < N && dc >= 0 && dc < N) {
				if(map[dr][dc] == 'S') return false;
				if(map[dr][dc] == 'T')	return true;
			}
			else	break;
		}
		return true;
	}
	
	public static boolean count(ArrayList<ArrayList<Integer>> wall) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> list = wall.get(i);
			if(list.size() == 0)	continue;
			else if(list.size() == 4 || list.size() == 3)	cnt+=2;
			else if(list.size() == 1)	cnt++;
			else {
				if((list.get(0) < 2 && list.get(1) < 2) || (list.get(0) > 1 && list.get(1) > 1))	cnt+=2;
				else	cnt++;
			}
		}
		
		return cnt > 3 ? false : true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		boolean answer = true;
		ArrayList<int[]> teacher = new ArrayList<int[]>();
		ArrayList<ArrayList<Integer>> wall = new ArrayList<>();
		
		for (int i = 0; i < N; i++)
			wall.add(new ArrayList<Integer>());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T')	teacher.add(new int[] {i, j});
			}
		}
		
		for (int i = 0; i < teacher.size(); i++) {
			if(!search(teacher.get(i), wall)) {
				answer = false;
				break;
			}
		}
		
		if(answer && !count(wall))	answer = false;
		
		System.out.print(answer ? "YES" : "NO");
	}
}