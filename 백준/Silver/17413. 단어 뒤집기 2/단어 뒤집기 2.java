import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		String answer = "";
		int check = 0;
		while(true) {
			if(check==S.length())
				break;
			
			if(S.charAt(check)=='<') {
				while(S.charAt(check)!='>') {
					answer += S.charAt(check++);
				}
				answer += S.charAt(check++);
			}
			else {
				String s = "";
				while(check!=S.length() && S.charAt(check)!=' ' && S.charAt(check)!='<') {
					s += S.charAt(check++);
				}
				for(int i=s.length()-1; i>=0; i--)
					answer += s.charAt(i);
				
				if(check!=S.length() && S.charAt(check)==' ') {
					answer += ' ';
					check++;
				}
			}
		}
		System.out.println(answer);
	}
}