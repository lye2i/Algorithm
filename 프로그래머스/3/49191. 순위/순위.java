class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int game[][] = new int[n+1][n+1];
        for(int r[] : results) {
            game[r[0]][r[1]] = 1;
            game[r[1]][r[0]] = -1;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(game[i][k] == 1 && game[k][j] == 1) {
                        game[i][j] = 1;
                        game[j][i] = -1;
                    }
                    if(game[i][k] == -1 && game[k][j] == -1) {
                        game[i][j] = -1;
                        game[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(game[i][j] != 0) cnt++;
            }
            if(cnt == n-1)  answer++;
        }
        
        return answer;
    }
}