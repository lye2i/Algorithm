import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int search(int A, int B) {
		Queue<int[]> queue = new LinkedList<int[]>();
		HashSet<Integer> set = new HashSet<Integer>();
		queue.offer(new int[] {A, 1});
		set.add(A);
		
		while(!queue.isEmpty()) {
			int a[] = queue.poll();
			if((long)a[0]*2 <= B && !set.contains(a[0]*2)) {
				if(a[0]*2 == B)	return a[1]+1;
				set.add(a[0]*2);
				queue.add(new int[] {a[0]*2, a[1]+1});
			}
			if((long)a[0]*10+1 <= B && !set.contains(a[0]*10+1)) {
				if(a[0]*10+1 == B)	return a[1]+1;
				set.add(a[0]*10+1);
				queue.add(new int[] {a[0]*10+1, a[1]+1});
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.print(search(A, B));
	}
}