import java.io.*;
import java.util.*;

public class Main {
	static int N, B[], A[][];
	static Stack<int[]> stack;
	static StringBuilder sb;
	
	static void leftSearch() {
		for(int i=N-1; i>=0; i--) {
			if(stack.isEmpty() || stack.peek()[1] > B[i])	stack.push(new int[] {i, B[i]});
			else {
				while(!stack.isEmpty() && stack.peek()[1] <= B[i]) {
					int b[] = stack.pop();
					
					if(!stack.isEmpty()) {
						if(A[b[0]][0] == 0 || Math.abs(b[0]-stack.peek()[0]) < Math.abs(A[b[0]][1]-b[0]))	A[b[0]][1] = stack.peek()[0];
						A[b[0]][0] += stack.size();
					}
				}
				stack.push(new int[] {i, B[i]});
			}
		}
		
		while(!stack.isEmpty()) {
			int b[] = stack.pop();
			if(!stack.isEmpty()) {
				if(A[b[0]][0] == 0 || Math.abs(b[0]-stack.peek()[0]) < Math.abs(A[b[0]][1]-b[0]))	A[b[0]][1] = stack.peek()[0];
				A[b[0]][0] += stack.size();
			}
		}
	}
	
	static void rightSearch() {
		for(int i=0; i<N; i++) {
			if(stack.isEmpty() || stack.peek()[1] > B[i])	stack.push(new int[] {i, B[i]});
			else {
				while(!stack.isEmpty() && stack.peek()[1] <= B[i]) {
					int b[] = stack.pop();
					
					if(!stack.isEmpty()) {
						A[b[0]][0] = stack.size();
						A[b[0]][1] = stack.peek()[0];
					}
				}
				stack.push(new int[] {i, B[i]});
			}
		}
		
		while(!stack.isEmpty()) {
			int b[] = stack.pop();
			if(!stack.isEmpty()) {
				A[b[0]][0] = stack.size();
				A[b[0]][1] = stack.peek()[0];
			}
		}
	}
	
	static void print() {
		for(int b[] : A) {
			if(b[0] == 0)	sb.append(0).append("\n");
			else	sb.append(b[0]).append(" ").append(b[1]+1).append("\n");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		B = new int[N];
		A = new int[N][2];
		stack = new Stack<int[]>();
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		rightSearch();
		leftSearch();
		print();
		
		System.out.print(sb);
	}
}