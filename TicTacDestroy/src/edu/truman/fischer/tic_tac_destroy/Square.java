package edu.truman.fischer.tic_tac_destroy;

/**
 * This class represents a single space in a
 * game of Tic-Tac-Toe.
 * @author ColinFischer
 * Date Last Modified: 3 March 2018
 */
public class Square
{
	private boolean isOpen; //availability of the Square
	private char value; //character value of the Square
	final char EMPTY_VALUE = ' '; //represents the value of an empty Square
	
	/**
	 * Constructor of an empty Square.
	 */
	public Square()
	{
		this.isOpen = true;
		this.value = this.EMPTY_VALUE;
	}
	
	/**
	 * Returns the availability of the Square.
	 */
	public boolean getIsOpen()
	{
		return isOpen;
	}
	
	/**
	 * Sets the value of a Square, but only once.
	 */
	public void setVal(char value)
	{
		if(isOpen)
		{
			this.value = value;
			isOpen = false;
		}
	}
	
	/**
	 * Returns the character value of the Square.
	 */
	public char getVal()
	{
		return this.value;
	}
	
	/**
	 * Returns a new, identical instance of the Square.
	 */
	public Square copy()
	{
		Square t = new Square();
		t.isOpen = this.getIsOpen();
		t.value = this.getVal();
		return t;
	}
}