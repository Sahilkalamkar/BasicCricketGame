package cricketGame;

public class Player {

	private String playerName;
	private int runsScored=0;
	private int teamId;	
	private boolean isOut = false;
	
	public Player(String playerName,int teamId) {
		super();
		this.playerName = playerName;
		this.teamId = teamId;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public boolean getStatus() {
		return isOut;
	}
	public void setStatus(boolean status) {
		isOut = status;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
}
