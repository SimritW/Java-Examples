package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


//Crating all the variables
public class pellets {
	protected Color col;
	protected int width;
	protected int height;
	protected int posX;
	protected int posY;

	/**
	 *Cunstructor  that initializes the needed variables
	 */
	public pellets(){
		this.col = Color.white;
		this.width = 0;
		this.height = 0;
		this.posX  = 10;
		this.posY  = 10;


	}
	/**
	 * Returns the colour of the pellets
	 * @return	the colour
	 */
	public Color getColor(){
		return this.col;	
	}
	/**
	 * Sets the colour of the pellets
	 * @param col the new colour
	 */
	public void setColor(Color col){
		this.col = col;
	}
	/**
	 * Returns the width of the pellets
	 * @return the width
	 */
	public int getWidth(){
		return this.width;	
	}
	/**
	 * Sets the width of the pellets
	 * @param width the new width
	 */
	public void setWidth(int width){
		this.width = width;
	}
	/**
	 * Returns the height of the pellets
	 * @return the height
	 */
	public int getHeight(){
		return this.height;	
	}
	/**
	 * Sets the height of the pellets
	 * @param height the new height
	 */
	public void setHeight(int height){
		this.height = height;
	}
	/**
	 * Returns the pellets x position
	 * @return the 
	 */
	public int getPosX(){
		return this.posX;
	}
	/**
	 * Sets the pellets x position
	 * @param posX the new x coordinate
	 */
	public void setPosX(int posX){
		this.posX = posX;
	}
	/**
	 * Returns the pellets y position
	 * @return  the pellets y position
	 */
	public int getPosY() {
		return this.posY;
	}
	/**
	 * Sets the pellets y position
	 * @param posY the new pellets y position
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * draws the pellets to the screen
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(this.col);
		g.fillOval(this.posX, this.posY, this.width, this.height);
	}
}
