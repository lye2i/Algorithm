import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		int answer = 1;
		
		for(int i=2; i<=N; i+=6*(answer-1)) {
			answer++;
		}
		
		System.out.println(answer);
	}
}