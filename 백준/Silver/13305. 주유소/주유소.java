import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int price[] = new int[N-1];
		int city[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++)
			price[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++)
			city[i] = Integer.parseInt(st.nextToken());
		
		long answer = city[0] * price[0];
		int min = city[0];
		for(int i=1; i<N-1; i++) {
			min = Math.min(min, city[i]);
			answer += min * price[i];
		}
		
		System.out.print(answer);
	}
}