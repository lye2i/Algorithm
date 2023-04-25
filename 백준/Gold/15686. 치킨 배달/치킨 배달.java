import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static ArrayList<int[]> house, chicken;
	
	static void select(int start, int cnt, int c[]) {
		if(cnt==M) {
			ans = Math.min(ans, chickenStreet(c));
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			c[cnt] = i;
			select(i+1,cnt+1,c);	
		}
	}
	
	static int chickenStreet(int sel[]) {
		int sum = 0;
		for(int i=0; i<house.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<M; j++) {
				int d = Math.abs(house.get(i)[0]-chicken.get(sel[j])[0]) + Math.abs(house.get(i)[1]-chicken.get(sel[j])[1]);
				min = Math.min(d,min);
			}
			sum += min;
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1)
					house.add(new int[] {i,j});
				else if(n==2)
					chicken.add(new int[] {i,j});
			}
		}
		
		select(0,0, new int[chicken.size()]);
		
		System.out.println(ans);
	}
}