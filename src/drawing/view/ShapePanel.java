package drawing.view;


import java.awt.*;
import java.io.*;
import java.time.*;
import javax.imageio.*;


import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import drawing.controller.*;

import javax.swing.JPanel;
import java.util.*;

public class ShapePanel extends JPanel
{

	private DrawingController baseController;
	private ArrayList<Shape> rectangleList;
	private ArrayList<Shape> triangleList;
	private ArrayList<Shape> circleList;
	private ArrayList<Shape> ellipseList;
	private ArrayList<Shape> polygonList;
	
	private ArrayList<ArrayList <Shape>> shapes;
	
	public ShapePanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		rectangleList = new ArrayList<Shape>();
		circleList = new ArrayList<Shape>();
		ellipseList = new ArrayList<Shape>();
		triangleList = new ArrayList<Shape>();
		polygonList = new ArrayList<Shape>();
		shapes = new ArrayList<ArrayList <Shape>>();
		
		shapes.add(circleList);
		shapes.add(rectangleList);
		shapes.add(ellipseList);
		shapes.add(triangleList);
		shapes.add(polygonList);
				
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
		if(rectangleList.size() > 500)
		{
			rectangleList.clear();
		}
		
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
	
	public void addTriangles()
	{
		if(triangleList.size() > 500)
		{
			triangleList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int vertexCount = 3;
			int [] xVertices = new int [vertexCount];
			int [] yVertices = new int [vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				
				int originish = (int) (Math.min(Math.random() * this.getWidth(), Math.random() * this.getHeight()));
				int xCorner = (int) (Math.random() * this.getWidth()) + originish;
				int yCorner = (int) (Math.random() * this.getHeight()) + originish;
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			triangleList.add(current);
		}
		this.repaint();
	}
	
	public void addCircles()
	{
		
		if(circleList.size() > 500)
		{
			circleList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			
			int radius =(int) (Math.random() * 25) + 2;
			int xCorner = (int) (Math.random() * this.getWidth()-15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, radius, radius);
			circleList.add(current);
		}
		this.repaint();
	}
	
	public void addPolygons()
	{
		if(polygonList.size() > 500)
		{
			polygonList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int vertexCount = (int) (Math.random() * 7) + 4;
			int [] xVertices = new int [vertexCount];
			int [] yVertices = new int [vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner = (int) (Math.random() * this.getWidth());
				int yCorner = (int) (Math.random() * this.getHeight());
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			triangleList.add(current);
		}
		this.repaint();
	}
	
	public void addEllipse()
	{
		
		if(ellipseList.size() > 500)
		{
			ellipseList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int height = (int) (Math.random() * 50) *2;
			int width =(int) (Math.random() * 25) + 2;
			int xCorner = (int) (Math.random() * this.getWidth()-15);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
			Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, width, height);
			circleList.add(current);
		}
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
//		this.setBackground(getRandomColor());
		Graphics2D drawingGraphics = (Graphics2D) graphics;
//		for(Shape currentRectangle : rectangleList)
//		{
//			drawingGraphics.setColor(getRandomColor());
//			int strokeWidth = (int) (Math.random() * 10) + 1;
//			drawingGraphics.setStroke(new BasicStroke(strokeWidth));
//			drawingGraphics.draw(currentRectangle);
//			
//			int randomness = (int) (Math.random() * 35);
//			if( randomness % 5 == 0 || randomness % 7 == 0)
//			{
//				drawingGraphics.fill(currentRectangle);
//			}
//			
//			else
//			{
//				drawingGraphics.draw(currentRectangle);
//			}
//		}
//	}
		
		for(ArrayList<Shape> currentList : shapes)
		{
			drawShapes(currentList, drawingGraphics);
		}
	}
	
	private void drawShapes(ArrayList<Shape> shapeList, Graphics2D graphics)
	{
		for(Shape currentShape : shapeList)
		{
			graphics.setColor(getRandomColor());
			int strokeWidth = (int) (Math.random() * 10) + 1;
			graphics.setStroke(new BasicStroke(strokeWidth));
			
			int randomness = (int) (Math.random() * 35);
			
			if(randomness % 5 == 0 || randomness % 7 == 0)
			{
				graphics.fill(currentShape);
				graphics.setColor(getRandomColor());
				graphics.draw(currentShape);
				
			}
			else
			{
				graphics.draw(currentShape);
			}
		}
	}
	
	public void reset()
	{
		for(int index = 0; index < shapes.size(); index ++)
		{
			shapes.get(index).clear();
		}
		this.setBackground(getRandomColor());
		this.repaint();
	}
	
//	public void savePanel()
//	{
//		BufferedImage panelImage = new BufferedImage(this.getSize().width, this.getSize(), height, BufferedImage.TYPE_INT_ARGB);
//		Graphics fileGraphics = panelImage.getGraphics();
//		
//		 
//		
//		
//	}
	
}
