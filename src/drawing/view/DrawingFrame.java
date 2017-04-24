package drawing.view;

import javax.swing.*;
import java.awt.*;
import drawing.controller.*;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingPanel appPanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("wao bro");
		this.setSize(new Dimension(800,800));
		this.setResizable(true);
		this.setVisible(true);
	}
}
