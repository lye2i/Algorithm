import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, friend[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friend = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a][b] = 1;
			friend[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i == j)	continue;
					if(friend[i][k] != 0 && friend[k][j] != 0) {
						if(friend[i][j] == 0)	friend[i][j] = friend[j][i] = friend[i][k]+friend[k][j];
						else	friend[i][j] = friend[j][i] = Math.min(friend[i][j], friend[i][k]+friend[k][j]);
					}
				}
			}
		}
		
		int user = 0, min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				sum += friend[i][j];
			}
			if(sum < min) {
				min = sum;
				user = i;
			}
		}
		
		System.out.print(user);
	}
}