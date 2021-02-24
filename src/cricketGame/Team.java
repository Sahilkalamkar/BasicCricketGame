package cricketGame;

import java.util.ArrayList;
import java.util.List;

public class Team {
	//Substitute for teamName
	int teamId;
	int score=0;
	private List<Player> players = new ArrayList<Player>();	
	
	public Team() {	
	}
	public Team(int teamId) {
		this.teamId = teamId;
	}
	public void setPlayers(ArrayList<Player> players){
		this.players=players;
	}
	public void setScore(int score) {
		this.score = score;
	}				
	public int getScore() {
		return score;
	}
	public int getTeamId() {
		return teamId;
	}
	public List<Player> getPlayers(){
		return players;
	}
}
