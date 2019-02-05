package javagame;
//Importing the right utilities needed
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class PacMan extends Character {

	//Creating variables for the mouth
	protected int mouthAngle, directionAngle;
	/**
	 * A constructor
	 */
	public PacMan(){
		super();
		//Initializing the variables
		this.mouthAngle = 30;	
		this.directionAngle = 0;
	}

	public void draw(Graphics g){
		g.setColor(this.col);	//setting the colour
		//creating the pacman oval
		g.fillArc(this.posX,  this.posY, this.width, this.height, this.mouthAngle +directionAngle,-1*this.mouthAngle+directionAngle);	//the body of PacMan
		
	}

	/**
	 * returns the mouth angle of pacman
	 * @return the mouth angle
	 */
	public int getMouthAngle() {
		return mouthAngle;
	}

	/**
	 * Sets the mouth angle 
	 * @param mouthAngle the new mouth angle
	 */
	public void setMouthAngle(int mouthAngle) {
		this.mouthAngle = mouthAngle;
	}

	/**
	 * returns the direction angle of the mouth
	 * @return the direction angle
	 */
	public int getDirectionAngle(){
		return directionAngle;
	}

	/**
	 * sets the direction angle
	 * @param directionAngle the new direction angle
	 */
	public void setDirectionAngle(int directionAngle){
		this.directionAngle = directionAngle;
	}

}
