package tildim.hstools.hspitytimertracker.modifiers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ShortcutButton extends JButton 
{
	public ShortcutButton(Color back, Color backHover) 
	{
		setBackground(back);
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setFocusPainted(false);
		setContentAreaFilled(false);
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				setBackground(backHover);
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	setBackground(back);
		    }
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		if (getModel().isArmed()) {
			g.setColor(new Color(240, 200, 95));
		}  else {
			g.setColor(getBackground());
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		
		super.paintComponent(g);
	}
}