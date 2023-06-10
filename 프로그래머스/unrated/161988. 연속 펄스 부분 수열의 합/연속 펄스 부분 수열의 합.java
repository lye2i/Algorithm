class Solution {
    public long solution(int[] sequence) {
        int length = sequence.length;
        long[] sequence1 = new long[length];
        long[] sequence2 = new long[length];
        sequence1[0] = sequence[0];
        sequence2[0] = -sequence[0];
        
        for(int i=1; i<length; i++) {
            sequence1[i] = i%2==1 ? sequence1[i-1]-(long)sequence[i] : sequence1[i-1]+(long)sequence[i];
            sequence2[i] = i%2==0 ? sequence2[i-1]-(long)sequence[i] : sequence2[i-1]+(long)sequence[i];
        }
        
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        for(int i=length-1; i>=0; i--) {
            if(max1 < sequence1[i]) {
                max1 = sequence1[i];
                min1 = 0;
            }
            if(min1 > sequence1[i])   min1 = sequence1[i];
            
            if(max2 < sequence2[i]) {
                max2 = sequence2[i];
                min2 = 0;
            }
            if(min2 > sequence2[i])  min2 = sequence2[i];
        }
        
        return Math.max(max2-min2, max1-min1);
    }
}