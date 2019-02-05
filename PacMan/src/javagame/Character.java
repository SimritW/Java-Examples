package javagame;
//Importing the right utilities needed
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Character {
	
	/**
	 * Creating all the variables
	 */
	protected Color col;
	protected int width;
	protected int height;
	protected int posX;
	protected int posY;
	protected String name;
	protected boolean isGood;


	/**
	 * Constructor that initializes the variables  
	 */
	public Character(){
		this.col = Color.yellow;
		this.width = 50;
		this.height = 50;
		this.posX = 100;
		this.posY = 100;
		this.name = "Me";
		this.isGood = true;



	}
	/**
	 * Returns the colour of the charecter
	 * @return	the colour
	 */
	public Color getColor(){
		return this.col;	
	}
	/**
	 * Sets the colour of the character
	 * @param col the new colour
	 */
	public void setColor(Color col){
		this.col = col;
	}
	/**
	 * Returns the width of the character
	 * @return the width
	 */
	public int getWidth(){
		return this.width;	
	}
	/**
	 * Sets the width of the character
	 * @param width the new width
	 */
	public void setWidth(int width){
		this.width = width;
	}
	/**
	 * Returns the height of the character
	 * @return the height
	 */
	public int getHeight(){
		return this.height;	
	}
	/**
	 * Sets the height of the character
	 * @param height the new height
	 */
	public void setHeight(int height){
		this.height = height;
	}
	/**
	 * Returns the characters x position
	 * @return the 
	 */
	public int getPosX(){
		return this.posX;
	}
	/**
	 * Sets the characters x position
	 * @param posX the new x coordinate
	 */
	public void setPosX(int posX){
		this.posX = posX;
	}
	/**
	 * Returns the characters y position
	 * @return  the characters y position
	 */
	public int getPosY() {
		return this.posY;
	}
	/**
	 * Sets the characters y position
	 * @param posY the new characters y position
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	/**
	 * Returns the characters name
	 * @return the characters name 
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Sets the characters name
	 * @param name the new characters name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the characters good or not status
	 * @return the characters good or not statur
	 */
	public boolean isGoodorNah() {
		return this.isGood;
	}
	/**
	 * Sets the charecters good or not satus
	 * @param isGood the new good or not status
	 */
	public void setGoodOrNah(boolean isGood) {
		this.isGood = isGood;
	}
	/**
	 * Is a void method that is used by other classes
	 * @param g a draw method that is used by other classes to draw on to the screen
	 */
	public void draw(Graphics g){

	}




}
