package edu.truman.fischer.simple_icon;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * An implementation of the Icon interface that paints a specified
 * square, circle, or triangle in purple, white, or green
 * on a gray background.
 * @author ColinFischer
 * Date Last Modified: 2 May 2018
 */
public class SimpleIcon implements Icon
{
	
	private int dimension;
	private String shape, color;
	private boolean shapeIsSet, colorIsSet;
	
	/**
	 * Creates a SimpleIcon with no initial shapes displayed.
	 */
	public SimpleIcon()
	{
		dimension = 250;
		shapeIsSet = false;
		colorIsSet = false;
	}
	
	/**
	 * Sets the shape choice for the SimpleIcon.
	 * @param choice - the String representation of the shape
	 */
	public void setShape(String choice)
	{
		shape = choice;
		shapeIsSet = true;
	}
	
	/**
	 * Sets the color choice for the SimpleIcon.
	 * @param choice - the String representation of the color
	 */
	public void setColor(String choice)
	{
		color = choice;
		colorIsSet = true;
	}
	
	/**
	 * Draws the SimpleIcon at a specified location.
	 * @param c - what the SimpleIcon is drawn on
	 * @param g - the graphics context
	 * @param x - the X coordinate of the SimpleIcon's top left corner
	 * @param y - the Y coordinate of the SimpleIcon's top left corner
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.GRAY);
		g2.fill(new Rectangle2D.Double(x, y, dimension, dimension));
		
		if(shapeIsSet && colorIsSet)
		{	
			switch(color)
			{
				case "Purple":
					g2.setColor(Color.MAGENTA);
					break;
				case "White":
					g2.setColor(Color.WHITE);
					break;
				case "Green":
					g2.setColor(Color.GREEN);
					break;
				default:
					System.out.println("Error: Invalid color choice.");
			}
			switch(shape)
			{
				case "Sqaure":
					g2.fill(new Rectangle2D.Double(x+25, y+25, dimension-50, dimension-50));
					break;
				case "Circle":
					g2.fill(new Ellipse2D.Double(x+25, y+25, dimension-50, dimension-50));
					break;
				case "Triangle":
					Point2D point1 = new Point2D.Double(x+125, y+25);
					Point2D point2 = new Point2D.Double(x+25, y+225);
					Point2D point3 = new Point2D.Double(x+225, y+225);
					g2.draw(new Line2D.Double(point1, point2));
					g2.draw(new Line2D.Double(point2, point3));
					g2.draw(new Line2D.Double(point3, point1));
					break;
				default:
					System.out.println("Error: Invalid shape choice.");
			}
		}
	}
	
	/**
	 * Returns the height of the SimpleIcon.
	 * @return an int value representing the height
	 */
	public int getIconHeight()
	{
		return dimension;
	}
	
	/**
	 * Returns the width of the SimpleIcon.
	 * @return an int value representing the width
	 */
	public int getIconWidth()
	{
		return dimension;
	}
}