import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();

		int S = sc.nextInt(); //힉생 수
		for(int i=0; i<S; i++) {
			int gender = sc.nextInt();
			int n = sc.nextInt();
			
			if(gender==1) { //남학생
				for(int j=1; j*n-1<N; j++) {
					arr[j*n-1] = Math.abs(arr[j*n-1]-1);
				}
			}
			
			else { //여학생
				n--; //배열에 맞춰서
				arr[n] = Math.abs(arr[n]-1); // 받은 번호에 해당하는 건 상태 무조건 바꿈
				
				for(int j=1; n-j>=0 && n+j<N; j++) { // 대칭인 경우 상태 바꿈
					if(arr[n-j] != arr[n+j])
						break;
					arr[n-j] = Math.abs(arr[n-j]-1);
					arr[n+j] = arr[n-j];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(i/20>0 && i%20==0)
				System.out.println();
			System.out.print(arr[i]+" ");
		}
	}
}