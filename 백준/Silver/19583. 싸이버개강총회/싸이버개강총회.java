import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> start = new HashSet<String>();
		HashSet<String> end = new HashSet<String>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken(), E = st.nextToken(), Q = st.nextToken();
		String str = br.readLine();
		
		while(str != null && str.length() > 0) {
			String chat[] = str.split(" ");
			
			if(chat[0].compareTo(S) <= 0)	start.add(chat[1]);
			else if(start.contains(chat[1]) && chat[0].compareTo(E) >= 0 && chat[0].compareTo(Q) <= 0)	end.add(chat[1]);
			
			str = br.readLine();
		}
		
		System.out.print(end.size());
	}
}