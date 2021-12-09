package tildim.hstools.hspitytimertracker.modifiers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ModeButton extends JButton 
{
	public ModeButton(String label, Font font) 
	{
		super(label);
		setFont(font);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		setFocusPainted(false);
		setContentAreaFilled(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		if (getModel().isArmed()) {
			g.setColor(new Color(220, 170, 85));
		}  else {
			g.setColor(getBackground());
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		
		super.paintComponent(g);
	}
}