package edu.truman.fischer.randomly_falling_shapes;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class displays a GUI with animated shapes.
 * The user can select the shape, speed, and start time of motion.
 * @author ColinFischer
 * Date Last Modified: 4 May 2018
 */
public class RandomlyFallingShapes
{
	// update the display 24 times a second (every 42 milliseconds)
	static final int ANIMATION_DELAY = 42;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		DisplayIcon display = new DisplayIcon();
		
		// record of all added shapes
		final ArrayList<FallingShape> shapes = new ArrayList<FallingShape>();
		
		JLabel label = new JLabel(display);
		
		// user-interactive options for the shape
		String [] shapeNames = {"Ellipse", "Rectangle"};
		JSpinner shapeSpinner = new JSpinner (new SpinnerListModel(shapeNames));
		String [] speedNames = {"Crawl", "Slow", "Medium", "Fast", "Insane"};
		JSpinner speedSpinner = new JSpinner (new SpinnerListModel(speedNames));
		
		JButton launchButton = new JButton("Launch");
		
		// add click response to the launchButton
		launchButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					FallingShape t = new FallingShape((String)shapeSpinner.getValue(),
														(String)speedSpinner.getValue());
					shapes.add(t); // add new shape to the record
					display.addShape(t); // add shape to the display
					
				}
			});
		
		// allow all components adequate space on the frame
		frame.setLayout(new FlowLayout());
		
		//add all components to the frame
		frame.add(shapeSpinner);
		frame.add(speedSpinner);
		frame.add(launchButton);
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		// the controller for updating the icon
		Timer t = new Timer(ANIMATION_DELAY, new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(shapes.size()>0) // check for existing shape
					shapes.get(shapes.size()-1).move(); // update most recent shape
				label.repaint(); // repetitively redraw display to animate
			}
		});

		t.start(); // Timer starts new thread
	}
}
