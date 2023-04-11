import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, map[][], fx, fy, ans;
	static HashMap<Integer, LinkedList<Integer>> posMap;
	static Person[] person;
	static int R[] = {-1,1,0,0,-1,-1,1,1}, C[] = {0,0,-1,1,-1,1,-1,1};
	
	static class Person {
		int x, y;
		boolean out;
		
		Person(int x, int y) {
			this.x = x;
			this.y = y;
			this.out = false;
		}
	}
	
	static void move() {
		for(int i=0; i<M; i++) {
			Person p = person[i];
			if(p.out)	continue;
			
			int d = Math.abs(p.x - fx) + Math.abs(p.y - fy);
			int x = p.x, y = p.y;
			
			for(int j=0; j<4; j++) {
				int dr = p.x + R[j];
				int dc = p.y + C[j];
				if(dr > 0 && dr <= N && dc > 0 && dc <= N && map[dr][dc] == 0) {
					int nd = Math.abs(dr - fx) + Math.abs(dc - fy);
					if(nd < d) {
						d = nd;
						x = dr;
						y = dc;
					}
				}
			}
			
			if(x != p.x || y != p.y) {
				ans++;
				
				int point = p.x*100 + p.y;
				LinkedList<Integer> list = posMap.get(point);
				for(int l = 0; l<list.size(); l++) {
					if(list.get(l) == i) {
						list.remove(l);
						break;
					}
				}
				
				if(d == 0)	p.out = true;
				else {
					point = x*100 + y;
					if(!posMap.containsKey(point))	posMap.put(point, new LinkedList<Integer>());
					posMap.get(point).add(i);
					p.x = x;
					p.y = y;
				}
			}
		}
    }

	static boolean outPerson() {
		for(int i=0; i<M; i++) {
			if(!person[i].out)	return false;
		}
		return true;
	}
	
	static boolean getRect(int n) {
		int rect[][] = new int[4][2];

		for(int d=4; d<8; d++) {
			int dr = fx + R[d]*(n-1);
			int dc = fy + C[d]*(n-1);
			
			if(dr < 1)	dr = 1;
			else if(dr > N)	dr = N;
			
			if(dc < 1)	dc = 1;
			else if(dc > N)	dc = N;
			
			rect[d-4][0] = dr;
			rect[d-4][1] = dc;
		}
		
		if(checkRect(n, rect))	return true;
		else	return false;
	}
	
	static boolean checkRect(int n, int rect[][]) {
		if(rect[1][1]-rect[0][1] < n-1 || rect[2][0]-rect[0][0] < n-1)	return false;
		
		for(int i=rect[0][0]; rect[2][0]-i >= n-1; i++) {
			for(int j=rect[0][1]; rect[1][1]-j >= n-1; j++) {
				ArrayList<Integer> mp = new ArrayList<Integer>();
				
				for(int ni = 0; ni < n; ni++) {
					for(int nj = 0; nj < n; nj++) {
						int point = (i+ni)*100+(j+nj);
						if(posMap.containsKey(point) && posMap.get(point).size() > 0) {
							LinkedList<Integer> list = posMap.get(point);
							for(int p : list) {
								mp.add(p);
							}
						}
					}
				}
				
				if(mp.size() > 0) {
					rotation(i, i+(n-1), j, j+(n-1), n);
					changePoint(mp, i, i+(n-1), j, j+(n-1));
					return true;
				}				
			}
		}
		
		return false;
	}
	
	static void rotation(int sr, int fr, int sc, int fc, int n) {
		int tmp[][] = new int[N+1][N+1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				tmp[i+sr][j+sc] = map[fr-j][sc+i];
			}
		}
		
		for(int i = sr; i <= fr; i++) {
			for(int j = sc; j <= fc; j++) {
				map[i][j] = tmp[i][j] > 0 ? --tmp[i][j] : tmp[i][j];
			}
		}
	}
	
	static void changePoint(ArrayList<Integer> mp, int sr, int fr, int sc, int fc) {
		int i = fy - sc;
		int j = fr - fx;
		fx = i + sr;
		fy = j + sc;

		for(int p : mp) {
			Person ps = person[p];
			int point = ps.x*100 + ps.y;
			i = ps.y - sc;
			j = fr - ps.x;
			ps.x = i + sr;
			ps.y = j + sc;
			int npoint = ps.x*100 + ps.y;
			
			if(point != npoint) {
				if(!posMap.containsKey(npoint))	posMap.put(npoint, new LinkedList<Integer>());
				
				LinkedList<Integer> list = posMap.get(point);
				for(int l=0; l<list.size(); l++) {
					if(list.get(l) == p) {
						list.remove(l);
						posMap.get(npoint).add(p);
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		person = new Person[M];
		posMap = new HashMap<Integer, LinkedList<Integer>>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			person[i] = new Person(x, y);
			if(!posMap.containsKey(x*100+y))	posMap.put(x*100+y, new LinkedList<Integer>());
			posMap.get(x*100+y).add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		fx = Integer.parseInt(st.nextToken());
		fy = Integer.parseInt(st.nextToken());
		
		while(K-- > 0) {
			move();
			if(outPerson())	break;
			
            for(int n=2; n<=N; n++) {
				if(getRect(n))	break;
			}
		}
		
		sb.append(ans).append("\n").append(fx).append(" ").append(fy);
		System.out.print(sb);
	}
}
