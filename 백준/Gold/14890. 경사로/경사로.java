import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L, M[][];
	
	public static boolean checkRow(int i) {
		boolean road[] = new boolean[N];
		
		for(int j=1; j<N; j++) {
			if(Math.abs(M[i][j-1] - M[i][j]) > 1)	return false;
			
			else if(M[i][j-1] < M[i][j]) {
				if(j-L >= 0 && M[i][j-L] == M[i][j-1] && checkRoad(road, j-L, j-1)) makeRoad(road, j-L, j-1);
				else	return false;
			} 
			
			else if(M[i][j-1] > M[i][j]) {
				int n = 1;
				while(j+n < N && M[i][j] == M[i][j+n]) {
					if(n == L)	break;
					n++;
				}
				if(n == L && checkRoad(road, j, j+n-1)) {
					makeRoad(road, j, j+n-1);
					j += n-1;
				}
				else	return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkColumn(int i) {
		boolean road[] = new boolean[N];
		
		for(int j=1; j<N; j++) {
			if(Math.abs(M[j-1][i] - M[j][i]) > 1)	return false;
			
			else if(M[j-1][i] < M[j][i]) {
				if(j-L >= 0 && M[j-L][i] == M[j-1][i] && checkRoad(road, j-L, j-1)) makeRoad(road, j-L, j-1);
				else	return false;
			} 
			
			else if(M[j-1][i] > M[j][i]) {
				int n = 1;
				while(j+n < N && M[j][i] == M[j+n][i]) {
					if(n == L)	break;
					n++;
				}
				if(n == L && checkRoad(road, j, j+n-1)) {
					makeRoad(road, j, j+n-1);
					j += n-1;
				}
				else	return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkRoad(boolean road[], int s, int e) {
		for(int i=s; i<=e; i++) {
			if(road[i])	return false;
		}
		return true;
	}
	
	public static void makeRoad(boolean road[], int s, int e) {
		for(int i=s; i<=e; i++) {
			road[i] = true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		M = new int[N][N];
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				M[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			if(checkRow(i))	ans++;
			if(checkColumn(i))	ans++;
		}
		
		System.out.print(ans);
	}
}