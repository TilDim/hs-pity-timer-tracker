package hsPityTimerTracker;

import javax.swing.Icon;
import javax.swing.JButton;

public class IconButton extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IconButton(Icon icon, Icon hover) 
	{
		super(icon);
		
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				setIcon(hover);
		    }
			
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	setIcon(icon);
		    }
		});
	}
}