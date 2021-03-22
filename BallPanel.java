package zad4;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 10;
	private ArrayList<Ball> list = new ArrayList<Ball>();
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public BallPanel() {
		timer.start();
		
		  addMouseListener(new MouseAdapter() { 
			  @Override
	          public void mousePressed(MouseEvent me) {
				  
				  for(int i = 0; i<list.size(); i++) {
						Ball ball = (Ball) list.get(i);
						if(Math.abs(ball.y-me.getY())<=ball.radius && Math.abs(ball.x-me.getX())<=ball.radius) {
				
							list.remove(i);
						}
					
					}
				  
	          } 
	      }); 
	}

	public void add() {
		list.add(new Ball());
	}

	public void subtract() {
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		
		for (int i = 0; i < list.size(); i++) {
			
			Ball ball1 = (Ball) list.get(i);
			for(int j=i+1; j<list.size(); j++) {
				Ball ball2 = (Ball) list.get(j);
				if(Math.abs(ball1.y-ball2.y)<=ball1.radius+ball2.radius && Math.abs(ball1.x-ball2.x)<=ball1.radius+ball2.radius) {
					
					if(ball1.radius>=ball2.radius)
						ball1.radius += (int)(ball1.radius+ball2.radius)/ball2.radius;
					else 
						ball2.radius += (int)(ball2.radius+ball1.radius)/ball1.radius;
					
					
					
					
					list.remove(j);
				}
				
				
				
			}
		}
		
		
		
		
		
		
		
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if (ball.x < ball.radius || ball.x > getWidth()-ball.radius)
				ball.dx = -ball.dx;
			if (ball.y < ball.radius || ball.y > getHeight()-ball.radius)
				ball.dy = -ball.dy;
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
		
		
		
		
		
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}