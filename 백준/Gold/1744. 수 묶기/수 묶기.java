import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> plus = new ArrayList<Integer>();
		ArrayList<Integer> minus = new ArrayList<Integer>();
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n > 0)	plus.add(n);
			else	minus.add(n);
		}
		
		Collections.sort(plus);
		Collections.sort(minus, Collections.reverseOrder());
		
		if(plus.size()%2 == 1)	answer += plus.get(0);
		for(int i=plus.size()-1; i>0; i-=2) {
			if(plus.get(i) > 1 && plus.get(i-1) > 1)	answer += (plus.get(i) * plus.get(i-1));
			else	answer += plus.get(i) + plus.get(i-1);
		}
		
		if(minus.size()%2 == 1)	answer += minus.get(0);
		for(int i=minus.size()-1; i>0; i-=2) {
			answer += minus.get(i) * minus.get(i-1);
		}
		
		System.out.print(answer);
	}
}