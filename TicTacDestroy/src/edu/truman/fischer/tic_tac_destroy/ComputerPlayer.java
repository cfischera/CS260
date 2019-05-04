package edu.truman.fischer.tic_tac_destroy;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a partially artificially-intelligent
 * computer player for Tic-Tac-Toe.
 * @author ColinFischer
 * Date Last Modified: 3 March 2018
 */
public class ComputerPlayer
{
	final char PLAYER_VAL; //the value for Squares chosen by this player
	final String WIN_DECL; //the victory declaration given by this player
	
	/**
	 * Constructor for a new ComputerPlayer.
	 */
	public ComputerPlayer()
	{
		this.PLAYER_VAL = 'O';
		this.WIN_DECL = "I, the computer, have crushed you.";
	}
	
	/**
	 * Returns the choice of a Square from the computer according to the
	 * following precedence: preventing the other player from winning,
	 * the middle square, a random corner, a random Square.
	 */
	public int[] choosePlay(Board simBoard, ArrayList<int[]> choices)
	{
		ArrayList<int[]> corners = new ArrayList<int[]>(0);
		int blockChoice = this.checkHumanVictory(simBoard, choices);
		if(blockChoice!=-1)
			return choices.get(blockChoice);
		for(int i=0;i<choices.size();i++)
		{
			if(choices.get(i)[0]==1
					&& choices.get(i)[1]==1)
				return choices.get(i);
		}
		for(int i=0;i<choices.size();i++)
		{
			if(Math.abs(choices.get(i)[0]-choices.get(i)[1])==2
					|| Math.abs(choices.get(i)[0]-choices.get(i)[1])==0)
				corners.add(choices.get(i));
		}
		if(corners.size()>0)
			return corners.get(new Random().nextInt(corners.size()));
		else
			return choices.get(new Random().nextInt(choices.size()));
		
	}
	
	/**
	 * Simulates the next move on the Board to check for a
	 * human victory.
	 */
	private int checkHumanVictory(Board simBoard, ArrayList<int[]> choices)
	{
		int decision = -1;
		for(int i=0;i<choices.size();i++)
		{
			Board t = simBoard.copy();
			t.addDecision(choices.get(i), new HumanPlayer().PLAYER_VAL);
			if(t.getBoardStatus()==new HumanPlayer().PLAYER_VAL)
				return i;
		}
		return decision;
	}
}