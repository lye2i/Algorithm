import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
	static int R, S;
	static char G[][];
	
	public static int getCnt() {
		int min = R;
		
		for(int j=0; j<S; j++) {
			int s = -1, g = 0;
			
			for(int i=0; i<R; i++) {
				if(G[i][j] == 'X')	s = i;
				else if(G[i][j] == '#') {
					g = i-1;
					break;
				}
			}
			
			if(s != -1)	min = Math.min(g-s, min);
		}
		
		return min;
	}
	
	public static void move(int min) {
		for(int j=0; j<S; j++) {
			for(int i=R-1; i>=0; i--) {
				if(G[i][j] == 'X') {
					G[i+min][j] = 'X';
					G[i][j] = '.';
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = new char[R][S];
		
		for(int i=0; i<R; i++) {
			G[i] = br.readLine().toCharArray();
		}
		
		int min = getCnt();
		move(min);
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<S; j++)
				bw.write(G[i][j]);
			bw.write("\n");
		}
		bw.flush();
	}
}