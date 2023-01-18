class Solution {
    static int answer = 0, n;
    public void func(int[] numbers, int sum, int cnt) {
        if(cnt == numbers.length){
            if(sum == n)    answer++;
            return;
        }
        
        func(numbers, sum+numbers[cnt], cnt+1);
        func(numbers, sum-numbers[cnt], cnt+1);
    }
    
    public int solution(int[] numbers, int target) {
        n = target;
        func(numbers, 0, 0);
        return answer;
    }
}