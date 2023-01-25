import java.util.*;

class Solution {
    public long func(String expression, String operator1, String operator2, String operator3) {
        String first[] = expression.split("\\"+operator1);
        Stack<Long> stack1 = new Stack<Long>();
        
        if(first.length < 2)    return 0;
        
        for(int i=0; i<first.length; i++){
            if(first[i].contains(operator2)) {
                String second[] = first[i].split("\\"+operator2);
                Stack<Long> stack2 = new Stack<Long>();
                
                for(int j=0; j<second.length; j++){
                    if(second[j].contains(operator3)) {
                        String third[] = second[j].split("\\"+operator3);
                        long num = cal(operator3, Long.parseLong(third[0]), Long.parseLong(third[1]));
                        
                        for(int k=2; k<third.length; k++){
                            num = cal(operator3, num, Long.parseLong(third[k]));
                        }
                        
                        if(stack2.isEmpty())    stack2.push(num);
                        else    stack2.push(cal(operator2, stack2.pop(), num));
                    } else {
                        if(stack2.isEmpty())    stack2.push(Long.parseLong(second[j]));
                        else    stack2.push(cal(operator2, stack2.pop(), Long.parseLong(second[j])));
                    }
                }
                if(stack1.isEmpty())    stack1.push(stack2.pop());
                else    stack1.push(cal(operator1, stack1.pop(), stack2.pop()));
            } else if(first[i].contains(operator3)){
                String third[] = first[i].split("\\"+operator3);
                long num = cal(operator3, Long.parseLong(third[0]), Long.parseLong(third[1]));

                for(int k=2; k<third.length; k++){
                    num = cal(operator3, num, Long.parseLong(third[k]));
                }

                if(stack1.isEmpty())    stack1.push(num);
                else    stack1.push(cal(operator1, stack1.pop(), num));
            }
            else {
                if(stack1.isEmpty())    stack1.push(Long.parseLong(first[i]));
                else    stack1.push(cal(operator1, stack1.pop(), Long.parseLong(first[i])));
            }
        }
        
        return Math.abs(stack1.pop());
    }
    
    public long cal(String operator, long num1, long num2) {
        if(operator.equals("-"))    return num1 - num2;
        else if(operator.equals("+"))   return num1 + num2;
        else    return num1 * num2;
    }
    
    public long solution(String expression) {
        long answer = 0;
        answer = Math.max(Math.max(func(expression, "*", "+", "-"), func(expression, "*", "-", "+")), answer);
        answer = Math.max(Math.max(func(expression, "+", "*", "-"), func(expression, "+", "-", "*")), answer);
        answer = Math.max(Math.max(func(expression, "-", "+", "*"), func(expression, "-", "*", "+")), answer);
        return answer;
    }
}