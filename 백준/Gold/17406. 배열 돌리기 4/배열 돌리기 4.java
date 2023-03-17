import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, Ans;
	static int[] R, C, S;
	static int arr[][];

	public static int rotation(int[] sel) {
		int[][] tmp = new int[N][M];		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		
		for (int c = 0; c < K; c++) {
			int idx = sel[c];
			int SX = R[idx] - S[idx] - 1;
			int SY = C[idx] - S[idx] - 1;
			int EX = R[idx] + S[idx] - 1;
			int EY = C[idx] + S[idx] - 1;
			int r = Math.min(EX - SX, EY - SY) / 2;
			
			for (int k = 0; k < r; k++) {
				int i = SX + k, j = SY + k;
				int start = tmp[i][j];
				
				for (; i < EX - k; i++) { // 아
					tmp[i][j] = tmp[i + 1][j];
				}
				
				for (; j < EY - k; j++) { // 오
					tmp[i][j] = tmp[i][j + 1];
				}
				
				for (; i > SX + k; i--) { // 위
					tmp[i][j] = tmp[i - 1][j];
				}
				
				for (; j > SY + k + 1; j--) { // 왼
					tmp[i][j] = tmp[i][j - 1];
				}
				
				tmp[i][j] = start;
			}
		}
		
		return cal(tmp);
	}

	public static void select(boolean check[], int cnt, int[] turn) {
		if (cnt == K) {
			Ans = Math.min(Ans, rotation(turn));
			return;
		}

		for (int i = 0; i < K; i++) {
			if (check[i] == false) {
				check[i] = true;
				turn[cnt] = i;
				select(check, cnt + 1, turn);
				check[i] = false;
			}
		}
	}

	public static int cal(int[][] tmp) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += tmp[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = new int[K];
		C = new int[K];
		S = new int[K];
		Ans = Integer.MAX_VALUE;
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}

		select(new boolean[K], 0, new int[K]);
		System.out.println(Ans);
	}
}