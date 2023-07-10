class Solution {
    static final int R[] = {0, 0, 1, -1}, C[] = {1, -1, 0, 0};
    static int answer[], N, M;
    
    public static void findStart(String[] park) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    return;
                }
            }   
        }
    }
    
    public static void move(String[] park, int d, int n) {
        int dr = answer[0] + R[d]*n;
        int dc = answer[1] + C[d]*n;
        if(dr < 0 || dr >= N || dc < 0 || dc >= M)  return;
        
        for(int i=1; i<=n; i++) {
            dr = answer[0] + R[d]*i;
            dc = answer[1] + C[d]*i;
            if(park[dr].charAt(dc) == 'X')  return;
        }
        
        answer[0] += R[d]*n;
        answer[1] += C[d]*n;
    }
    
    public int[] solution(String[] park, String[] routes) {
        answer = new int[2];
        N = park.length;
        M = park[0].length();
        
        findStart(park);
        
        for(String route : routes) {
            String r[] = route.split(" ");
            switch(r[0]) {
                case "E" : 
                    move(park, 0, Integer.parseInt(r[1]));
                    break;
                case "W" :
                    move(park, 1, Integer.parseInt(r[1]));
                    break;
                case "S" :
                    move(park, 2, Integer.parseInt(r[1]));
                    break;
                case "N" :
                    move(park, 3, Integer.parseInt(r[1]));
                    break;
            }
        }
        
        return answer;
    }
}