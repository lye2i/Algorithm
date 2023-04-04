class Solution {
    static int answer = Integer.MAX_VALUE;
    static int pair[][] = {{1,1,1},{5,1,1},{25,5,1}};
    static int mineral[];
    
    public static void search(int n, int cnt, int[] picks, int turn[]) {
        if(cnt == n) {
            int sum = 0, idx = 0;
            
            for(int i=0; i<mineral.length; i++) {
                sum += pair[turn[idx]][mineral[i]];
                if(i % 5 == 4)  idx++;
                if(idx == n) break;
            }
            
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i] > 0) {
                picks[i]--;
                turn[cnt] = i;
                search(n, cnt+1, picks, turn);
                picks[i]++;
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int n = Math.min(picks[0]+picks[1]+picks[2], minerals.length/5+(minerals.length%5 > 0 ? 1 : 0));
        mineral = new int[minerals.length];
        
        for(int i=0; i<minerals.length; i++) {
            if(minerals[i].equals("diamond"))   mineral[i] = 0;
            else if(minerals[i].equals("iron")) mineral[i] = 1;
            else    mineral[i] = 2;
        }
        
        if(picks[0] >= n)   return minerals.length;
        else    search(n, 0, picks, new int[n]);
        
        return answer;
    }
}