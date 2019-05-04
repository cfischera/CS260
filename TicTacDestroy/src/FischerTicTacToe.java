import edu.truman.fischer.tic_tac_destroy.*;

/**
 * This class runs a game of Tic-Tac-Toe between the user
 * and the computer.
 * @author ColinFischer
 * Date Last Modified: 3 March 2018
 */
public class FischerTicTacToe
{
	public static void main(String[] args)
	{
		GameController g = new GameController();
		while(g.checkGameStatus()) //runs while Board is eligible for play
		{
			boolean playHasBeenMade; //check for valid play
			do
			{
				if(g.getHumanIsUp()) //option to prompt user
				{
					System.out.println("\n"+g.printBoard()+"\n");
					System.out.println(g.PROMPT_HUMAN);
				}
				playHasBeenMade = g.promptNextPlayer(); //true if valid play
				if(!playHasBeenMade) //prompt if invalid play
					System.out.println("\n"+g.ERROR_MESSAGE);
			}
			while(!playHasBeenMade);
		}
		System.out.println(g.printBoard()+"\n"); //final print of the Board
		System.out.println(g.printEndStatus()); //terminal statement
	}
}