import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> tree = new HashMap<String, Integer>();
		ArrayList<String> names = new ArrayList<String>();
		int total = 0;
		
		while(true) {
			String name = br.readLine();
			
			if(name == null)	break;
			
			if(tree.containsKey(name))	tree.put(name, tree.get(name)+1);
			else {
				tree.put(name, 1);
				names.add(name);
			}
			
			total++;
		}
		
		Collections.sort(names);
		
		for(String name : names) {
			double rate = (tree.get(name)*100.0)/total;
			sb.append(name + " " + String.format("%.4f", rate) + "\n");
		}
		
		System.out.print(sb);
	}
}