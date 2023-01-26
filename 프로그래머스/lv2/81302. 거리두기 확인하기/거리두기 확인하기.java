class Solution {
    static int dr[] = {-1,-1,0,1,1,1,0,-1}; // 위 부터 시계 반대방향으로 회전 8방 
    static int dc[] = {0,-1,-1,-1,0,1,1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = {0,0,0,0,0};
        for(int t=0; t<5; t++){
            char room[][] = new char[5][5];
            for(int i=0; i<5; i++){
                room[i] = places[t][i].toCharArray();
            }
            if(check(room)) answer[t] = 1;
        }
        
        return answer;
    }
    
    public boolean check(char room[][]){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(room[i][j]=='P'){
                    for(int d=0; d<8; d++){
                        int r = i+dr[d];
                        int c = j+dc[d];
                        if(r>=0 && r<5 && c>=0 && c<5){
                            if(d%2==0){
                                if(room[r][c]=='P') return false;
                                
                                if(room[r][c]=='O'){
                                    r = i+2*dr[d];
                                    c = j+2*dc[d];
                                    if(r>=0 && r<5 && c>=0 && c<5 && room[r][c]=='P')   return false;
                                }
                            }else{
                                if(room[r][c]=='P'){
                                    int left = (d+1)%8;
                                    int right = (d+7)%8;
                                    if(room[i+dr[left]][j+dc[left]]=='O' || room[i+dr[right]][j+dc[right]]=='O')    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}