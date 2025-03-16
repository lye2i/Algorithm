import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max[][] = new int[N+1][3];
		int min[][] = new int[N+1][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			
			max[i+1][0] = Math.max(max[i][0], max[i][1]) + n1;
			max[i+1][2] = Math.max(max[i][2], max[i][1]) + n3;
			max[i+1][1] = Math.max(max[i][0], Math.max(max[i][1], max[i][2])) + n2;
			
			min[i+1][0] = Math.min(min[i][0], min[i][1]) + n1;
			min[i+1][2] = Math.min(min[i][2], min[i][1]) + n3;
			min[i+1][1] = Math.min(min[i][0], Math.min(min[i][1], min[i][2])) + n2;
		}
		
		System.out.print(Math.max(max[N][2], Math.max(max[N][0], max[N][1])));
		System.out.print(" ");
		System.out.print(Math.min(min[N][2], Math.min(min[N][0], min[N][1])));
	}
}