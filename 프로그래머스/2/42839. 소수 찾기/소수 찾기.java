import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        make(numbers, "", new boolean[numbers.length()], 0, numbers.length());
        
        for(int n : set) {
            answer += isPrime(n);
        }
        
        return answer;
    }
    
    public void make(String numbers, String num, boolean check[], int cnt, int n){
        if(cnt > n)   return;
        
        if(num.length() > 0 && Integer.parseInt(num) >= 2) set.add(Integer.parseInt(num));
        
        for(int i=0; i<numbers.length(); i++){
            if(!check[i]){
                check[i]=true;
                make(numbers, num+numbers.charAt(i), check, cnt+1, n);
                check[i]=false;
            }
        }
    }
    
    public int isPrime(int n){
        for(int i=2; i*i<=n; i++) {
            if(n%i==0)  return 0;
        }
        return 1;
    }
}