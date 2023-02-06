import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {-1, 0, 1};
	static int R, C;
	static char map[][];
	
	static boolean pipe(int r, int c) {
		if(c == C-1)	return true;
		
		for(int i=0; i<3; i++) {
			int nr = r + dr[i];
			
			if(nr>=0 && nr<R && c+1>=0 && c+1<C && map[nr][c+1]=='.') {
				map[nr][c+1] = '-';
				if(pipe(nr, c+1))	return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int cnt = 0;
		
		for(int i=0; i<R; i++)
			map[i] = br.readLine().toCharArray();
		
		for(int i=0; i<R; i++) {
			if(pipe(i,0))	cnt++;
		}
		
		System.out.print(cnt);
	}
}