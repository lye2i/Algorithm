import java.util.*;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int[] num = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            num[i] = Integer.parseInt(nums[i]);
        }
        
        Arrays.sort(num);
        
        return num[0]+" "+num[num.length-1];
    }
}