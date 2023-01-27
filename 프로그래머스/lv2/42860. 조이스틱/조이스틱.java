import java.util.*;

class Solution {
    public int leftSearch(int leftMax, int current, int size, boolean[] visit) {
        for(int i=1; i<=leftMax; i++){
            int leftIdx = current + i >= size ? (current+i)%size : current+i;
            if(visit[leftIdx])  visit[leftIdx] = false;
            if(i == leftMax)    return leftIdx;
        }
        return 0;
    }
    
    public int rightSearch(int rightMax, int current, int size, boolean[] visit) {
        for(int i=1; i<=rightMax; i++){
            int rightIdx = current - i < 0 ? current-i+size : current - i;
            if(visit[rightIdx])  visit[rightIdx] = false;
            if(i == rightMax)    return rightIdx;
        }
        return 0;
    }
    
    public int solution(String name) {
        int answer = 0, current = 0, cnt = 0, size = name.length(), limit = name.length()/2+name.length()%2;
        boolean visit[] = new boolean[size];
        
        for(int i=0; i<size; i++) {
            if(name.charAt(i) != 'A'){
                visit[i] = true;
                cnt++;
            }
        }
        
        if(visit[0])    cnt--;
        visit[0] = false;
        
        while(cnt > 0) {
            int leftMax = 20, rightMax = 20, leftCnt = 0, rightCnt = 0;
            
            for(int i=1; i<limit; i++){
                int leftIdx = current + i >= size ? (current+i)%size : current+i;
                int rightIdx = current - i < 0 ? current-i+size : current - i;
                
                if(visit[leftIdx]) {
                    leftMax = i;
                    leftCnt++;
                }
                if(visit[rightIdx]) {
                    rightMax = i;
                    rightCnt++;
                }
            }
            
            if(leftMax == 20 && rightMax == 20){
                if(visit[limit])    answer += limit;
                break;
            }
            
            if(leftMax == rightMax) {
                if(leftCnt >= rightCnt) current = leftSearch(leftMax, current, size, visit);
                else    current = rightSearch(rightMax, current, size, visit);
            }            
            else if(leftMax < rightMax) current = leftSearch(leftMax, current, size, visit);
            else    current = rightSearch(rightMax, current, size, visit);
            
            answer += Math.min(leftMax, rightMax);
        }
       
        for(int i=0; i<size; i++){
            if(name.charAt(i) <= 'M')   answer += (name.charAt(i)-'A');
            else    answer += ('Z'-name.charAt(i)+1);
        }
        
        return answer;
    }
}