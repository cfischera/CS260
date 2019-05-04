package edu.truman.fischer.tic_tac_destroy;

import java.util.Random;

/**
 * This class facilitates the gameplay for Tic-Tac-Toe.
 * @author ColinFischer
 * Date Last Modified: 3 March 2018
 */
public class GameController
{
	private Board gameBoard; //the Board being played on
	private HumanPlayer humPlayer; //the user
	private ComputerPlayer comPlayer; //the AI
	private boolean humanIsUp; //if the user is up
	public final String PROMPT_HUMAN; //read to user
	public final String ERROR_MESSAGE; //read to user when necessary
	private final String DRAW_STATEMENT; //terminal message for a draw
		
	/**
	 * Constructor for the GameController.
	 */
	public GameController()
	{
		this.gameBoard = new Board();
		this.humPlayer = new HumanPlayer();
		this.comPlayer = new ComputerPlayer();
		this.humanIsUp = this.decideOrder();
		this.PROMPT_HUMAN = "Please make a move. \n"+
								"Enter your choice as a row number "+
								"and a column number,\nseparated by a single space:";
		this.ERROR_MESSAGE = "Error: illegal move";
		this.DRAW_STATEMENT = "It is a draw, human.";
	}
	
	/**
	 * Returns random decision for which player begins.
	 */
	private boolean decideOrder()
	{
		Random random = new Random();
		int randomNum = random.nextInt(2);
		return randomNum == 1;
	}
	
	/**
	 * Collects the next move.
	 */
	public boolean promptNextPlayer()
	{
		if(humanIsUp)
		{
			if(promptHuman())
			{
				humanIsUp = false;
				return true;
			}
		}
		else
		{
			humanIsUp = true;
			return promptComputer();
		}
		return false;
	}
	
	/**
	 * Collects a move from the user.
	 */
	private boolean promptHuman()
	{
		boolean added = false;
		int[] decision = this.humPlayer.choosePlay(this.gameBoard.getChoices());
		if(!(decision[0]==-1))
		{
			this.addToBoard(decision, this.humPlayer.PLAYER_VAL);
			added = true;
		}
		return added;
	}
	
	/**
	 * Collects a move from the computer.
	 */
	private boolean promptComputer()
	{
		this.addToBoard(this.comPlayer.choosePlay(this.gameBoard.copy(),
				this.gameBoard.getChoices()),
				this.comPlayer.PLAYER_VAL);
		return true;
	}
	
	/**
	 * Adds the player decision to the Board.
	 */
	private void addToBoard(int[] decision, char mark)
	{
		this.gameBoard.addDecision(decision, mark);
	}
	
	/**
	 * Returns if the user is up.
	 */
	public boolean getHumanIsUp()
	{
		return this.humanIsUp;
	}
	
	/**
	 * Returns if the Board is eligible for play.
	 */
	public boolean checkGameStatus()
	{
		return this.gameBoard.getBoardStatus()== new Square().EMPTY_VALUE;
	}
	
	/**
	 * Returns the visual representation of the Board.
	 */
	public String printBoard()
	{
		return this.gameBoard.toString();
	}
	
	/**
	 * Returns the terminal statement for the game.
	 */
	public String printEndStatus()
	{
		if(gameBoard.getBoardStatus()==comPlayer.PLAYER_VAL)
			return comPlayer.WIN_DECL;
		else if(gameBoard.getBoardStatus()==humPlayer.PLAYER_VAL)
			return humPlayer.WIN_DECL;
		else
			return DRAW_STATEMENT;
	}
}