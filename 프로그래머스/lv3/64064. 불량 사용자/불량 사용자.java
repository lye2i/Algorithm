import java.util.HashSet;

class Solution {
    static int n;
    static HashSet<String> set;
    
    public void getUser(String[] user_id, String[] banned_id, int cnt, boolean visit[]) {
        if(cnt == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) {
                if(visit[i])    sb.append(1);
                else    sb.append(0);
            }
            set.add(sb.toString());
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visit[i] && banned_id[cnt].length() == user_id[i].length() && checkUser(user_id[i], banned_id[cnt])) {
                visit[i] = true;
                getUser(user_id, banned_id, cnt+1, visit);
                visit[i] = false;
            }
        }
    }
    
    public boolean checkUser(String user, String banned) {
        for(int i=0; i<banned.length(); i++) {
            if(banned.charAt(i) == '*') continue;
            if(banned.charAt(i) != user.charAt(i))  return false;
        }
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        set = new HashSet<String>();
        
        getUser(user_id, banned_id, 0, new boolean[n]);
        return set.size();
    }
}