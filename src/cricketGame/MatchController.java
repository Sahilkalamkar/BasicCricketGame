package cricketGame;

import java.util.ArrayList;

public class MatchController {
	//Get a match instance and play
	
	Match currentMatch = new Match();
	
	public MatchController(Match match) {
		currentMatch = match;
	}
	
	void playMatch() {
		int totalOvers = currentMatch.getOvers();		
		//teamOne bat's first
		Team teamOne = currentMatch.getTeamOne();
		Team teamTwo = currentMatch.getTeamTwo();
		
		playMatchHelper(teamOne, teamTwo, totalOvers, 0, true);
		int target = teamOne.getScore();
		playMatchHelper(teamTwo,teamOne,totalOvers, target, false);		
	}
	
	void playMatchHelper(Team teamOne,Team teamTwo,int totalOvers,
			int target,boolean isFirstInnings) {
		if(isFirstInnings==false) {
			System.out.println("SECOND INNINGS STARTED");
		}
		int score = 0;
		
		int wickets = 0;		
		
		ArrayList<Player> bowlingTeam = (ArrayList<Player>) teamTwo.getPlayers();
		
		ArrayList<Player> battingTeam = (ArrayList<Player>) teamOne.getPlayers();
		
		
		// On 0,we have on-strike batsman
		// On 1,we have off-strike batsman
		
		
		int[] batsMenIndices = findNextBatsMen(battingTeam);
		
		int position = 0;
		
		Player currentBatsman = battingTeam.get(batsMenIndices[position]);
		
		boolean allOut = false;
		
		for(int over=0;over<totalOvers;over++) {
			//Assuming there are 6 balls in a single over.
			
			Player currentBaller = getNextBowler(bowlingTeam);
			
			for(int ball=0;ball<6;ball++) {
				int currentballResult = generateCurrentBallStatus();
				if(currentballResult==7) {
					//Wicket
					System.out.println(currentBaller.getPlayerName()+" took a wicket of "+currentBatsman.getPlayerName());
					currentBatsman.setStatus(true);
					batsMenIndices = findNextBatsMen(battingTeam);
					position = 1;
					currentBatsman = battingTeam.get(batsMenIndices[position]);
					wickets++;
					if(wickets==2) {
						System.out.println("All Out!");
						allOut=true;
						break;
					}
				}
				else
				{
					score+=currentballResult;
					
					int currentscore = currentBatsman.getRunsScored();
					String temp = Integer.toString(currentballResult);
					
					System.out.println(currentBatsman.getPlayerName()+" scored "+temp);
					
					currentscore+=currentballResult;
					
					currentBatsman.setRunsScored(currentscore);
					
					if(isFirstInnings==false && score>target) {
						printVerdict(teamOne);
						return;
					}
					if(currentballResult%2==1) {
						position = 1-position;
						currentBatsman = battingTeam.get(batsMenIndices[position]);
					}
				}
			}
			
			//When the over is completed,batsmen change strikes.
			position = 1-position;
			currentBatsman = battingTeam.get(batsMenIndices[position]);
			
			if(allOut==true) {
				break;
			}
		}
		
		if(isFirstInnings==true) {
			System.out.println("FIRST INNINGS COMPLETED");
			System.out.print("The score in this innings is ");
			System.out.println(score);
			System.out.print("The  number of wickets in this innings is ");
			System.out.println(wickets);
			System.out.println();
			teamOne.setScore(score);
		}
		else {
			if(score>target) {
				printVerdict(teamOne);
			}
			else if(score<target) {
				printVerdict(teamTwo);
			}
			else
			{
				System.out.println("It is a Draw");
			}
		}
	}
	
	private void printVerdict(Team team) {
		String winnerId = Integer.toString(team.getTeamId());
		System.out.println("Team number "+winnerId+" won the match");
	}
	
	private Player getNextBowler(ArrayList<Player> players) {
		
		int totalPlayers = players.size();
		
		int index = (int)(Math.random()*totalPlayers);
		
		return players.get(index);
	}
	
	
	private int[] findNextBatsMen(ArrayList<Player> players){	
		
		int[] notOutBatsmen = new int[2];
		
		int pointer = 0;
		
		for(int i=0;i<players.size();i++) {
			
			Player currentPlayer = players.get(i);
			
			boolean isOut = currentPlayer.getStatus();
			
			if(isOut==false) {
				notOutBatsmen[pointer] = i;
				pointer++;
				if(pointer==2) {
					break;
				}
			}
		
		}
		return notOutBatsmen;
	}
	
 	private int generateCurrentBallStatus() {
 		int status = (int)(Math.random()*8);
 		return status;
	}
	
}
