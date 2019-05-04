package edu.truman.fischer.simple_game;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * An extension of DraggableMovingShape that
 * can either be a square or a circle.
 * @author ColinFischer
 * Date Last Modified: 10 May 2018
 */
public class SimpleDraggableMovingShape extends DraggableMovingShape
{
	private int randomShape; // square or circle (0 or 1)
	
	/**
	 * Creates a shape that is drawn on screen.
	 */
	public SimpleDraggableMovingShape()
	{
		super(500, 500); // maximum starting point (bottom right corner)
		randomShape = new Random().nextInt(2); // randomly decides shape
	}

	/**
	 * @Override
	 * Returns true if a passed point is within the bounds
	 * of a shape.
	 * @param p - the point
	 * @return if inside
	 */
	public boolean contains(Point p)
	{
		if(randomShape==0) // if square
			return p.getX()>=getShapeCurrentX() && p.getX()<=getShapeCurrentX()+getShapeWidth()
					&& p.getY()>=getShapeCurrentY() && p.getY()<=getShapeCurrentY()+getShapeHeight();
		else // if circle 
			// checks if the point is within the radius length of the center
			return Math.abs(p.distance(new Point(getShapeCurrentX()+(getShapeWidth()/2),
					getShapeCurrentY()+(getShapeHeight()/2))))<(getShapeWidth()/2);
	}

	/**
	 * @Override
	 * Displays the shape on screen.
	 * @param g2 - the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		g2.setColor(Color.BLACK);
		if(randomShape==0) // if square
		{
			g2.fill(new Rectangle2D.Double(getShapeCurrentX(), getShapeCurrentY(),
						getShapeWidth(), getShapeHeight()));
		}
		else // if circle
		{
			g2.fill(new Ellipse2D.Double(getShapeCurrentX(), getShapeCurrentY(),
						getShapeWidth(), getShapeHeight()));
		}
	}
}