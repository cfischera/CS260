package edu.truman.fischer.simple_game;

import java.awt.*;
import java.util.Random;

/**
 * An abstract outline for a movable shape.
 * @author ColinFischer - credit to Dr. Matthews
 * Date Last Modified: 10 May 2018
 */
public abstract class DraggableMovingShape
{
	private int currentX, currentY,
			xRandomMovement, yRandomMovement;
	
	private static final int WIDTH  = 50;
	private static final int HEIGHT = 50;
	
	private static final int MAX_X_VARIATION = 10;
	private static final int MAX_Y_VARIATION = 10;
	
	public static final Random r = new Random();
	
	/**
	 * Creates a movable shape with a random starting position
	 * and a random movement speed.
	 */
	public DraggableMovingShape(int max_initial_x_pos, int max_initial_y_pos)
	{
		currentX = r.nextInt(max_initial_x_pos);
		currentY = r.nextInt(max_initial_y_pos);
		
		xRandomMovement = r.nextInt(MAX_X_VARIATION) - MAX_X_VARIATION / 2;
		yRandomMovement = r.nextInt(MAX_Y_VARIATION) - MAX_Y_VARIATION / 2;
	}
	
	/**
	 * Returns true if a passed point is within the bounds
	 * of a shape.
	 * @param p - the point
	 * @return if inside
	 */
	public abstract boolean contains(Point p);
	
	/**
	 * Moves the shape on screen with a given speed.
	 * @param dx - change in X coordinate
	 * @param dy - change in Y coordinate
	 */
	public void move(int dx, int dy)
	{
		currentX += dx;
		currentY += dy;
	}
	
	/**
	 * Moves the shape on screen with a random speed.
	 */
	public void move()
	{
		currentX += xRandomMovement;
		currentY += yRandomMovement;
	}
	
	/**
	 * Displays the shape on screen.
	 * @param g2 - the graphics context
	 */
	public abstract void draw(Graphics2D g2);
	
	/**
	 * Returns the current X coordinate position
	 * of the shape.
	 * @return the X coordinate
	 */
	public int getShapeCurrentX()
	{
		return currentX;
	}
	
	/**
	 * Returns the current Y coordinate position
	 * of the shape.
	 * @return - the Y coordinate
	 */
	public int getShapeCurrentY()
	{
		return currentY;
	}
	
	/**
	 * Returns the width of the shape.
	 * @return the width
	 */
	public int getShapeWidth()
	{
		return WIDTH;
	}
	
	/**
	 * Returns the height of the shape.
	 * @return the height
	 */
	public int getShapeHeight()
	{
		return HEIGHT;
	}
}