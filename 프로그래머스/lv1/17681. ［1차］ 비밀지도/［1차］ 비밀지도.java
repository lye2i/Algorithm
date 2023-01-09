class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            StringBuilder map = new StringBuilder();
            int diff1 = n - str1.length();
            int diff2 = n - str2.length();
            
            for(int j=0; j<n; j++){
                if(j >= diff1 && str1.charAt(j-diff1) == '1')  map.append('#');
                else if(j >= diff2 && str2.charAt(j-diff2) == '1') map.append('#');
                else    map.append(' ');
            }
            
            answer[i] = map.toString();
        }
        return answer;
    }
}