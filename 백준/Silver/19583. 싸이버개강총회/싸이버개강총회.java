import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken(), E = st.nextToken(), Q = st.nextToken();
		HashSet<String> in = new HashSet<String>();
		HashSet<String> out = new HashSet<String>();
		String str = "";
		
		while((str = br.readLine()) != null && str.length() > 0) {
			String chat[] = str.split(" ");
			if(chat[0].compareTo(S) <= 0) {
				in.add(chat[1]);
			} else if(chat[0].compareTo(E) >= 0 && chat[0].compareTo(Q) <= 0 && in.contains(chat[1])) {
				out.add(chat[1]);
			}
		}
		
		System.out.print(out.size());
	}
}