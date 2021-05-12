import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Paddle extends JComponent{

	private Rectangle paddle;
	Color fill;
	int width,height;
	int dy;

	public Paddle(int x, int y,int width, int height, Color fill){
		paddle = new Rectangle(0,0,width,height);
		this.setSize(new Dimension(width+1,height+1));
		this.setLocation(x,y);
		dy=0;
		this.fill=fill;
		this.width=width;
		this.height=height;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		setBounds(new Rectangle(getX(),getY(),width,height));
		g2.setColor(fill);
		g2.fill(paddle);
	}
	
	public void update() {
		this.setLocation(getX(),getY()+dy);
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

}
