import java.util.Arrays;
class Solution {
    public int[] solution(int[] answers) {
        int s1[] = {1,2,3,4,5};
        int s2[] = {2,1,2,3,2,4,2,5};
        int s3[] = {3,3,1,1,2,2,4,4,5,5};
        int answer[] = new int[3];
        int n1 = 0, n2 = 0, n3 = 0, idx=0;
       
        for(int i=0; i<answers.length; i++){
            if(s1[i%s1.length]==answers[i])
                n1++;
            if(s2[i%s2.length]==answers[i])
                n2++;
            if(s3[i%s3.length]==answers[i])
                n3++;
        }
        
        if(n1>=n2 && n1>=n3)
            answer[idx++] = 1;
        if(n2>=n1 && n2>=n3)
            answer[idx++] = 2;
        if(n3>=n2 && n3>=n1)
            answer[idx++] = 3;
        
        return Arrays.copyOfRange(answer,0,idx);
    }
}