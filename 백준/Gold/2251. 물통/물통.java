import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashSet<Integer> answer;
	static ArrayList<String> water;
	
	public static void getWater(int bucket[][], String str) {
		if(bucket[0][1] == 0)	answer.add(bucket[2][1]);
		if(water.contains(str))	return;
		water.add(str);
		
		if(bucket[2][1] > 0) {
			if(bucket[0][0] - bucket[0][1] > 0) pourWater(bucket, 0, 2);
			if(bucket[1][0] - bucket[1][1] > 0) pourWater(bucket, 1, 2);
		}
		
		if(bucket[1][1] > 0) {
			if(bucket[0][0] - bucket[0][1] > 0) pourWater(bucket, 0, 1);
			if(bucket[2][0] - bucket[2][1] > 0) pourWater(bucket, 2, 1);
		}
		
		if(bucket[0][1] > 0) {
			if(bucket[1][0] - bucket[1][1] > 0) pourWater(bucket, 1, 0);
			if(bucket[2][0] - bucket[2][1] > 0) pourWater(bucket, 2, 0);
		}
	}
	
	public static void pourWater(int bucket[][], int f, int b) {
		int min = Math.min(bucket[f][0] - bucket[f][1], bucket[b][1]);
		bucket[f][1] += min;
		bucket[b][1] -= min;
		String str = ""+bucket[0][1]+bucket[1][1]+bucket[2][1];
		getWater(bucket, str);
		bucket[f][1] -= min;
		bucket[b][1] += min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = new HashSet<Integer>();
		water = new ArrayList<String>();
		int bucket[][] = new int[3][2];
		bucket[0][0] = Integer.parseInt(st.nextToken());
		bucket[1][0] = Integer.parseInt(st.nextToken());
		bucket[2][0] = bucket[2][1] = Integer.parseInt(st.nextToken());
		String str = ""+bucket[0][1]+bucket[1][1]+bucket[2][1];
		getWater(bucket, str);
		
		ArrayList<Integer> list = new ArrayList<Integer>(answer);
		Collections.sort(list);
		for(int i : list) {
			bw.write(i+" ");
		}
		bw.flush();
	}
}