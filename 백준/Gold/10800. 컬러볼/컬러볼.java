import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Ball implements Comparable<Ball>{
	int idx, color, size;
	
	Ball(int idx, int color, int size) {
		this.idx = idx;
		this.color = color;
		this.size = size;
	}
	
	@Override
	public int compareTo(Ball b) {
		return this.size - b.size;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int C[] = new int[N];
		int A[] = new int[N];
		int sum = 0;
		Ball ball[] = new Ball[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ball[i] = new Ball(i, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ball);
		
		for(int i=0, j=0; i<N; i++) {
			Ball b = ball[i];
			while(ball[j].size < b.size) {
				sum += ball[j].size;
				C[ball[j].color] += ball[j].size;
				j++;
			}
			A[b.idx] = sum - C[b.color];
		}

		for(int a : A) {
			sb.append(a).append("\n");
		}
		
		System.out.print(sb);
	}
}