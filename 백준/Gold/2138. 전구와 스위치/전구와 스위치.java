import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		char s1[] = s.toCharArray(); // 누른 경우
		char s2[] = s.toCharArray(); // 안 누른 경우
		char d[] = br.readLine().toCharArray();
		int cnt1 = 1, cnt2 = 0, answer = 100001;
		
		s1[0] = s1[0] == '0' ? '1' : '0';
		s1[1] = s1[1] == '0' ? '1' : '0';

		for(int i=1; i<N; i++) {
			if(s1[i-1] != d[i-1]) {
				cnt1++;
				s1[i-1] = s1[i-1] == '0' ? '1' : '0';
				s1[i] = s1[i] == '0' ? '1' : '0';
				if(i+1 < N) s1[i+1] = s1[i+1] == '0' ? '1' : '0';
			}
		}
		
		for(int i=1; i<N; i++) {
			if(s2[i-1] != d[i-1]) {
				cnt2++;
				s2[i-1] = s2[i-1] == '0' ? '1' : '0';
				s2[i] = s2[i] == '0' ? '1' : '0';
				if(i+1 < N) s2[i+1] = s2[i+1] == '0' ? '1' : '0';
			}
		}
		
		if(s1[N-1] == d[N-1]) answer = cnt1;
		if(s2[N-1] == d[N-1])	answer = Math.min(answer, cnt2);
		
		System.out.print(answer == 100001 ? -1 : answer);
	}
}