import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PongMain extends JFrame implements ActionListener{
	
	Ball ball;
	Paddle paddleLeft;
	Paddle paddleRight;
	int leftPoints,rightPoints;
	JLabel leftScore, rightScore;
	int collisions;
	boolean compGame;

	public PongMain() {
		compGame=true;
		collisions=0;
		leftPoints=0;
		rightPoints=0;
		setBounds(0,0,825,825);
		setTitle("Pong");
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JButton compStart = new JButton("Player v. Computer");
		compStart.setFont(new Font("Arial", Font.PLAIN, 20));
		compStart.setBounds(282,330,250,40);
		compStart.setFocusable(false);
		
		JButton playStart = new JButton("Player v. Player");
		playStart.setFont(new Font("Arial", Font.PLAIN, 20));
		playStart.setBounds(282,420,250,40);
		playStart.setFocusable(false);
		
		add(compStart);
		add(playStart);
		
		compStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				remove(playStart);
				remove(compStart);
				computerGame();
			}
		});
		
		playStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				remove(playStart);
				remove(compStart);
				compGame=false;
				playerGame();
			}
		});
		System.out.println(getContentPane().getHeight());
	}
	
	public void playerGame() {
		ball = new Ball(406,388,15,15,Color.WHITE);
		add(ball);
		paddleLeft = new Paddle(40,200,20,100,Color.WHITE);
		add(paddleLeft);
		paddleRight = new Paddle(getContentPane().getWidth()-60,0,20,100,Color.WHITE);
		add(paddleRight);
		
		leftScore = new JLabel("" + leftPoints);
		leftScore.setBounds(203,20,100,100);
		leftScore.setFont(new Font("Arial", Font.PLAIN, 40));
		add(leftScore);
		
		rightScore = new JLabel("" + rightPoints);
		rightScore.setBounds(550,20,100,100);
		rightScore.setFont(new Font("Arial", Font.PLAIN, 40));
		add(rightScore);
		
		Timer t = new Timer(10,this);
		t.start();
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_W)
					paddleLeft.setDy(-5);
				if(e.getKeyCode() == e.VK_S)
					paddleLeft.setDy(5);
				if(e.getKeyCode() == e.VK_UP)
					paddleRight.setDy(-5);
				if(e.getKeyCode() == e.VK_DOWN)
					paddleRight.setDy(5);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == e.VK_W)
					paddleLeft.setDy(0);
				if(e.getKeyCode() == e.VK_S)
					paddleLeft.setDy(0);
				if(e.getKeyCode() == e.VK_UP)
					paddleRight.setDy(0);
				if(e.getKeyCode() == e.VK_DOWN)
					paddleRight.setDy(0);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
		});
	}

	public void computerGame() {
		ball = new Ball(406,388,15,15,Color.WHITE);
		add(ball);
		paddleLeft = new Paddle(40,200,20,100,Color.WHITE);
		add(paddleLeft);
		paddleRight = new Paddle(getContentPane().getWidth()-60,0,20,100,Color.WHITE);
		add(paddleRight);
		
		leftScore = new JLabel("" + leftPoints);
		leftScore.setBounds(203,20,100,100);
		leftScore.setFont(new Font("Arial", Font.PLAIN, 40));
		add(leftScore);
		
		rightScore = new JLabel("" + rightPoints);
		rightScore.setBounds(550,20,100,100);
		rightScore.setFont(new Font("Arial", Font.PLAIN, 40));
		add(rightScore);
		
		Timer t = new Timer(10,this);
		t.start();
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_W)
					paddleLeft.setDy(-5);
				if(e.getKeyCode() == e.VK_S)
					paddleLeft.setDy(5);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == e.VK_W)
					paddleLeft.setDy(0);
				if(e.getKeyCode() == e.VK_S)
					paddleLeft.setDy(0);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
		});
	}
	
	public void actionPerformed(ActionEvent a) {
		if(compGame) {
			boolean speedUpdate=false;
			paddleLeft.update();
				if(paddleLeft.getY()<50)
					paddleLeft.setLocation(paddleLeft.getX(),50);
				if(paddleLeft.getY()+paddleLeft.getHeight()>=getContentPane().getHeight()-50)
					paddleLeft.setLocation(paddleLeft.getX(),getContentPane().getHeight()-paddleLeft.getHeight()-50);
				if(ball.getX()<paddleLeft.getX()+paddleLeft.getWidth() && ball.getX()>paddleLeft.getX() && ball.getY()>paddleLeft.getY() && ball.getY()+ball.getHeight()<paddleLeft.getHeight() + paddleLeft.getY()) { 
					ball.setDx(ball.getDx() * -1 );
					collisions++;
					speedUpdate=true;
				}
				
			paddleRight.update();
				paddleRight.setLocation(paddleRight.getX(),ball.getY()+ball.getWidth()/2-paddleRight.getHeight()/2);
				if(paddleRight.getY()<50)
					paddleRight.setLocation(paddleRight.getX(),50);
				if(paddleRight.getY()+paddleRight.getHeight()>=getContentPane().getHeight()-50)
					paddleRight.setLocation(paddleRight.getX(),getContentPane().getHeight()-paddleRight.getHeight()-50);
				if(ball.getX()+ball.getWidth()>paddleRight.getX() && ball.getX()<paddleRight.getX()+paddleRight.getWidth() && ball.getY()>paddleRight.getY() && ball.getY()+ball.getHeight()<paddleRight.getHeight() + paddleRight.getY()) {
					ball.setDx(ball.getDx() * -1);
					collisions++;
					speedUpdate=true;
				}
				
			if(collisions%2==0 && speedUpdate) {
				if(ball.getDx()>0)
					ball.setDx(ball.getDx()+1);
				else
					ball.setDx(ball.getDx()-1);
			}
				
			ball.update();
				if(ball.getY()<=0)
					ball.setDy(ball.getDy() * -1);
				if(ball.getY()+ball.getHeight()>=getContentPane().getHeight())
					ball.setDy(ball.getDy() * -1);
				if(ball.getX()+ball.getWidth()<0 ) {
					rightPoints++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ball.setLocation(406,388);
					if (Math.random() >= 0.5) 
						ball.setDx(3);
					else
						ball.setDx(-3);
					rightScore.setText(""+rightPoints);
				}
				if(ball.getX()>getContentPane().getWidth()) {
					leftPoints++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ball.setLocation(406,388);
					if (Math.random() >= 0.5) 
						ball.setDx(3);
					else
						ball.setDx(-3);
					leftScore.setText(""+leftPoints);
				}
			if(leftPoints==5) {
				JOptionPane.showMessageDialog(null, "You Won");
				System.exit(0);	
			}if(rightPoints==5) {
				JOptionPane.showMessageDialog(null, "Computer Won");
				System.exit(0);	
			}
			repaint();
		}else {
			boolean speedUpdate=false;
			paddleLeft.update();
				if(paddleLeft.getY()<50)
					paddleLeft.setLocation(paddleLeft.getX(),50);
				if(paddleLeft.getY()+paddleLeft.getHeight()>=getContentPane().getHeight()-50)
					paddleLeft.setLocation(paddleLeft.getX(),getContentPane().getHeight()-paddleLeft.getHeight()-50);
				if(ball.getX()<paddleLeft.getX()+paddleLeft.getWidth() && ball.getX()>paddleLeft.getX() && ball.getY()>paddleLeft.getY() && ball.getY()+ball.getHeight()<paddleLeft.getHeight() + paddleLeft.getY()) { 
					ball.setDx(ball.getDx() * -1 );
					collisions++;
					speedUpdate=true;
				}
				
			paddleRight.update();
				if(paddleRight.getY()<50)
					paddleRight.setLocation(paddleRight.getX(),50);
				if(paddleRight.getY()+paddleRight.getHeight()>=getContentPane().getHeight()-50)
					paddleRight.setLocation(paddleRight.getX(),getContentPane().getHeight()-paddleRight.getHeight()-50);
				if(ball.getX()+ball.getWidth()>paddleRight.getX()  && ball.getX()<paddleRight.getX()+paddleRight.getWidth() && ball.getY()>paddleRight.getY() && ball.getY()+ball.getHeight()<paddleRight.getHeight() + paddleRight.getY()) {
					ball.setDx(ball.getDx() * -1);
					collisions++;
					speedUpdate=true;
				}
				
			if(collisions%2==0 && speedUpdate) {
				if(ball.getDx()>0)
					ball.setDx(ball.getDx()+1);
				else
					ball.setDx(ball.getDx()-1);
			}
				
			ball.update();
				if(ball.getY()<=0)
					ball.setDy(ball.getDy() * -1);
				if(ball.getY()+ball.getHeight()>=getContentPane().getHeight())
					ball.setDy(ball.getDy() * -1);
				if(ball.getX()+ball.getWidth()+5<0 ) {
					rightPoints++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ball.setLocation(406,388);
					if (Math.random() >= 0.5) 
						ball.setDx(3);
					else
						ball.setDx(-3);
					rightScore.setText(""+rightPoints);
				}
				if(ball.getX()>getContentPane().getWidth()) {
					leftPoints++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ball.setLocation(406,388);
					if (Math.random() >= 0.5) 
						ball.setDx(3);
					else
						ball.setDx(-3);
					leftScore.setText(""+leftPoints);
				}
			if(leftPoints==10) {
				JOptionPane.showMessageDialog(null, "Player One Won");
				System.exit(0);	
			}if(rightPoints==10) {
				JOptionPane.showMessageDialog(null, "Player Two Won");
				System.exit(0);	
			}
			repaint();
		}
	}
	
	public static void main(String[] args) {
		new PongMain();
	}


	
}
