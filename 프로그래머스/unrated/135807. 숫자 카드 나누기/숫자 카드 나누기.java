class Solution {
    public static boolean searchTrue(int[] array, int a) {
        for(int j=1; j<array.length; j++){
            if(array[j] % a != 0)  return false;
        }
        return true;
    }
    
    public static boolean searchFalse(int[] array, int a) {
        for(int j=0; j<array.length; j++){
            if(array[j] % a == 0)  return false;
        }
        return true;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int a = 0;
        
        for(int i=arrayA[0]; i>1; i--) {
            if(arrayA[0]%i == 0 && searchTrue(arrayA, i) && searchFalse(arrayB, i)) {
                a = i;
                break;
            }
        }
        
        for(int i=arrayB[0]; i>1; i--) {
            if(arrayB[0]%i == 0 && searchTrue(arrayB, i) && searchFalse(arrayA, i)) {
                a = Math.max(a, i);
                break;
            }
        }
        
        return a;
    }
}