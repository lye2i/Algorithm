import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };
	static int map[][];
	static int N, min;

	public static void search(int r, int c, boolean check[][]) {
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > min && check[nr][nc] == false) {
				check[nr][nc] = true;
				search(nr, nc, check);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = 100;
		int h = 0, max = 1, answer = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}

		while (min != max) {
			boolean check[][] = new boolean[N][N];
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > min && check[i][j] == false) {
						search(i, j, check);
						cnt++;
					}
				}
			}

			answer = Math.max(cnt, answer);
			min++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
	}
}