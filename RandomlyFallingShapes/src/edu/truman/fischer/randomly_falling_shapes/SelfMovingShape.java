package edu.truman.fischer.randomly_falling_shapes;

import java.awt.Graphics2D;

/** 
 * A shape that can move and draw itself.
 * @author ColinFischer - credit to Dr. Matthews
 * Date Last Modified: 4 May 2018
 */
public interface SelfMovingShape
{
	/** 
	 * Tell the shape to move itself.
	 */
	void move();

	/** 
	 * Tell the shape to draw itself.
	 * @param g2 - the graphics context in which to draw
	 */
	void draw (Graphics2D g2);
}
