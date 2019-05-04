package edu.truman.fischer.randomly_falling_shapes;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * An implementation of the SelfMovingShape interface that creates
 * red rectangles and blue ellipses of various sizes and moving speeds.
 * @author ColinFischer
 * Date Last Modified: 4 May 2018
 */
public class FallingShape implements SelfMovingShape
{
	private int height, width, currentX, currentY, dx, dy;
	private String shape, speed;
	
	/**
	 * Creates an object that starts at a random position
	 * above a display and then appears to fall.
	 * @param shape - the String representation of the shape
	 * @param speed - the String representation of the speed
	 */
	public FallingShape(String shape, String speed)
	{
		// set the dimensions and initial position to random values
		height = new Random().nextInt(99)+1;
		width = new Random().nextInt(99)+1;
		currentX = new Random().nextInt(500);
		currentY = -height; // start just above the display
		this.shape = shape;
		this.speed = speed;
		setSpeed(); // convert the passed String to int values
	}
	
	/**
	 * Sets the speed for the FallingObject.
	 */
	private void setSpeed()
	{
		switch(speed)
		{
			case "Crawl":
				dx = -2;
				dy = 1;
				break;
			case "Slow":
				dx = -1;
				dy = 2;
				break;
			case "Medium":
				dx = 0;
				dy = 4;
				break;
			case "Fast":
				dx = 1;
				dy = 8;
				break;
			case "Insane":
				dx = 2;
				dy = 16;
				break;
			default:
				System.out.println("Error: Invalid speed choice.");
		}
	}
	
	/**
	 * Updates the position of the FallingShape.
	 */
	public void move()
	{
		currentX += dx;
		currentY += dy;
	}
	
	/**
	 * Draws the FallingShape at its current position.
	 * @param g2 - the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		if(shape.equals("Ellipse"))
		{
			g2.setColor(Color.BLUE);
			g2.fill(new Ellipse2D.Double(currentX, currentY, width, height));
		}
		else if(shape.equals("Rectangle"))
		{
			g2.setColor(Color.RED);
			g2.fill(new Rectangle2D.Double(currentX, currentY, width, height));
		}
	}
}
