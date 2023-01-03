class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] numX = new int[10];
        int[] numY = new int[10];
        
        for(int i=0; i<X.length(); i++){
            numX[X.charAt(i) - '0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
            numY[Y.charAt(i) - '0']++;
        }
        
        for(int i=9; i>=0; i--){
            if(numX[i] != 0 && numY[i] != 0) {
                for(int j=0; j<Math.min(numX[i], numY[i]); j++){
                    sb.append(i);
                }
            }
        }
        
        if(sb.length() == 0)    return "-1";
        else if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}