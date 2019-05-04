package edu.truman.fischer.tic_tac_destroy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a human player for Tic-Tac-Toe.
 * @author ColinFischer
 * Date Last Modified: 3 March 2018
 */
public class HumanPlayer
{
	final char PLAYER_VAL; //the value for Squares chosen by this player
	final String WIN_DECL; //the victory declaration given by this player
	private Scanner scanner; //for input from the human
	
	/**
	 * Constructor of a new HumanPlayer.
	 */
	public HumanPlayer()
	{
		this.PLAYER_VAL = 'X';
		this.WIN_DECL = "The inferior human has won, this time.";
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Returns the choice of a Square from user input.
	 */
	public int[] choosePlay(ArrayList<int[]> choices)
	{
		int[] decision = new int[2];
		String input;
		input = scanner.nextLine();
		char[] chars = input.toCharArray();
		decision[0] = Character.getNumericValue(chars[0]);
		decision[1] = Character.getNumericValue(chars[2]);
		if(!this.isAChoice(choices, decision))
			return new int[] {-1,-1};
		return decision;
	}
	
	/**
	 * Returns if the user choice is valid.
	 */
	private boolean isAChoice(ArrayList<int[]> choices, int[] decision)
	{
		boolean exists = false;
		for(int i=0;i<choices.size();i++)
		{
			if(decision[0]==choices.get(i)[0]
					&&decision[1]==choices.get(i)[1])
				exists = true;
		}
		return exists;
	}
	
	/**
	 * Returns the victory declaration of the human.
	 */
	public String getWinDeclaration()
	{
		return this.WIN_DECL;
	}
}