class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        int n = arr.length;
        
        while(n > 0) {
            for(int i=0; i<arr.length; i+=n){
                for(int j=0; j<arr.length; j+=n){
                    if(arr[i][j] != -1 && check(i, j, n, arr)) {
                        answer[arr[i][j]]++;
                        change(i, j, n, arr);
                    }
                }
            }
            n /= 2;
        }
        
        return answer;
    }
    
    public void change(int x, int y, int n, int[][] arr) {        
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                arr[i][j] = -1;
            }
        }
    }
    
    public boolean check(int x, int y, int n, int[][] arr){
        int a = arr[x][y];
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(a != arr[i][j])  return false;
            }
        }
        return true;
    }
}