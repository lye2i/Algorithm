import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> words = new ArrayList<String>();
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			words.add(br.readLine());
		}
		
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())	return o1.compareTo(o2);
				else	return o1.length() - o2.length();
			}
		});
		
		for(int i=0; i<N-1; i++) {
			int cnt = 0;
			for(int j=i+1; j<N; j++) {
				if(!words.get(j).startsWith(words.get(i)))	cnt++;
			}
			if(cnt == N-i-1)	answer++;
		}
			
		System.out.print(answer+1);
	}
}