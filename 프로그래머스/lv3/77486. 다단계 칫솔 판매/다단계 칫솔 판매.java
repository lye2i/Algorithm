import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int length = enroll.length;
        int[] answer = new int[length];
        HashMap<String, String> person = new HashMap<String, String>();
        HashMap<String, Integer> index = new HashMap<String, Integer>();
        
        for(int i=0; i<length; i++){
            index.put(enroll[i], i);
            person.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++) {
            String name = seller[i];
            int money = amount[i]*100;
            answer[index.get(name)] += (money - money/10);
            money /= 10;
            
            while(!person.get(name).equals("-") && money > 0) {
                name = person.get(name);
                answer[index.get(name)] += (money < 10 ? money : (money - money/10));
                money /= 10;
            }
        }
        
        return answer;
    }
}