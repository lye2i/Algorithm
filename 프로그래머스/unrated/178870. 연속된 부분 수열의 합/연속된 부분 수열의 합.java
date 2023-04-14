class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = sequence[0], idx = sequence.length-1, length = sequence.length, left = 0, right = 0;
        
        while(true) {           
            if(sum == k && right - left < length){
                length = right - left;
                answer[0] = left;
                answer[1] = right;
            }
            
            if(left == idx && right == idx)    break;
            
            if(right < idx && sum <= k) sum += sequence[++right];
            else    sum -= sequence[left++];
        }
        
        return answer;
    }
}