import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Player implements Comparable<Player>{
		int level;
		String name;
		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}
		@Override
		public int compareTo(Player o) {
			return this.name.compareTo(o.name);
		}
	}
	
	static class Room {
		int level;
		ArrayList<Player> players = new ArrayList<Player>();
		
		public Room(Player p) {
			this.level = p.level;
			players.add(p);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
			boolean go = false;
			
			for(Room room : rooms) {
				if(room.players.size() == m)	continue;
				if(room.level+10 >= player.level && room.level-10 <= player.level) {
					go = true;
					room.players.add(player);
					break;
				}
			}
			
			if(!go) {
				rooms.add(new Room(player));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Room room : rooms) {
			sb.append(room.players.size() == m ? "Started!\n" : "Waiting!\n");
			Collections.sort(room.players);
			for(Player player : room.players) {
				sb.append(player.level + " " + player.name + "\n");
			}
		}
		System.out.print(sb);
	}
}