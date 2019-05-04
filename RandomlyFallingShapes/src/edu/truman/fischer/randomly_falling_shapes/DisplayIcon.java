package edu.truman.fischer.randomly_falling_shapes;

import java.awt.*;
import javax.swing.*;

/**
 * An implementation of the Icon interface that is a template for
 * an animated object to move.
 * @author ColinFischer
 * Date Last Modified: 4 May 2018
 */
public class DisplayIcon implements Icon
{
	private int dimension;
	private FallingShape shape;
	
	/**
	 * Creates a blank display.
	 */
	public DisplayIcon()
	{
		dimension = 500;
	}
	
	/**
	 * Adds a shape to the display.
	 * @param s - the moving object
	 */
	public void addShape(FallingShape s)
	{
		shape = s;
	}
	
	/**
	 * Draws the DisplayIcon at a specified location.
	 * @param c - what the SimpleIcon is drawn on
	 * @param g - the graphics context
	 * @param x - the X coordinate of the SimpleIcon's top left corner
	 * @param y - the Y coordinate of the SimpleIcon's top left corner
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
		if(shape != null)
			shape.draw(g2);
	}
	
	/**
	 * Returns the height of the DisplayIcon.
	 * @return an int value representing the height
	 */
	public int getIconHeight()
	{
		return dimension;
	}
	
	/**
	 * Returns the width of the DisplayIcon.
	 * @return an int value representing the width
	 */
	public int getIconWidth()
	{
		return dimension;
	}
}
