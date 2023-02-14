import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char cookie[][] = new char[N][N];
		StringBuilder sb = new StringBuilder();
		int r = 0, c = 0, leftArm = 0, rightArm = 0, center = 0, leftLeg = 0, rightLeg = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				cookie[i][j] = str.charAt(j);
				if(c == 0 && cookie[i][j] == '*') {
					r = i+1;
					c = j;
				}
			}
		}
		
		sb.append(r+1).append(" ").append(c+1).append("\n");
		
		for(int i=r, j=c-1; j>=0; j--) {
			if(cookie[i][j] == '_')	break;
			leftArm++;
		}
		
		for(int i=r, j=c+1; j<N; j++) {
			if(cookie[i][j] == '_')	break;
			rightArm++;
		}
		
		for(int i=r+1, j=c; i<N; i++) {
			if(cookie[i][j] == '_') {
				r = i-1;
				break;
			}
			center++;
		}
		
		for(int i=r+1, j=c-1; i<N; i++) {
			if(cookie[i][j] == '_')	break;
			leftLeg++;
		}
		
		for(int i=r+1, j=c+1; i<N; i++) {
			if(cookie[i][j] == '_')	break;
			rightLeg++;
		}
		
		sb.append(leftArm+" "+rightArm+" "+center+" "+leftLeg+" "+rightLeg);
		System.out.print(sb);
	}
}