#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<pair<int,int>> q;
    int num=0;
    
    for(int i=0; i<progresses.size(); i++){
        q.push({progresses[i],speeds[i]});
    }
    
    for(int time=1; q.size()!=0; time++){
        num=0;
        while(q.front().first + q.front().second*time >= 100){
            q.pop();
            num++;
        }
        if(num!=0)
            answer.push_back(num);
    }
    
    return answer;
}