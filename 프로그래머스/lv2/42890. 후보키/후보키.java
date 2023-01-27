import java.util.*;

class Solution {
    public void combination(int n, int cnt, int idx, List<int[]> list, boolean check[], int[] column) {
        if(cnt == n) {
            int tuple[] = new int[n];
            for(int i=0; i<n; i++)
                tuple[i] = column[i];
            
            list.add(tuple);
            return;
        }
        
        for(int i=idx; i<check.length; i++){
            if(!check[i]) {
                check[i] = true;
                column[cnt] = i;
                combination(n, cnt+1, i, list, check, column);
                check[i] = false;
            }
        }
    }
    
    public boolean check(List<String> list, int[] column) {
        String str = "";
        for(int i=0; i<column.length; i++)
            str += column[i];
        for( String s : list ){
            String tuple = str.replaceAll("["+s+"]", "a");
            int cnt = 0;
            for(int i=0; i<tuple.length(); i++){
                if(tuple.charAt(i) == 'a')  cnt++;
            }
            if(cnt == s.length())   return false;
        }
        return true;
    }
    
    public int solution(String[][] relation) {
        int answer = 0, cnt = 0, n = 1;
        List<String> columns = new ArrayList<String>();
        boolean check[] = new boolean[relation[0].length];
        
        for(int i=0; i<relation[0].length; i++){
            List<String> list = new ArrayList<String>();
            for(int j=0; j<relation.length; j++){
                if(list.contains(relation[j][i])) break;
                else    list.add(relation[j][i]);
            }
            
            if(list.size() == relation.length){
                answer++;
                cnt++;
                check[i] = true;
            }
        }
        
        while(++n + cnt <= check.length) {
            List<int[]> column = new ArrayList<int[]>();
            
            combination(n, 0, 0, column, check, new int[n]);
            
            for(int i=0; i<column.size(); i++){
                
                if(!check(columns, column.get(i)))  continue;
                
                int tuple[] = column.get(i);
                List<String> list = new ArrayList<String>();
                
                for(int j=0; j<relation.length; j++){
                    StringBuilder sb = new StringBuilder();
                    for(int k=0; k<n; k++)
                        sb.append(relation[j][tuple[k]]);
                    
                    if(list.contains(sb.toString()))  break;
                    list.add(sb.toString());
                }
                
                if(list.size() == relation.length) {
                    StringBuilder sb1 = new StringBuilder();
                    for(int k=0; k<n; k++)
                        sb1.append(tuple[k]);
                    columns.add(sb1.toString());
                    answer++;
                }
            }
        }
         
        return answer;
    }
}