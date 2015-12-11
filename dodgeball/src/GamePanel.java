
import java.awt.Color;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Timer;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * This is the beginning of a simple game. You should expand it into a dodgeball
 * game, where the user controls an object with the mouse or keyboard, and tries
 * to avoid the balls flying around the screen. If they get hit, it's game over.
 * If they survive for 20 seconds (or some other fixed time), they go on to the
 * next level. <br>
 * <br>
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * @version Nov. 2015
 * 
 * @author Christina Kemp adapted from Sam Scott
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {


	static int width = 500;
	static int height = 300;
	static int playerX = 0;
	static int playerY = 0;
	static Container c;
	Graphics g;
	static Color boxColor = null;
	int pointer;
	static int mouseX;
	static int mouseY;
	static int missileCounter;
	static JFrame frame;
	  
	

	/**
	 * The number of balls on the screen.
	 */
    static int numBalls = 50;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 50;
	/**
	 * An array of balls.
	 */
	static FlashingBall[] ball = new FlashingBall[numBalls];
	String[] posXY = new String[numBalls];
	static McHammer cantTouchThis;
	
	static int boxSpeed = 5;
	static int points = 0;

/**
 * This is the main class it executed the code
 * @param args String args
 */
	public static void main(String[] args) {
		
		// Set up main window (using Swing's Jframe)
	    frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
	    c = frame.getContentPane();
		c.add(new GamePanel());
		Color[] colors = {Color.BLACK,Color.BLUE,Color.cyan,Color.GREEN,Color.PINK,Color.RED,
		Color.orange,Color.YELLOW , Color.darkGray};
	    JOptionPane.showMessageDialog(frame, "Use WASD controls to control the box you will see it gets harder as you progress");

		frame.pack();
		
		
	     
		 Timer timer = new Timer();
		 timer.schedule(new Music(), 0, 12000);
		
		
		KeyListener listener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				char key = e.getKeyChar();
				
				if (key == 'w' || key =='W' ){
					if(playerY > 0){
						playerY = playerY  -boxSpeed;
					}
					if(playerY < 0){
						playerY = 0;
					}
						
				}
				if(key == 'a' || key == 'A' ){
					if(playerX > 0){
					playerX = playerX -boxSpeed;
					if(playerX < 0){
						playerX = 0;
					}
					}
				
				}
				if(key == 'd' || key == 'D' ){
					if(playerX < 475){
					playerX = playerX +boxSpeed;
					}
					if(playerX > 475){
						playerX = 474;
					}
				
				}
				if (key == 's' || key =='S'){
					if(playerY < 275){
					playerY = playerY  + boxSpeed;
					}
					if(playerY > 275){
						playerY = 274;
					}
			     }
				int d = 0;
				for(int i = 0 ; i < numBalls ; i++){
					 d = d +1;
					if(d >= colors.length){
						d = 0;
					}
					if(playerX-12 <= ball[i].getX() &&playerX+12 >= ball[i].getX()  && playerY-12 <= ball[i].getY() && playerY + 12 >= ball[i].getY() ){
						ball[i].setX(1000000);
						boxSpeed = boxSpeed+1;
						boxColor = colors[d];
						points++;
						frame.setTitle("Points = "+points);
						if(points == numBalls){
							frame.setVisible(true);
							 JOptionPane.showMessageDialog(frame, "You win at whatever that was");
							 System.exit(0);
							}
						}
					}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}
				
			

		};
		frame.addKeyListener(listener);
		
	}
	
	public GamePanel(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);
		
		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(50, 50, 0, width, 0, height);
			ball[i].setXSpeed(Math.random() * 16-8);
			ball[i].setYSpeed(Math.random() * 16-8);
			ball[i].setColor(new Color((int) (Math.random() * 256), (int) (Math
					.random() * 256), (int) (Math.random() * 256)));
		}
		
		cantTouchThis = new McHammer(50, 50, 0, width, 0, height);
		cantTouchThis.setXSpeed(boxSpeed);
		cantTouchThis.setYSpeed(boxSpeed);
		
		Thread gameThread = new Thread(this);
		gameThread.start();
		
	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(pauseDuration);
				
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			ball[i].draw(g);
		}
		g.setColor(boxColor);
		g.fillRect(playerX, playerY, 25, 25);
		cantTouchThis.draw(g);
		if(playerX-25 <= cantTouchThis.getX() &&playerX+25 >= cantTouchThis.getX()  && playerY-25 <= cantTouchThis.getY() && playerY + 25 >= cantTouchThis.getY() ){
			JOptionPane.showMessageDialog(frame, "Looks like you can tounch this");
			System.exit(0);
		}
		
	}
}
