import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer> friend[];
	
	static int search(int n) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visit[] = new boolean[N+1];
		queue.add(new int[] {n, 0});
		visit[n] = true;
		int min = 1;
		
		while(!queue.isEmpty()) {
			int f[] = queue.poll();
			if(min < f[1])	min = f[1];
			
			for(int i : friend[f[0]]) {
				if(!visit[i])	{
					visit[i] = true;
					queue.add(new int[] {i, f[1]+1});
				}
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		friend = new ArrayList[N+1];
		int point[] = new int[N+1];
		int min = Integer.MAX_VALUE, cnt = 0;
		
		for(int i=0; i<=N; i++) {
			friend[i] = new ArrayList<Integer>();
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			
			if(f1 == -1 && f2 == -1)	break;
			
			friend[f1].add(f2);
			friend[f2].add(f1);
		}
		
		for(int i=1; i<=N; i++) {
			point[i] = search(i);
			
			if(min == point[i])	cnt++;
			else if(min > point[i]) {
				min = point[i];
				cnt = 1;
			}
		}
		
		sb.append(min).append(' ').append(cnt).append('\n');
		for(int i=1; i<=N; i++) {
			if(point[i] == min)	sb.append(i).append(' ');
		}
		System.out.print(sb);
	}
}