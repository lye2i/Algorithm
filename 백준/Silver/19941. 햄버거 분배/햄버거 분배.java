import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		int max = 0;
		
		while(K > 0) {
			boolean ham[] = new boolean[N];
			int cnt = 0;
		
			for(int i=0; i<N; i++) {
				if(str.charAt(i) == 'P') {
					boolean left = false;
					
					for(int j=K; j>0; j--) {
						if(i-j >= 0 && str.charAt(i-j) == 'H' && !ham[i-j]) {
							ham[i-j] = true;
							cnt++;
							left = true;
							break;
						}
					}
					
					if(!left) {
						for(int j=1; j<=K; j++) {
							if(i+j < N && str.charAt(i+j) == 'H' && !ham[i+j]) {
								ham[i+j] = true;
								cnt++;
								break;
							}
						}
					}
				}
			}
			
			K--;
			
			if(max < cnt)	max = cnt;
		}
		
		System.out.print(max);
	}
}