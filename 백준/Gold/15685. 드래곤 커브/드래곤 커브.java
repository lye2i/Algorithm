import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean map[][] = new boolean[101][101];
	static int r[] = {0, -1, 0, 1};
	static int c[] = {1, 0, -1, 0};
	
	public static void dragon(int x, int y, int g, int idx, ArrayList<Integer> list) {
		if(idx == g) return;
		
		for(int i = list.size()-1; i>=0; i--) {
			int d  = (list.get(i)+1) % 4;
			x += r[d];
			y += c[d];

			map[x][y] = true;
			list.add(d);
		}
		
		dragon(x, y, g, idx+1, list);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			map[x][y] = true;
			x += r[d];
			y += c[d];
			map[x][y] = true;
			
			if(g > 0)	{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(d);
				dragon(x, y, g, 0, list);
			}
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])	ans++;
			}
		}
		
		System.out.print(ans);
	}
}