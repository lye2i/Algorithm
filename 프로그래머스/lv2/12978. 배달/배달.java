import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int array[][] = new int[N+1][N+1];
        int dist[] = new int[N+1];
        boolean visited[] = new boolean[N+1];
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j)    continue;
                array[i][j] = 500001;
            }
        }
        
        for(int i=0; i<road.length; i++){
            if(array[road[i][0]][road[i][1]] > road[i][2]) {
                array[road[i][0]][road[i][1]] = road[i][2];
                array[road[i][1]][road[i][0]] = road[i][2];
            }
        }
        
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++) {
                    if(array[i][j] > array[i][k] + array[k][j]) array[i][j] = array[i][k] + array[k][j];
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(array[1][i] <= K)    answer++;
        }
        
        
        return answer;
    }
}