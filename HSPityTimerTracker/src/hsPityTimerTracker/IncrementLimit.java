package hsPityTimerTracker;

import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class IncrementLimit extends PlainDocument 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int limit;
	
	IncrementLimit(int limit) 
	{
		super();
		this.limit = limit;
	}
	
	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException 
	{
		if (str == null || str.length() > limit) {
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		
		int length = str.length();
		boolean isValidInteger = true;
		
		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i))) {
                isValidInteger = false;
                break;
            }
		}
		
		if (isValidInteger && ((getLength() + str.length()) <= limit))
			super.insertString(offset, str, attr);
		else
		    Toolkit.getDefaultToolkit().beep();
		
		if (Integer.parseInt(getContent().getString(0, getLength())) > 39 && limit == 2) {
			super.replace(0, getLength(), "1", attr);
			Toolkit.getDefaultToolkit().beep();
		}
		
		Pattern p = Pattern.compile("^0");
		Matcher m = p.matcher(getContent().getString(0, getLength()));
		
		if (m.find()) {
			super.replace(0, getLength(), "1", attr);
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	@Override
	public void replace(int offset, int len, String str, AttributeSet attr) throws BadLocationException 
	{
		if (str == null || str.length() > limit) {
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		
		int length = str.length();
		boolean isValidInteger = true;
		
		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i))) {
                isValidInteger = false;
                break;
            }
		}
		
		if (isValidInteger)
		    super.replace(offset, len, str, attr);
		else
		    Toolkit.getDefaultToolkit().beep();
	}
}