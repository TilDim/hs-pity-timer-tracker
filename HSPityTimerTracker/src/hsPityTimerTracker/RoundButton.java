package hsPityTimerTracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

public class RoundButton extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoundButton(String label, Color back, Color backHover) 
	{
	    super(label);
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, size.height);
	    setPreferredSize(size);
	    
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

	  protected void paintComponent(Graphics g) 
	  {
	    if (getModel().isArmed()) {
	      g.setColor(Color.GRAY);
	    } else {
	      g.setColor(getBackground());
	    }
	    g.fillOval(0, 0, getSize().width-1, getSize().height-1);

	    super.paintComponent(g);
	  }
	  /*
	  protected void paintBorder(Graphics g) 
	  {
	    g.setColor(getBackground());
	    g.drawOval(0, 0, getSize().width-1, getSize().height-1);
	  }
	  */
	  Shape shape;
	  
	  public boolean contains(int x, int y) 
	  {
	    if (shape == null || !shape.getBounds().equals(getBounds())) {
	      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
	    }
	    return shape.contains(x, y);
	  }
}
