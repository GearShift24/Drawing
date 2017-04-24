package drawing.view;


import java.awt.*;

import drawing.controller.*;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.util.*;

public class ShapePanel extends JPanel
{

	private DrawingController baseController;
	private ArrayList<Rectangle> rectangleList;
	
	public ShapePanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		rectangleList = new ArrayList<Rectangle>();
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setMinimumSize(new Dimension(250,500));
		
	}
	
	private Color getRandomColor()
	{
		int alpha = (int) (Math.random() * 255);
		int red = (int) (Math.random() * 255);
		int  blue = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		
		return new Color(red, green, blue, alpha);
	}
	
	public void addRectangles()
	{
	for(int i = 0; i < 500; i++)
		{
			int width = (int) (Math.random() * 120 + 1);
			int height = (int) (Math.random() * 120) + 15;
			int xCorner = (int) (Math.random() * this.getWidth() -15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			
			Rectangle currentRectangle = new Rectangle(xCorner,yCorner,width,height);
			rectangleList.add(currentRectangle);
			
		}
	this.repaint();
	}
}
