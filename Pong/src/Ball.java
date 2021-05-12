import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent {

	private Ellipse2D.Double circle;
	Color fill;
	int width,height;
	int dx,dy;
	
	public Ball(int x, int y,int width, int height, Color fill){
		circle = new Ellipse2D.Double(0,0,width,height);
		this.setSize(new Dimension(width+1,height+1));
		this.setLocation(x,y);
		if (Math.random() >= 0.5) 
			dx=3;
		else
			dx=-3;
		if (Math.random() >= 0.5) 
			dy=1;
		else
			dy=-1;
		this.fill=fill;
		this.width=width;
		this.height=height;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		setBounds(new Rectangle(getX(),getY(),width,height));
		g2.setColor(fill);
		g2.fill(circle);
		g2.draw(circle);
	}
	
	public void update() {
		this.setLocation(getX()+dx,getY()+dy);
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	
}
