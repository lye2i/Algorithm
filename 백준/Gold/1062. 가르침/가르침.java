import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans;
	static ArrayList<HashSet<Integer>> words;
	static ArrayList<Integer> alpha;
	static boolean eng[];
	
	static void init(HashSet<Integer> set) {
		eng = new boolean[26];
		eng['a'-'a'] = true;
		eng['n'-'a'] = true;
		eng['t'-'a'] = true;
		eng['i'-'a'] = true;
		eng['c'-'a'] = true;
		
		alpha = new ArrayList<Integer>();
		for(int i : set) {
			if(!eng[i]) alpha.add(i);
		}
	}
	
	static void teach(int idx, int cnt) {
		if(cnt == M) {
			read();
			return;
		}
		
		for(int i=idx; i<alpha.size(); i++) {
			if(!eng[alpha.get(i)]) {
				eng[alpha.get(i)] = true;
				teach(i+1, cnt+1);
				eng[alpha.get(i)] = false;
			}
		}
	}
	
	static void read() {
		int cnt = 0;
		for(HashSet<Integer> word : words) {
			boolean flag = true;
			for(int i : word) {
				if(!eng[i]) {
					flag = false;
					break;
				}
			}
			
			if(flag)	cnt++;
		}
		
		ans = Math.max(ans, cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken())-5;
		ans = 0;
		words = new ArrayList<HashSet<Integer>>();
		HashSet<Integer> total = new HashSet<Integer>();
		
		for(int i=0; i<N; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			char word[] = br.readLine().toCharArray();
			
			for(int j=4; j<word.length-4; j++) {
				set.add(word[j]-'a');
				total.add(word[j]-'a');
			}
			
			words.add(set);
		}
		
		init(total);
		if(M >= alpha.size())	ans = N;
		else if(M >= 0)	teach(0, 0);
		
		System.out.print(ans);
	}
}