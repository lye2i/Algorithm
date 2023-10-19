import java.util.*;

class Solution {
    static final int MAX = 20000001;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int route[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            Arrays.fill(route[i], MAX);
            route[i][i] = 0;
        }
        
        for(int f[] : fares) {
            route[f[0]][f[1]] = f[2];
            route[f[1]][f[0]] = f[2];
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
                }
            }
        }
        
        int answer = route[s][a] + route[s][b];
        for(int i=1; i<=n; i++) {
            answer = Math.min(answer, route[s][i] + route[i][a] + route[i][b]);
        }
        return answer;
    }
}