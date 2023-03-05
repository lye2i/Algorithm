import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int P[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for(int j=0; j<N; j++) {
				if(cnt == n && P[j] == 0) {
					P[j] = i+1;
					break;
				}
				if(P[j] == 0)	cnt++;
			}
		}
		
		for(int i=0; i<N; i++) {
			bw.write(P[i]+" ");
		}
		
		bw.flush();
	}
}