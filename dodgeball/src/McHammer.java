

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class implements a flashing ball. Feel free to change this, implement a
 * new object, change the animation, etc. <br>
 * 
 * @version November 2015
 * @author Simar Pal Kalsi adapted from Christina Kemp and Sam Scott
 * 
 */
public class McHammer extends MovingObject {
	/**
	 * The radius of the ball.
	 */
	private int width;
	private int height;
	/**
	 * Counts the frames between flash on/off.
	 */
	private int counter;
	/**
	 * The number of frames to wait before toggling the flash.
	 */
	private int flashSpeed;
	/**
	 * Controls the flash - true if the ball is filled in, false if it is an
	 * outline.
	 */
	private boolean filledIn;

	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x
	 *            The x location.
	 * @param y
	 *            The y location.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 */
	public McHammer(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		height = 100;
		width = 100;
		counter = 0;
	}
	/**
	 * Draws the ball
	 * 
	 * @param g
	 *            The graphics context.
	 */
	public void draw(Graphics g) {
		int drawX = (int) getX() - width;
		int drawY = (int) getY() - height;

		g.setColor(color);
		g.fillRect(drawX, drawY, width, height);
	}
	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub
		
	}
}
