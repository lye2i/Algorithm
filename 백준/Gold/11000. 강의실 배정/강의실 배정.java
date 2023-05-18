import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> room = new PriorityQueue<Integer>();
		PriorityQueue<int[]> lesson = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lesson.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for(int i=0; i<N; i++) {
			int l[] = lesson.poll();
			while(!room.isEmpty() && room.peek() <= l[0]) {
				room.poll();
			}
			room.add(l[1]);
			answer = Math.max(answer, room.size());
		}
		
		System.out.print(answer);
	}
}