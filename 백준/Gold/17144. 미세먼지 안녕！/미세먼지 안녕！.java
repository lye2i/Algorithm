import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int arr[][] = new int[R][C];
		int dr[] = {-1,0,0,1};
		int dc[] = {0,1,-1,0};
		int air=0, ans=0;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) {
					air = i;
				}
			}
		}
		
		while(--T>=0) {		
			int tmp[][] = new int[R][C];
			
			for(int i=0; i<R; i++) { //미세먼지 확산 수행
				for (int j = 0; j < C; j++) {
					if(arr[i][j] > 0) {
						int cnt = 0;
						for(int d=0; d<4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr>=0 && nr<R && nc>=0 && nc<C && arr[nr][nc]!=-1) {
								tmp[nr][nc] += arr[i][j]/5;
								cnt++;
							}
						}
						arr[i][j] = arr[i][j]-(arr[i][j]/5)*cnt;
					}
				}
			}
			
			for(int i=0; i<R; i++) { //미세먼지 확산을 다 하고 난 후 현재의 상태 갱신
				for(int j=0; j<C; j++) {
					arr[i][j] += tmp[i][j];
				}
			}
			
			int i=air-2, j=0; //위쪽 공기청정기
			while(i-1>=0)
				arr[i][j] = arr[--i][j];
							
			while(j+1<C)
				arr[i][j] = arr[i][++j];
			
			while(i+1<=air-1)
				arr[i][j] = arr[++i][j];
				
			while(j-1>0)
				arr[i][j] = arr[i][--j];
			arr[i][j] = 0;
								
			i=air+1;
			j=0; //아래쪽 공기청정기
			while(i+1<R) //아래
				arr[i][j] = arr[++i][j];
			
			while(j+1<C) //오른쪽
				arr[i][j] = arr[i][++j];
			
			while(i-1>=air) //위쪽
				arr[i][j] = arr[--i][j];
		
			while(j-1>0) //왼쪽
				arr[i][j] = arr[i][--j];
			arr[i][j] = 0;
		}
		
		for(int i=0; i<R; i++) { // 미세먼지의 양 구하기
			for(int j=0; j<C; j++) {
				if(arr[i][j]>0)
					ans += arr[i][j];
			}
		}
		System.out.println(ans);
	}
}