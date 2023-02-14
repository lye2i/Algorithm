import java.io.*;
import java.util.*;

public class Main {
	static class Team{
		int n = 0, score = 0, five = 0;
		Team(int n, int score, int five){
			this.n = n;
			this.score = score;
			this.five = five;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			int T = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> team = new HashMap<Integer, Integer>();
			HashMap<Integer, ArrayList<Integer>> score = new HashMap<Integer, ArrayList<Integer>>();
			ArrayList<Team> teamList = new ArrayList<Team>();
			int game[] = new int[T];
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<T; i++) {
				int t = Integer.parseInt(st.nextToken());
				team.put(t, team.getOrDefault(t, 0)+1);
				game[i] = t;
			}
			
			for(int i=0; i<T; i++) {
				 if(team.get(game[i]) != 6) cnt++;
				 else {
					 if(!score.containsKey(game[i]))	score.put(game[i], new ArrayList<Integer>());
					 score.get(game[i]).add(i+1-cnt);
				 }
			}
			
			for(Integer k : score.keySet()) {
				int sum = score.get(k).get(0) + score.get(k).get(1) + score.get(k).get(2) + score.get(k).get(3);
				teamList.add(new Team(k, sum, score.get(k).get(4)));
			}
			
			Collections.sort(teamList, new Comparator<Team>() {
				@Override
				public int compare(Team a, Team b) {
					if(a.score == b.score)	return a.five - b.five;
					return a.score - b.score;
				}
			});
			
			sb.append(teamList.get(0).n).append("\n");
		}
		
		System.out.print(sb);
	}
}