import edu.truman.fischer.simple_icon.SimpleIcon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class displays a GUI for the user to interact with.
 * The user can change the displayed Icon by clicking on buttons.
 * @author ColinFischer
 * Date Last Modified: 2 May 2018
 */
public class FischerSimpleGUI
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		final SimpleIcon mySimpleIcon = new SimpleIcon();
		
		JLabel label = new JLabel(mySimpleIcon);
		
		JButton square = new JButton("Square");
		JButton circle = new JButton("Circle");
		JButton triangle = new JButton("Triangle");
		JButton purple = new JButton("Purple");
		JButton white = new JButton("White");
		JButton green = new JButton("Green");
		
		// add a click response to every button
		square.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					mySimpleIcon.setShape("Sqaure");
					label.repaint(); // redraw updated icon
				}
			});
		circle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mySimpleIcon.setShape("Circle");
				label.repaint(); // redraw updated icon
			}
		});
		triangle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mySimpleIcon.setShape("Triangle");
				label.repaint(); // redraw updated icon
			}
		});
		
		purple.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mySimpleIcon.setColor("Purple");
				label.repaint(); // redraw updated icon
			}
		});
		white.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mySimpleIcon.setColor("White");
				label.repaint(); //redraw updated icon
			}
		});
		green.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mySimpleIcon.setColor("Green");
				label.repaint(); // redraw updated icon
			}
		});
		
		// allow all components adequate space on the frame
		frame.setLayout(new FlowLayout());
		
		//add all components to the frame
		frame.add(square);
		frame.add(circle);
		frame.add(triangle);
		frame.add(purple);
		frame.add(white);
		frame.add(green);
		
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}