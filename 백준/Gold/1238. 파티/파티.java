import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;
	static ArrayList<Road>[] startRoad, endRoad;
	static int goTime[], backTime[];
	static PriorityQueue<Road> pq;
	
	static class Road implements Comparable<Road>{
		int e, t;
		
		Road(int e, int t) {
			this.e = e;
			this.t = t;
		}
		
		@Override
		public int compareTo(Road r) {
			return this.t - r.t;
		}
	}
	
	private static void Dijkstra1() {
		boolean visit[] = new boolean[N];
		goTime[X] = 0;
		pq.add(new Road(X, 0));
		
		while(!pq.isEmpty()) {
			int r = pq.poll().e;
			
			if(visit[r])	continue;
			visit[r] = true;
			
			for(Road road : startRoad[r]) {
				if(goTime[road.e] > goTime[r] + road.t) {
					goTime[road.e] = goTime[r] + road.t;
					pq.add(new Road(road.e, goTime[road.e]));
				}
			}
		}
	}
	
	private static void Dijkstra2() {
		boolean visit[] = new boolean[N];
		backTime[X] = 0;
		pq.add(new Road(X, 0));
		
		while(!pq.isEmpty()) {
			int r = pq.poll().e;
			
			if(visit[r])	continue;
			visit[r] = true;
			
			for(Road road : endRoad[r]) {
				if(backTime[road.e] > backTime[r] + road.t) {
					backTime[road.e] = backTime[r] + road.t;
					pq.add(new Road(road.e, backTime[road.e]));
				}
			}
		}
	}
	
	private static int maxTime() {
		int max = 0;
		for(int i=0; i<N; i++) {
			if(goTime[i] + backTime[i] > max)	max = goTime[i] + backTime[i];
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		goTime = new int[N];
		backTime = new int[N];
		startRoad = new ArrayList[N];
		endRoad = new ArrayList[N];
		pq = new PriorityQueue<Road>();
		
		Arrays.fill(goTime, Integer.MAX_VALUE);
		Arrays.fill(backTime, Integer.MAX_VALUE);
		for(int i=0; i<N; i++) {
			startRoad[i] = new ArrayList<Road>();
			endRoad[i] = new ArrayList<Road>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			
			startRoad[start].add(new Road(end, t));
			endRoad[end].add(new Road(start, t));
		}

		Dijkstra1();
		Dijkstra2();
		System.out.print(maxTime());
	}
}