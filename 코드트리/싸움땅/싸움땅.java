import java.util.*;
import java.io.*;

public class Main {
    static final int r[] = {-1,0,1,0};
    static final int c[] = {0,1,0,-1};
    static int N, M, K, map[][];
    static HashMap<Integer, PriorityQueue<Integer>> guns;

    static class Player {
        int x, y, d, s, g;
        Player(int x, int y, int d, int s, int g) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.g = g;
        }
    }

    public static void getGun(Player player) {
        PriorityQueue<Integer> gun = guns.get(player.x*100+player.y);

        if(gun.size() > 0 && gun.peek() > player.g) {
        	if(player.g > 0) gun.add(player.g);
        	player.g = gun.poll();
        }
    }

    public static void movePlayer(Player fight, int i) {        
    	for(int j=fight.d; j<fight.d+4; j++) {
            int dr = fight.x + r[j%4];
            int dc = fight.y + c[j%4];

            if(dr < 1 || dr > N || dc < 1 || dc > N || map[dr][dc] != 0)	continue;
            else {
                fight.x = dr;
                fight.y = dc;
                fight.d = j%4;
                map[dr][dc] = i;
                break;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        guns = new HashMap<Integer, PriorityQueue<Integer>>();
        Player players[] = new Player[M+1];
        int score[] = new int[M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int p = Integer.parseInt(st.nextToken());
                guns.put(i*100+j, new PriorityQueue<Integer>(Collections.reverseOrder()));
                if(p > 0)   guns.get(i*100+j).add(p);
            }
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            players[i] = new Player(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            map[players[i].x][players[i].y] = i;
        }

        while(K-- > 0) {
            for(int i=1; i<=M; i++) {
                Player player = players[i];
                map[player.x][player.y] = 0;
                int dr = player.x + r[player.d];
                int dc = player.y + c[player.d];
                
                if(dr < 1 || dr > N || dc < 1 || dc > N) {
                    player.d = (player.d+2)%4;
                    dr = player.x + r[player.d];
                    dc = player.y + c[player.d];
                }
                
                player.x = dr;
                player.y = dc;

               if(map[dr][dc] == 0) {
                    map[dr][dc] = i;
                    getGun(player);
                } else { // 싸우기
                    Player other = players[map[dr][dc]];
                    int p1 = player.s + player.g;
                    int p2 = other.s + other.g;
                    
                    if(p1 > p2 || p1 == p2 && player.s > other.s) { // 현재 플레이어가 이기는 경우
                    	score[i] += Math.abs(p1-p2);
                        if(other.g > 0) {
                        	guns.get(dr*100+dc).add(other.g); // 총 놓기
                            other.g = 0;
                        }
                        movePlayer(other, map[dr][dc]); // 진 플레이어 이동
                        map[dr][dc] = i;
                        getGun(other); // 진 사람 총 획득하기
                        getGun(player); // 이긴 사람 총 획득하기
                    } else {
                    	score[map[dr][dc]] += Math.abs(p1-p2);
                        if(player.g > 0) {
                        	guns.get(dr*100+dc).add(player.g); // 총 놓기
                            player.g = 0;
                        }
                        movePlayer(player, i); // 진 플레이어 이동
                        getGun(player); // 진 사람 총 획득하기
                        getGun(other); // 이긴 사람 총 획득하기
                    }
                }
            }
        }

        // 포인트 구하기
        for(int i=1; i<=M; i++) {
            sb.append(score[i]).append(" ");
        }

        System.out.print(sb);
    }
}
