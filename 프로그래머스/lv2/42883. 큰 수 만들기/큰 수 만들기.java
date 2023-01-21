class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(number.length() > 0) {
            int index = 0;
            char max = '0';
            
            if(k==1 && number.length()==1)  break;
            
            for(int i=0; i<=k; i++){
                if(max < number.charAt(i)) {
                    index = i;
                    max = number.charAt(i);
                }
                
                if(max == '9')  break;
            }
            
            k -= index;
            sb.append(number.charAt(index));
            number = number.substring(index+1, number.length());
        }
        
        return sb.toString(); 
    }
}