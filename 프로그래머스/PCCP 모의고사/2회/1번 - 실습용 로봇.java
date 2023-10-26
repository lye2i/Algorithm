class Solution {
    static int r[] = {0,1,0,-1}, c[] = {1,0,-1,0};
    
    public int[] solution(String command) {
        int d = 0, answer[] = new int[2];
        
        for(int i=0; i<command.length(); i++) {
            switch(command.charAt(i)) {
                case 'G':
                    answer[0] += r[d];
                    answer[1] += c[d];
                    break;
                case 'R':
                    if(++d == 4)    d = 0;
                    break;
                case 'L':
                    if(--d == -1)   d = 3;
                    break;
                case 'B':
                    answer[0] -= r[d];
                    answer[1] -= c[d];
            }
        }
        
        return answer;
    }
}
