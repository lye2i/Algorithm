import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char V[][] = new char[4][8];
	static int D[] = new int[4];
	
	public static boolean rotation(int left, int right) {
		if(V[left][(D[left]+10)%8] != V[right][(D[right]+6)%8])	return true;
		else	return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++)	V[i] = br.readLine().toCharArray();
		int K = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			int T[] = new int[4];
			T[n] = d;
			
			switch(n) {
				case 0 : {
					for(int j=0; j<3; j++) {
						if(rotation(j, j+1))	T[j+1] = -T[j];
						else	break;
					}
					break;
				}
				case 1 : {
					if(rotation(0, 1))	T[0] = -T[1];
					for(int j=1; j<3; j++) {
						if(rotation(j, j+1))	T[j+1] = -T[j];
						else	break;
					}
					break;
				}
				case 2 : {
					if(rotation(2, 3))	T[3] = -T[2];
					for(int j=2; j>0; j--) {
						if(rotation(j-1, j))	T[j-1] = -T[j];
						else	break;
					}
					break;
				}
				case 3 : {
					for(int j=3; j>0; j--) {
						if(rotation(j-1, j))	T[j-1] = -T[j];
						else	break;
					}
					break;
				}
			}
			
			for(int j=0; j<4; j++) {
				if(T[j] > 0)	D[j]--;
				else if(T[j] < 0)	D[j]++;
				if(D[j] < 0)	D[j] += 8;
			}
		}
		
		for(int i=0; i<4; i++) {
			ans += (V[i][(D[i]+8)%8]-'0') * (int)Math.pow(2, i);
		}
		
		System.out.print(ans);
	}
}