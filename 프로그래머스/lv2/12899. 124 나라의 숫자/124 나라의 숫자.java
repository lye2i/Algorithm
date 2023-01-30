class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        char num[] = {'4', '1', '2'};
        while(n>0) {
            int r = n % 3;
            n /= 3;
            if(r == 0)  n--;
            sb.append(num[r]);
        }
        return sb.reverse().toString();
    }
}