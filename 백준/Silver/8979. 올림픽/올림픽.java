import java.io.*;
import java.util.*;

public class Main {
	static class Nation {
		int idx, gold, silver, bronze;
		
		Nation(int idx, int gold, int silver, int bronze){
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 1;
		Nation nations[] = new Nation[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			nations[i] = new Nation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nations, new Comparator<Nation>() {
			@Override
			public int compare(Nation a, Nation b) {
				if(a.gold == b.gold && a.silver == b.silver)	return a.bronze - b.bronze;
				else if(a.gold == b.gold)	return a.silver - b.silver;
				else	return a.gold - b.gold;
			}
		});
		
		if(nations[0].idx != K) {
			int cnt = 1;
			for(int i=1; i<N; i++) {
				if(nations[i].idx == K)	break;
				
				if(nations[i].gold == nations[i-1].gold && nations[i].silver == nations[i-1].silver && nations[i].bronze == nations[i-1].bronze)	cnt++;
				else {
					answer += cnt;
					cnt = 1;
				}
			}
		}
		
		System.out.print(answer);
	}

}