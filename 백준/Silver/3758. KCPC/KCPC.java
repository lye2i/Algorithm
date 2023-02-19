import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Team implements Comparable<Team>{
		int id, score, cnt, time;
		
		Team(int id, int score, int cnt, int time) {
			this.id = id;
			this.score = score;
			this.time = time;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Team o) {
			if(this.score == o.score) {
				if(this.cnt == o.cnt)	return this.time - o.time;
				else	return this.cnt - o.cnt;
			}
			else	return o.score - this.score;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int score[][] = new int[n][k+2];
			Team[] team = new Team[n];
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				score[id-1][0]++;
				score[id-1][k+1] = i;
				if(score[id-1][j] < s)	score[id-1][j] = s;
			}
			
			for(int i=0; i<n; i++) {
				int sum = 0;
				for(int j=1; j<=k; j++)
					sum += score[i][j];
				team[i] = new Team(i+1, sum, score[i][0], score[i][k+1]);
			}
			
			Arrays.sort(team);
			
			for(int i=0; i<n; i++) {
				if(team[i].id == t) {
					sb.append(i+1).append("\n");
					break;
				}
			}
			
		}
		
		System.out.print(sb);
	}
}