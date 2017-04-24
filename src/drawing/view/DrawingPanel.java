package drawing.view;
import javax.swing.*;
import drawing.controller.DrawingController;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel
{
	private SpringLayout baseLayout;
	private DrawingController baseController;
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.GREEN);
		this.setLayout(baseLayout);
	}
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
		
	}
}
