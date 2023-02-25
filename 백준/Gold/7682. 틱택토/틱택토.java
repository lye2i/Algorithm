import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static boolean game(char ttt[]) {
		int px = 0, po = 0, b = 0;
		boolean x = false, o = false;
		
		for(int i=0; i<9; i++) {
			if(ttt[i] == 'X')	px++;
			else if(ttt[i] == 'O')	po++;
			else b++;
		}
		
		if(px-po > 1 || px < po)	return false;
		
		for(int i=1; i<8; i+=3) {
			if(ttt[i-1] == ttt[i] && ttt[i] == ttt[i+1]) {
				if(ttt[i] == 'X')	x = true;
				else if(ttt[i] == 'O')	o = true;
			}
		}
		
		for(int i=3; i<6; i++) {
			if(ttt[i] == ttt[i-3] && ttt[i] == ttt[i+3]) {
				if(ttt[i] == 'X')	x = true;
				else if(ttt[i] == 'O')	o = true;
			}
		}
		
		if(ttt[4] == 'X') {
			if((ttt[4] == ttt[0] && ttt[4] == ttt[8]) || (ttt[4] == ttt[2] && ttt[4] == ttt[6]))	x = true;
		} else if (ttt[4] == 'O') {
			if((ttt[4] == ttt[0] && ttt[4] == ttt[8]) || (ttt[4] == ttt[2] && ttt[4] == ttt[6]))	o = true;
		}
		
		if(!x && !o && b == 0)	return true;
		if(!x && o && px == po)	return true;
		if(x && !o && px > po)	return true;
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			char ttt[] = br.readLine().toCharArray();
			if(ttt[0] == 'e')	break;
			
			if(game(ttt))	sb.append("valid\n");
			else	sb.append("invalid\n");
		}
		
		System.out.print(sb);
	}
}