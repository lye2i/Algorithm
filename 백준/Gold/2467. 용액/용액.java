import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[N];
		
		for(int i=0; i<N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		int start = 0, end = N-1, sum = Math.abs(num[start]+num[end]), n1 = start, n2 = end;
		while(start < end) {
			if(Math.abs(num[start]+num[end]) < sum) {
				sum = Math.abs(num[start]+num[end]);
				n1 = start;
				n2 = end;
				if(Math.abs(num[start]+num[end]) == 0)	break;
			}
			
			if(num[start] + num[end] < 0)	start++;
			else	end--;
		}
		
		System.out.print(num[n1]+" "+num[n2]);
	}
}