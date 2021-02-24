package cricketGame;

public class Match {

	Team teamOne = new Team();
	Team teamTwo = new Team();
	private int overs;
	
	public Match() {
		
	}
	
	public Match(Team teamOne,Team teamTwo,int overs){
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.overs = overs;
	}

	public Team getTeamOne() {
		return teamOne;
	}

	public Team getTeamTwo() {
		return teamTwo;
	}
	public int getOvers() {
		return overs;
	}
}
