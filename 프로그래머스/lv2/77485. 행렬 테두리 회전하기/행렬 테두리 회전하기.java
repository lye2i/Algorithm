import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] array = new int[rows][columns];
        int n = 1, idx = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                array[i][j] = n++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int sr = queries[i][0]-1, er = queries[i][2]-1, r = sr;
            int sc = queries[i][1]-1, ec = queries[i][3]-1, c = sc;
            int min = array[r][c], num = min;
            
            while(true) {
                if(r == sr && c == sc+1)    break;
                
                if(r < er && c == sc)   array[r][c] = array[++r][c];
                else if(r == er && c < ec)   array[r][c] = array[r][++c];
                else if(r > sr && c == ec)  array[r][c] = array[--r][c];
                else   array[r][c] = array[r][--c];
                
                if(min > array[r][c])   min = array[r][c];
            }
        
            answer[idx++] = min;
            array[r][c] = num;
        }
        
        return answer;
    }
}