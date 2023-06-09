class Solution {
    public int solution(int[] a) {
        int length = a.length;
        int minLeft[] = new int[a.length];
        int minRight[] = new int[a.length];
        minLeft[0] = a[0];
        minRight[length-1] = a[length-1];
        
        for(int i=1; i<length; i++) {
            minLeft[i] = minLeft[i-1] > a[i] ? a[i] : minLeft[i-1];
            minRight[length-i-1] = minRight[length-i] > a[length-i-1] ? a[length-i-1] : minRight[length-i];
        }
        
        for(int i=0; i<a.length; i++) {
            if(minLeft[i] < a[i] && minRight[i] < a[i]) length--;
        }
        return length;
    }
}