package drawing.view;

import javax.swing.*;
import java.awt.*;

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
		this.setTitle("this is a crappy app");
		this.setSize(new Dimension(800,800));
		this.setResizable(false);
		this.setVisible(true);
	}
}
