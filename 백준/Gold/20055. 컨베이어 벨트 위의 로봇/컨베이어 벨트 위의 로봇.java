import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static class Robot {
		int r;
		Robot(int r) {
			this.r = r;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A[] = new int[2*N];
		int size = 2*N, ans = 0, cnt = 0;
		LinkedList<Robot> robot = new LinkedList<Robot>();
		Deque<Integer> belt1 = new ArrayDeque<Integer>();
		Deque<Integer> belt2 = new ArrayDeque<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i < N; i++) {
			belt1.add(i);
			belt2.add(2*N-i-1);
		}
		
		while(cnt < K) {
			ans++;
			belt2.addLast(belt1.pollLast());
			belt1.addFirst(belt2.pollFirst());
			
			if(robot.size() != 0 && belt1.peekLast() == robot.get(0).r)	robot.remove(0);
				
			for(int i=0; i<robot.size(); i++) {
				int b = (robot.get(i).r+1)%size;
				
				if(A[b] > 0) {
					if(i == 0 || robot.get(i-1).r != b) {
						if(--A[b] == 0) cnt++;
						robot.get(i).r = b;
					}
				}
			}
			
			if(robot.size() != 0 && belt1.peekLast() == robot.get(0).r)	robot.remove(0);
			
			if(A[belt1.peekFirst()] > 0) {
				if(--A[belt1.peekFirst()] == 0)	cnt++;
				robot.add(new Robot(belt1.peekFirst()));
			}
		}
		
		System.out.print(ans);
	}
}