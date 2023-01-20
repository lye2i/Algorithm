import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
         
        if(nums[0].equals("0"))  return "0";
        
        for(int i=0; i<nums.length; i++){
            answer += nums[i];
        }
        
        return answer;
    }
}