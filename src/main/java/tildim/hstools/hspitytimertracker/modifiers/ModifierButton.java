package tildim.hstools.hspitytimertracker.modifiers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class ModifierButton extends JButton 
{
	public ModifierButton(String label, Color back, Color backHover) 
	{
		super(label);
		
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
			g.setColor(Color.GRAY);
		} else {
			g.setColor(getBackground());
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		
		super.paintComponent(g);
	}
}
