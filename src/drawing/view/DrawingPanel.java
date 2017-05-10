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
	private JButton circleButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton ellipseButton;
	private JButton resetButton;
	private ShapePanel shapePanel;
	
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.rectangleButton = new JButton("rectangle");
		this.circleButton = new JButton("circle");
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -19, SpringLayout.NORTH, circleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 77, SpringLayout.NORTH, this);
		this.triangleButton = new JButton("triangle");
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 0, SpringLayout.WEST, triangleButton);
		this.polygonButton = new JButton("polygon");
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, triangleButton, -14, SpringLayout.NORTH, polygonButton);
		this.ellipseButton = new JButton("ellipse");
		baseLayout.putConstraint(SpringLayout.SOUTH, polygonButton, -19, SpringLayout.NORTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.EAST, ellipseButton, 0, SpringLayout.EAST, circleButton);
		this.resetButton = new JButton("reset");
		baseLayout.putConstraint(SpringLayout.SOUTH, ellipseButton, -17, SpringLayout.NORTH, resetButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, circleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, resetButton, -10, SpringLayout.SOUTH, this);
		
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
		this.add(circleButton);
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(ellipseButton);
		this.add(shapePanel);
		this.add(resetButton);
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
		
		
		
		
		circleButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		shapePanel.addCircles();
	}
		}
		
		);
		
		
		
		
		triangleButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		shapePanel.addTriangles();
	}
		}
		
		);
		
		
		
		polygonButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		shapePanel.addPolygons();
	}
		}
		
		);
		
		
		ellipseButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		shapePanel.addEllipse();
	}
		}
		
		);
		
		
		
		resetButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		shapePanel.reset();
	}
		}
		
		);
	}
	
	
}
