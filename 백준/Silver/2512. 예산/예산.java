import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int money[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			money[i] = Integer.parseInt(st.nextToken());
		
		int max = Integer.parseInt(br.readLine());
		Arrays.sort(money);
		int min = 0;
		int n = N;
		int sum = 0;
		int answer = 0;
		
		while(n > 0) {
			if(sum + money[min]*n > max) {
				answer = money[min];
				break;
			}
			sum += money[min++];
			n--;
		}
		
		while(n > 0) {
			if(sum + answer*n <= max)	break;
			answer--;
		}
		
		System.out.print(answer == 0 ? money[N-1] : answer);
	}

}