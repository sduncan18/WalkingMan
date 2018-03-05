import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.sun.org.apache.xml.internal.utils.AttList;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private Ball ball;
	ArrayList<Ball> balls = new ArrayList<Ball>();
	public WalkingFrame()
	{
		
		setBounds(100,100,600,400);
		setLayout(null);
		man = new Man(0,0);
		add(man);
		ball = new Ball(getX(),getY());
		Timer timer = new Timer(10,this);
		timer.start();
		addKeyListener(new KeyListener()
				{

					public void keyPressed(KeyEvent e) 
					{
						if(e.getKeyCode()==e.VK_E)
						{
							ball = new Ball(getX(),getY());
							add(ball);
							balls.add(ball);
							ball.setDX(5);
							
						}
						if(e.getKeyCode()==e.VK_W)
						{
							man.setDY(-2);
						}
						
						if(e.getKeyCode()==e.VK_S)
						{
							man.setDY(2);
						}
						
						if(e.getKeyCode()==e.VK_A)
						{
							man.setDX(-2);
						}
						
						if(e.getKeyCode()==e.VK_D)
						{
							man.setDX(2);
						}
					}

					public void keyReleased(KeyEvent e) 
					{
					
						if(e.getKeyCode()==e.VK_W)
						{
							man.setDY(0);
						}
						
						if(e.getKeyCode()==e.VK_S)
						{
							man.setDY(0);
						}
						
						if(e.getKeyCode()==e.VK_A)
						{
							man.setDX(0);
						}
						
						if(e.getKeyCode()==e.VK_D)
						{
							man.setDX(0);
						}
						
					}

					public void keyTyped(KeyEvent e) 
					{
						
					}

									
				});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new  WalkingFrame();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		ball.update();
		man.update();
		repaint();
		
		for(int i = 0; i <= balls.size(); i++);
		{
			if(ball.getX() == 600);
			{
				this.remove(ball);
			}
			
		}
	}
}
