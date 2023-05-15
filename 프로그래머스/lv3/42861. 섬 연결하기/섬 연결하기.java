import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int island[] = new int[n];
        Arrays.sort(costs, new Comparator<int[]>() {
           @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        
        for(int i=0; i<n; i++) {
            island[i] = i;
        }
        
        for(int i=0; i<costs.length; i++) {
            if(find(island, costs[i][0]) != find(island, costs[i][1]))  {
                union(island, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    public int find(int island[], int n) {
        if(island[n] == n)  return n;
        return find(island, island[n]);
    }
    
    public void union(int island[], int a, int b) {
        int n1 = find(island, a);
        int n2 = find(island, b);
        island[n1] = n2;
    }
}