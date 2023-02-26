import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Integer> list;
	
	public static void search(boolean visit[], int num[], int i, int first) {
		if(num[i] == first)	list.add(first);
		if(!visit[num[i]]) {
			visit[num[i]] = true;
			search(visit, num, num[i], first);
			visit[num[i]] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N+1];
		list = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++)
			num[i] = Integer.parseInt(br.readLine());
		
		boolean visit[] = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				search(visit, num, num[i], i);
				visit[i] = false;
			}
		}
		
		bw.write(list.size()+"\n");
		for(int i=0; i<list.size(); i++)
			bw.write(list.get(i)+"\n");
		
		bw.flush();	
	}
}