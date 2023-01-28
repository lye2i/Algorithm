import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, int[]> cars = new TreeMap<String, int[]>();
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            int time = Integer.parseInt(record[0].substring(0,2))*60+Integer.parseInt(record[0].substring(3,5));
            
            if(cars.containsKey(record[1])){
                int[] status = cars.get(record[1]);
                if(status[2]==0){
                    status[1] = time;
                    status[2] = 1;
                }else{
                   status[0] += (time - status[1]);
                   status[2] = 0; 
                }
                cars.replace(record[1],status);                
            }else{ // 처음 들어온 차량이면
                cars.put(record[1],new int[]{0,time,1});
            }            
        }
                
        int[] answer = new int[cars.size()];
        int max = 60*23+59, i=0;
        for(String k : cars.keySet()){
            int[] status = cars.get(k);
            if(status[2]==0)    answer[i++] = cal(fees,status[0]);
            else    answer[i++] = cal(fees, status[0]+(max-status[1]));
        }
        return answer;
    }
    
    public int cal(int[] fees, int total){
        int add = total-fees[0];
        if(add<=0)    return fees[1];
    
        if(add%fees[2]==0)   add /= fees[2];
        else    add = (add/fees[2]) + 1;
        
        return (fees[1]+add*fees[3]);
    }
}