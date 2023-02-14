import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int max = 0, cnt = 1, sum = 0;
		int day[] = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			day[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<X; i++)
			sum += day[i];
		
		max = sum;
		
		for(int i=X; i<N; i++) {
			sum += day[i];
			sum -= day[i-X];
			
			if(sum == max)	cnt++;
			else if(sum > max) {
				max = sum;
				cnt = 1;
			}
		}
		
		bw.write(max == 0 ? "SAD" : max+"\n"+cnt);
		bw.flush();
	}
}