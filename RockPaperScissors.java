import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	public void instructions(){
		System.out.println("\nThis is the popular game of paper, rock, scissors. \n"
				+ "Enter your choice by typing the word \"paper\", the word \"rock\"\n"
						+ " or the word \"scissors\". The computer will also make a choice\n"
								+ " from the three options. After you have entered your choice,\n"
								+ " the winner of the game will be determined according to the following rules:");
		
		System.out.println("\nPaper wraps rock (paper wins)"
				+ "\nRock breaks scissors (rock wins)"
				+ "\nScissors cuts paper (scissors wins)");

		System.out.println("\n\nIf both you and the computer enter the same choice, then the game is tied.\n");
	}
	
	public int analyze(String playerWord, String compWord){
		playerWord = playerWord.toLowerCase();
		
		if(playerWord.equals(compWord)) return 0;	//Tie
		
		if(playerWord.equals("paper")){
			if(compWord.equals("scissors")) return 1;	//Comp wins
		}else if(playerWord.equals("rock")){
			if(compWord.equals("paper")) return 1;	//Comp wins
		}else if(playerWord.equals("scissors")){
			if(compWord.equals("rock")) return 1;	//Comp wins
		}
		
		return 2;	//Player Wins
	}
	
	
	
	public static void main(String[] args) {
		
		String choice[] = {"rock","paper","scissors"};
		String events[]={"It's A Draw","I WIN!","YOU WIN!"};
		int scores[]= {0,0,0};	//Tie,Comp,User
		
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		RockPaperScissors game = new RockPaperScissors();
		
		boolean play=true;
		int totalGames=0;
		
		System.out.println("The Game of Paper, Rock, Scissors\n\n");
		System.out.println("Do you need instructions (Y or N)? ");
		
		if(in.nextLine().equalsIgnoreCase("Y")) game.instructions(); 
		
		
		while(play){
			
			System.out.println("Enter your choice:");
			String userChoice = in.nextLine();
			
			int compChIndex = rand.nextInt(3);
			String compChoice = choice[compChIndex];
			
			System.out.println("Computer chose: "+compChoice);
			
			int result = game.analyze(userChoice, compChoice);
			scores[result]++;
			System.out.println(events[result]+"\n\n");
			totalGames++;
			
			System.out.println("Play again (Y or N)?");
			
			if(in.nextLine().equalsIgnoreCase("N")) play=false; 
		}
		
		in.close();
		
		//Game Stats
		System.out.println("\n\nGames played:"+totalGames);
		System.out.println("Wins for you:"+scores[2]);
		System.out.println("Wins for me:"+scores[1]);
		System.out.println("Tied Games:"+scores[0]);
		
		
	
	}
}
