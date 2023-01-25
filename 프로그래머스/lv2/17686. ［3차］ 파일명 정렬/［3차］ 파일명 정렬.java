import java.util.*;

class Solution {
    public String[] solution(String[] files) {
       
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String head1 = "", head2 = "";
                int number1 = 0, number2 = 0;
                
                for(int j=0; j<a.length(); j++){
                    if(a.charAt(j) >= '0' && a.charAt(j) <= '9') {
                        head1 = a.substring(0,j).toUpperCase();
                        for(int k=j+1; k<=a.length(); k++){
                            if(k == a.length() || k == j+5 || a.charAt(k) < '0' || a.charAt(k) > '9' || k == j+5) {
                                number1 = Integer.parseInt(a.substring(j, k));
                                break;
                            }
                        }
                        break;
                    }
                }
                
                for(int j=0; j<b.length(); j++){
                    if(b.charAt(j) >= '0' && b.charAt(j) <= '9') {
                        head2 = b.substring(0,j).toUpperCase();
                        for(int k=j+1; k<=b.length(); k++){
                            if(k == b.length() || k == j+5 || b.charAt(k) < '0' || b.charAt(k) > '9') {
                                number2 = Integer.parseInt(b.substring(j, k));
                                break;
                            }
                        }
                        break;
                    }
                }
                
                if(!head1.equals(head2))    return head1.compareToIgnoreCase(head2);
                else return number1-number2;
            }
        });
        
        return files;
    }
}