import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.truman.fischer.simple_game.*;

/**
 * This class is the driver for a simple game consisting of
 * moving squares and circles, which can be dragged by the user into
 * a score area.
 * @author ColinFischer
 * Date Last Modified: 10 May 2018
 */
public class FischerColinSimpleGame
{
	
	// update the display 24 times a second (every 42 milliseconds)
	static final int ANIMATION_DELAY = 42;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Simple Game");
		
		frame.setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		SimpleComponent movingDisplay = new SimpleComponent();
		
		JTextField totalShapesText = new JTextField(20);
		JTextField capturedShapesText = new JTextField(20);
		JTextField percentCaptured = new JTextField(20);
		
		frame.add(panel);
		frame.add(movingDisplay);
		
		panel.add(totalShapesText);
		panel.add(capturedShapesText);
		panel.add(percentCaptured);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Timer for screen animation
		Timer t1 = new Timer(ANIMATION_DELAY, new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						totalShapesText.setText("Total Shapes: "+
								movingDisplay.getShapeCount());
						capturedShapesText.setText("Captured Shapes: "+
								movingDisplay.getCaptureCount());
						percentCaptured.setText("Percent Shapes Captured: "+
								movingDisplay.getPercentCount()+"%");
						frame.repaint();
					}
				});
		
		// Timer for adding new shapes (once every full second)
		Timer t2 = new Timer(1000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						movingDisplay.addShape();
					}
				});
		
		t1.start();
		t2.start();
	}
}