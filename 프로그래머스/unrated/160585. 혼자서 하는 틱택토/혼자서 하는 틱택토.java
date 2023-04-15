class Solution {
    public boolean game(String[] board, char c) {
        if(board[1].charAt(1) == c) {
            if(board[1].charAt(0) == c && board[1].charAt(2) == c)  return true;
            if(board[0].charAt(1) == c && board[2].charAt(1) == c) return true;
            if(board[0].charAt(0) == c && board[2].charAt(2) == c)  return true;
            if(board[0].charAt(2) == c && board[2].charAt(0) == c)  return true;
        }
        
        if(board[0].charAt(0) == c) {
            if(board[0].charAt(1) == c && board[0].charAt(2) == c)  return true;
            if(board[1].charAt(0) == c && board[2].charAt(0) == c)  return true;
        }
        
        if(board[2].charAt(2) == c) {
            if(board[0].charAt(2) == c && board[1].charAt(2) == c)  return true;
            if(board[2].charAt(0) == c && board[2].charAt(1) == c)  return true;
        }
        
        return false;
    }
    
    public int solution(String[] board) {
        int fcnt = 0, scnt = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i].charAt(j) == 'O') fcnt++;
                else if(board[i].charAt(j) == 'X')  scnt++;
            }
        }
        
        if(scnt > fcnt || fcnt - scnt > 1)    return 0;
        boolean fv = game(board, 'O'), sv = game(board, 'X');
        
        if(!fv && !sv)  return 1;
        else if(fcnt == scnt && !fv && sv)  return 1;
        else if(fcnt > scnt && fv && !sv)   return 1;
        else    return 0;       
    }
}