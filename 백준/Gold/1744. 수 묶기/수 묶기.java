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
		int zero = 0, answer = 0;
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n > 0)	plus.add(n);
			else if(n < 0)	minus.add(n);
			else	zero++;
		}
		
		Collections.sort(plus);
		Collections.sort(minus);
		
		if(plus.size()%2 == 1)	answer += plus.get(0);
		for(int i=plus.size()-1; i>0; i-=2) {
			if(plus.get(i) > 1 && plus.get(i-1) > 1)	answer += (plus.get(i) * plus.get(i-1));
			else	answer += plus.get(i) + plus.get(i-1);
		}
		
		if(minus.size()%2 == 0) {
			for(int i=0; i<minus.size(); i+=2) {
				answer += (minus.get(i) * minus.get(i+1));
			}
		} else {
			for(int i=0; i<minus.size()-1; i+=2) {
				answer += (minus.get(i) * minus.get(i+1));
			}
			if(zero == 0)	answer += minus.get(minus.size()-1);
		}
		
		System.out.print(answer);
	}
}