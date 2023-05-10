import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean Yvisit[][], Nvisit[][];
	static String arr[];
	
	static void Ncolor(int r, int c, char color) { //적록색약이 아닌 사람
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N && !Nvisit[nr][nc] && arr[nr].charAt(nc)==color) {
				Nvisit[nr][nc] = true;
				Ncolor(nr,nc,color);
			}
		}
	}
	
	static void Ycolor(int r, int c, char color) { //적록색약인 사람
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N && !Yvisit[nr][nc]) {
				if(color=='B' && arr[nr].charAt(nc)==color) {					
					Yvisit[nr][nc] = true;
					Ycolor(nr,nc,color);				
				}else if(color!='B' && arr[nr].charAt(nc)!='B'){
					Yvisit[nr][nc] = true;
					Ycolor(nr,nc,color);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		Yvisit = new boolean[N][N];
		Nvisit = new boolean[N][N];
		int yColor=0; //적록색약인 사람
		int nColor=0; //적록색약이 아닌 사람
		
		for(int i=0; i<N; i++) 
			arr[i] = br.readLine();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!Nvisit[i][j]) {
					Nvisit[i][j] = true;
					Ncolor(i,j,arr[i].charAt(j));
					nColor++;
				}
				
				if(!Yvisit[i][j]) {
					Yvisit[i][j] = true;
					Ycolor(i,j,arr[i].charAt(j));
					yColor++;
				}
			}
		}
		
		bw.write(nColor+" "+yColor);
		bw.flush();
	}
}