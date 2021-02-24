package cricketGame;

import java.util.ArrayList;

public class CricketGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//Create ArrayList of players
		//Create teams
		//Create Match
		//Create MatchController to play the game
		ArrayList<Player> one = new ArrayList<>();
		ArrayList<Player> two = new ArrayList<>();
		
		one.add(getRandomPlayer("Sachin", 1));
		one.add(getRandomPlayer("Pollard", 1));
		one.add(getRandomPlayer("Bumrah", 1));
		two.add(getRandomPlayer("Dhoni", 2));
		two.add(getRandomPlayer("Raina", 2));
		two.add(getRandomPlayer("Adam", 2));

		Team teamOne = new Team(1);
		teamOne.setPlayers(one);
		
		Team teamTwo = new Team(2);
		teamTwo.setPlayers(two);
		
		int overs = 2;
		Match match = new Match(teamOne,teamTwo,overs);
		MatchController matchController = new MatchController(match);
		matchController.playMatch();
		
	}
	public static Player getRandomPlayer(String name,int teamId) {
		Player randomPlayer = new Player(name,teamId);
		return randomPlayer;
	}
}
