package edu.truman.fischer.simple_game;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * An extension of JComponent that specifically
 * displays moving shapes, allows user interaction
 * with the mouse, and keeps track of a score.
 * @author ColinFischer
 * Date Last Modified: 10 May 2018
 */
public class SimpleComponent extends JComponent
{
	private ArrayList<SimpleDraggableMovingShape> theShapes;
	
	private int shapeCounter, captureCounter, percentCounter;
	
	private Point mousePoint;
	
	private SimpleDraggableMovingShape t;
	
	/**
	 * Creates a component for moving objects to be
	 * displayed. Includes a red score area for shapes
	 * to be dropped into.
	 */
	public SimpleComponent()
	{
		setPreferredSize(new Dimension(500, 500));
		theShapes = new ArrayList<SimpleDraggableMovingShape>();
		
		// counters for text boxes
		shapeCounter = 0;
		captureCounter = 0;
		percentCounter = 0;
		
		// user interaction data
		mousePoint = null;
		t = null;
		
		// actions for pressed shapes and released shapes
		addMouseListener(new MouseAdapter()
				{
					// for press
					public void mousePressed(MouseEvent e)
					{
						mousePoint = e.getPoint();
						for(int i=0;i<theShapes.size();i++)
						{
							if(theShapes.get(i).contains(mousePoint) && t==null)
							{
								t = theShapes.remove(i); // pull target from moving shapes
							}
						}
					}
					
					// for release
					public void mouseReleased(MouseEvent e)
					{
						if(!(t==null))
						{
							// if in score area
							if(inScoreArea(e.getPoint()))
							{
								captureCounter++;
								
								// calculate capture percentage
								percentCounter = (int)((double)captureCounter/
										(double)shapeCounter*100);
							}
							else
								theShapes.add(t); // continue moving
						}
						t = null;
					}
				});
		
		// action for dragged shape
		addMouseMotionListener(new MouseMotionAdapter()
				{
					public void mouseDragged(MouseEvent e)
					{
						if(!(t==null))
						{
							Point tPoint = mousePoint; // previous point
							mousePoint = e.getPoint(); // new point
							double dx = mousePoint.getX() - tPoint.getX();
							double dy = mousePoint.getY() - tPoint.getY();
							
							t.move((int)dx, (int)dy); // int cast from double
							
							repaint();
						}
					}
				});
	}
	
	/**
	 * Returns if a moved shape is released in the score area.
	 * @param p - the point of release
	 * @return if inside
	 */
	public boolean inScoreArea(Point p)
	{
		return p.getX()>0 && p.getX()<150
				&& p.getY()>175 && p.getY()<325;
	}
	
	/**
	 * Adds a new shape to the component.
	 */
	public void addShape()
	{
		theShapes.add(new SimpleDraggableMovingShape());
		shapeCounter++;
	}
	
	/**
	 * Returns the total amount of shapes.
	 * @return the amount of shapes
	 */
	public int getShapeCount()
	{
		return shapeCounter;
	}
	
	/**
	 * Returns the amount of captured shapes.
	 * @return the amount of captured shapes
	 */
	public int getCaptureCount()
	{
		return captureCounter;
	}
	
	/**
	 * Returns the percentage amount of captured shapes
	 * out of all.
	 * @return the percentage
	 */
	public int getPercentCount()
	{
		return percentCounter;
	}
	
	/**
	 * Paints the component on screen.
	 * @param g - the graphics context
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		// the score area
		g2.setColor(Color.RED);
		g2.draw(new Rectangle2D.Double(0, 175, 150, 150));
		
		// move all on screen shapes
		for(SimpleDraggableMovingShape i: theShapes)
		{
			i.move();
			i.draw(g2);
		}
		// move a shape held by the cursor
		if(!(t==null))
			t.draw(g2);
	}
}