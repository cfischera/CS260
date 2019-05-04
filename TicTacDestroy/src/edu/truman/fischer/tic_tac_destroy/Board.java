package edu.truman.fischer.tic_tac_destroy;

import java.util.ArrayList;

/**
 * This class represents a board for playing Tic-Tac-Toe.
 * @author ColinFischer
 * Date Last Modified: 3 March 2018
 */
public class Board
{
	private Square[][] board; //the Squares for the game
	final char FULL_VALUE = 'F'; //character value for a full Board
	
	/**
	 * Constructor for an empty Board.
	 */
	public Board()
	{
		this.board = new Square[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				this.board[i][j] = new Square();
		}
	}
	
	/**
	 * Adds a decision from a player to the Board.
	 */
	public void addDecision(int[] decision, char mark)
	{
		this.setSquare(mark, decision[0], decision[1]);
	}
	
	/**
	 * Sets the Square to the decision value.
	 */
	private void setSquare(char mark, int row, int col)
	{
		this.board[row][col].setVal(mark);
	}

	
	/**
	 * Checks for terminal scenarios. In the case of a victory,
	 * it returns the character value of the winner.
	 * In the case of a draw, it returns the value of a full Board.
	 * In the absence of a terminal scenario, it returns the empty value.
	 */
	public char getBoardStatus()
	{
		for(int i=0;i<3;i++)
		{
			if(board[0][i].getVal()==(board[1][i].getVal())
					&& board[0][i].getVal()==board[2][i].getVal())
				return board[0][i].getVal();
			else if(board[i][0].getVal()==board[i][1].getVal()
					&& board[i][0].getVal()==board[i][2].getVal())
			{
				if(!board[i][0].getIsOpen())
					return board[i][0].getVal();
			}
		}
		
		if(board[0][0].getVal()==board[1][1].getVal()
				&& board[0][0].getVal()==board[2][2].getVal())
		{
			if(!board[0][0].getIsOpen())
				return board[0][0].getVal();
		}
		else if(board[2][0].getVal()==board[1][1].getVal()
				&& board[2][0].getVal()==board[0][2].getVal())
		{
			if(!board[2][0].getIsOpen())
				return board[2][0].getVal();
		}
		
		boolean full = true;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j].getIsOpen())
					full = false;
			}
		}
		if(full)
			return this.FULL_VALUE;
		else
			return new Square().EMPTY_VALUE;
	}
	
	/**
	 * Returns an ArrayList of all of the open Squares
	 * of the Board.
	 */
	public ArrayList<int[]> getChoices()
	{
		ArrayList<int[]> choices = new ArrayList<int[]>();
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j].getIsOpen())
				{
					int[] t = new int[2];
					t[0] = i;
					t[1] = j;
					choices.add(t);
				}
			}
		}
		return choices;
	}
	
	/**
	 * Returns a new, identical instance of the Board.
	 */
	public Board copy()
	{
		Board t = new Board();
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				t.board[i][j] = this.board[i][j].copy();
			}
		}
		return t;
	}
	
	/**
	 * Returns a visual representation of the current status
	 * of the Board.
	 */
	public String toString()
	{
		return String.format("  0 1 2%n0 %c|%c|%c%n  -----%n1 %c|%c|%c%n  -----%n2 %c|%c|%c",
				board[0][0].getVal(), board[0][1].getVal(), board[0][2].getVal(),
				board[1][0].getVal(), board[1][1].getVal(), board[1][2].getVal(),
				board[2][0].getVal(), board[2][1].getVal(), board[2][2].getVal());
	}
}