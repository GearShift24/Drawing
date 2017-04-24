package drawing.view;
import javax.swing.*;
import drawing.controller.DrawingController;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel
{
	private SpringLayout baseLayout;
	private DrawingController baseController;
	
	private JButton rectangleButton;
	private ShapePanel shapePanel;
	
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.rectangleButton = new JButton("click me breh");
		
		shapePanel = new ShapePanel(baseController);
	

		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.GREEN);
		this.setLayout(baseLayout);
		this.add(rectangleButton);
		this.add(shapePanel);
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 250, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
	}
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
				}
				
				);
	}
}
