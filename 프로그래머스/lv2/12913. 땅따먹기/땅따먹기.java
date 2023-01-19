class Solution {
    int solution(int[][] land) {
        int size = land.length-1;
        
        for(int i=1; i<land.length; i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][1]));
        }

        return Math.max(Math.max(land[size][0], Math.max(land[size][2], land[size][3])), land[size][1]);
    }
}