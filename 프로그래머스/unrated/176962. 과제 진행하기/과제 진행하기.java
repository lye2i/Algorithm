import java.util.*;

class Solution {   
    public String[] solution(String[][] plans) {
        int length = plans.length;
        String[] answer = new String[length];
        int start[] = new int[length];
        int play[] = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] str1, String str2[]) {
                return str1[1].compareTo(str2[1]);
            }
        });
        
        for(int i=0; i<length; i++) {
            String str[] = plans[i][1].split(":");
            start[i] = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            play[i] = Integer.parseInt(plans[i][2]);
        }
        
        int idx = 0, turn = 1, time = start[0];
        stack.push(0);
        while(turn < length) {
            int cur = stack.peek();
            
            if(start[turn] < time+play[cur]) {
                play[cur] -= start[turn] - time;
                time = start[turn];
                stack.push(turn++);
            } else if(start[turn] > time+play[cur]){
                answer[idx++] = plans[cur][0];
                time += play[cur];
                stack.pop();
                
                if(stack.isEmpty()) {
                    time = start[turn];
                    stack.push(turn++);
                }
            } else {
                answer[idx++] = plans[cur][0];
                time += play[cur];
                stack.pop();
                stack.push(turn++);
            }
        }
        
        while(!stack.isEmpty()) {
            answer[idx++] = plans[stack.pop()][0];
        }
        
        return answer;
    }
}