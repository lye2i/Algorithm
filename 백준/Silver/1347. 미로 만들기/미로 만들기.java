import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	final static int dr[] = {1, 0, -1, 0};
	final static int dc[] = {0, -1, 0, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char str[] = br.readLine().toCharArray();
		char map[][] = new char[101][101];
		int r = 50, c = 50, d = 0;
		
		map[r][c] = '.';
		for(int i=0; i<N; i++) {
			if(str[i] == 'F') {
				r += dr[d];
				c += dc[d];
				map[r][c] = '.';
			} else if(str[i] == 'R') {
				d = d+1 > 3 ? d-3 : d+1;
			} else {
				d = d-1 < 0 ? d+3 : d-1;
			}
		}
		
		int sr = 50, sc = 50, er = 50, ec = 50;
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=100; j++) {
				if(map[i][j] == '.') {
					sr = Math.min(i, sr);
					sc = Math.min(j, sc);
					er = Math.max(i, er);
					ec = Math.max(j, ec);
				}
			}
		}
		
		for(int i=sr; i<=er; i++) {
			for(int j=sc; j<=ec; j++) {
				System.out.print(map[i][j] == '.' ? map[i][j] : '#');
			}
			System.out.println();
		}
	}
}