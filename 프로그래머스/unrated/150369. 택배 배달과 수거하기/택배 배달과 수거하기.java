import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int i = n-1;
        
        while(i >= 0){
            
            if(deliveries[i] != 0 || pickups[i] != 0) {
                answer += i+1;
                int dCap = cap, pCap = cap, dIdx = i, pIdx = i;
                
                while(dCap > 0 && dIdx >= 0) {                    
                    if(dCap-deliveries[dIdx] >= 0) {
                        dCap -= deliveries[dIdx];
                        deliveries[dIdx--] = 0;
                    } else {
                        deliveries[dIdx] -= dCap;
                        dCap = 0;
                    }
                }
                
                while(pCap > 0 && pIdx >= 0) {
                    if(pCap-pickups[pIdx] >= 0) {
                        pCap -= pickups[pIdx];
                        pickups[pIdx--] = 0;
                    } else {
                        pickups[pIdx] -= pCap;
                        pCap = 0;
                    }
                }
            }
            
            else i--;
        }
        return answer*2;
    }
}