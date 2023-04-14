import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList <LinkedList<int[]>> P = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int trueN = Integer.parseInt(st.nextToken());
		boolean trueP[] = new boolean[N];
		boolean visitM[] = new boolean[M];
		for(int i=0; i<trueN; i++)
			trueP[Integer.parseInt(st.nextToken())-1] = true;
		
		for(int i=0; i<N; i++)
			P.add(new LinkedList<int[]>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());			
			int arr[] = new int[n+1];
			arr[0] = i;
			for(int j=1; j<=n; j++) {
				arr[j] = Integer.parseInt(st.nextToken())-1;
			}
			
			for(int j=1; j<arr.length; j++)
				P.get(arr[j]).add(arr);						
		}
		
		while(true) {
			int cnt = 0;
			
			for(int i=0; i<P.size(); i++) {
				if(trueP[i]) {
					for (int j = 0; j < P.get(i).size(); j++) {
						if(!visitM[P.get(i).get(j)[0]]) {
							for(int k = 1; k < P.get(i).get(j).length; k++) {
								if(!trueP[P.get(i).get(j)[k]])
									trueP[P.get(i).get(j)[k]] = true;
							}
							visitM[P.get(i).get(j)[0]] = true;
							cnt++;
						}
					}
				}
			}
			
			if(cnt==0)	break;
			M -= cnt;
		}

		System.out.println(M);
	}
}