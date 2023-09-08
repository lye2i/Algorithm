import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, S[][], G[][], turn[];
	static ArrayList<int[]> empty = new ArrayList<>();
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void first(int n) { // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸이 가장 많은 칸 구하기
		ArrayList<int[]> list = new ArrayList<>();
		int max = 0;
		
		for(int i=0; i<empty.size(); i++) {
			int cnt=0;
			for(int d=0; d<4; d++) {
				int r = empty.get(i)[0] + dr[d];
				int c = empty.get(i)[1] + dc[d];
				if(r>=0 && r < N && c>=0 && c<N) {
					for(int k=0; k<4; k++) {
						if(G[r][c]==S[n][k])
							cnt++;
					}
				}
			}
			
			if(cnt>=max) {
				list.add(new int[] {i,cnt});
				max = cnt;
			}
		}
		
		for(int i=list.size()-1; i>=0; i--) { // 좋아하는 학생이 인접한 칸이 가장 많은 칸만 남기기
			if(list.get(i)[1]<max)
				list.remove(i);
		}
		
		if(list.size()==1) { // 칸이 하나만 있는 경우
			int r = empty.get(list.get(0)[0])[0];
			int c = empty.get(list.get(0)[0])[1];
			G[r][c] = n;
			empty.remove(list.get(0)[0]);
		}else if(list.size()==0)	second(empty, n); // 칸이 하나도 없는 경우 비어있는 칸 중 인접하게 비어있는 칸이 가장 많은 칸으로 정하도록
		else	second(list, n); // 칸이 여러개인 경우 인접한 칸 중 비어있는 칸이 가장 많은 칸으로
	}
	
	public static void second(ArrayList<int[]> list, int n) { // first을 만족하는 칸이 여러 개인 경우
		int max = -1, idx = 0, seat = 0;
		
		for(int i=0; i<list.size(); i++) {
			int cnt = 0;
			seat = list.get(i)[0];
			for(int d=0; d<4; d++) {
				int r = empty.get(seat)[0] + dr[d];
				int c = empty.get(seat)[1] + dc[d];
				if(r>=0 && r<N && c>=0 && c<N && G[r][c]==0)	cnt++;
			}
			if(cnt>max) {
				max = cnt;
				idx = i;
			}
		}
		
		seat = list.get(idx)[0];
		G[empty.get(seat)[0]][empty.get(seat)[1]] = n;
		empty.remove(seat);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N*N+1][4];
		G = new int[N][N];
		turn = new int[N*N];
		int ans = 0;
		
		for(int i=0; i<N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			turn[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<4; j++) {
				S[turn[i]][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) { // 비어있는 칸들 리스트에 넣기
			for(int j=0; j<N; j++)
				empty.add(new int[] {i,j});
		}
		
		for(int i=0; i<N*N; i++)
			first(turn[i]);
		
		for(int i=0; i<N; i++) { // 학생의 만족도 구하기
			for(int j=0; j<N; j++) {
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int r = i + dr[d];
					int c = j + dc[d];
					if(r>=0 && r<N && c>=0 && c<N) {
						for(int k=0; k<4; k++) {
							if(G[r][c] == S[G[i][j]][k])
								cnt++;
						}
					}
				}
				
				switch(cnt) {
				case 0:	ans += 0;
						break;
				case 1:	ans += 1;
						break;
				case 2:	ans += 10;
						break;
				case 3: ans += 100;
						break;
				case 4:	ans += 1000;
						break;
				}
			}
		}
		
		System.out.println(ans);
	}
}