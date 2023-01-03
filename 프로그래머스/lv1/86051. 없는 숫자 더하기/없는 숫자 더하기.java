class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] nums = new int[10];
        
        for(int i=0; i<numbers.length; i++){
            nums[numbers[i]]++;
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0)    answer += i;
        }
        
        return answer;
    }
}