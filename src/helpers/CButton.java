package helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class CButton extends JButton {
	private boolean mouseOver = false;
	private boolean mousePressed = false;
	private Color color = Color.WHITE;
	private Color pressColor = Color.LIGHT_GRAY;
	private Color fontColor = Color.BLACK;
	private Font fnt = null;
	
	public CButton(String text) {
		super(text);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		
		MouseAdapter mouseListener = new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent me){
				mousePressed = true;
				repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent me){
				mousePressed = false;
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent me){
				mouseOver = false;
				mousePressed = false;
				repaint();
			}
			
			@Override
			public void mouseMoved(MouseEvent me){
				mouseOver = true;
				repaint();
			}	
		};
		
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);	
	}
	
	public CButton setColor(Color c) {
		color = c;
		return this;
	}
	
	public CButton setPressColor(Color c) {
		pressColor = c;
		return this;
	}
	
	public CButton setFnt(Font f) {
		fnt = f;
		return this;
	}
	
	public CButton setFontColor(Color c) {
		fontColor = c;
		return this;
	}
	
	/*@Override
	public Dimension getPreferredSize(){
		FontMetrics metrics = getGraphics().getFontMetrics(fnt);
		int minWidth = 10 + Math.max(metrics.stringWidth(getText()), metrics.getHeight());
		return new Dimension(minDiameter, minDiameter);
	}*/
	
	@Override
	public void paintComponent(Graphics g){
		
		
		if(mousePressed){
			g.setColor(color);
			g.fillRect(0, 0, getWidth(), getHeight());
			//g.setColor(pressColor);
		}
		else{
			setOpaque(false);
			setFocusPainted(false);
			setBorderPainted(false);
			//g.setColor(color);
		}
		//g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

		/*if(mouseOver){
			g.setColor(Color.BLUE);
		}
		else{
			g.setColor(Color.BLACK);
		}
		g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
		*/
		g.setColor(fontColor);
		g.setFont(fnt);
		FontMetrics metrics = g.getFontMetrics(fnt);
		int stringWidth = metrics.stringWidth(getText());
		int stringHeight = metrics.getHeight();
		g.drawString(getText(), getWidth()/2 - stringWidth/2, getHeight()/2 + stringHeight/4);
	}
}
