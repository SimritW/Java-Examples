package javagame;
//Importing all of the utilities that are needed 
import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

//Extending the BasicGameState to the end class
public class end extends BasicGameState {

	private Font awtFont;	//Making a variable that holds what font it is and the format of it  
	private TrueTypeFont font;	//Making a variable that creates the font easy to access  
	Color colour;	//Creating a color variable called color
	private int mouseX;	//A variable that holds the x coordinate of the mouse 
	private int mouseY;	//A variable that holds the y coordinate of the mouse
	/**
	 * This method makes it so that the Game class is able to creat a screen called Menu
	 * @param end
	 */
	public end(int state){
	}

	/**
	 * All global variables are initialized in this method
	 */
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		awtFont = new Font("Charlemagne Std", Font.BOLD, 36);
		font = new TrueTypeFont(awtFont, true);
		colour = Color.white;
	}

	/**
	 * Place objects on the screen at their starting locations
	 */	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Creating a button that asks the user if they want to retry
		g.setColor(Color.blue);	//setting the colour
		g.fillRect(440,100,139,40);	//creating the shape
		g.setFont(font);	//making the font
		g.setColor(colour);	//chaning the colour of the font
		g.drawString("Retry!", 440, 100);	//Placeing the words over the box created
		//Creating a button that asks the user if they want to quit
		g.setColor(Color.blue);
		g.fillRect(450,300,110,40);
		g.setFont(font);
		g.setColor(colour);
		g.drawString("Quit", 450, 300);
		//Printing there score to the 
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Your Score is " + Play.score , 350, 500);

	}

	/**
	 * This is the main game loop, updates every cycle
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int g) throws SlickException {
		//Inputing the cordinates of the mouse to the variavles
		Input in = gc.getInput();
		//Setting the mouse variables to the actual mouse
		mouseX = in.getMouseX();
		mouseY = in.getMouseY();
		//Checking if the retry button is pressed by making sure that the button is pressed down in a certain range 
		if((mouseX > 256) && (mouseX < 725)&& (mouseY > 101) && (mouseY < 140) && (in.isMouseButtonDown(0))){
			this.colour = Color.yellow;
			Play.score = 0;//reseting the score 
			sbg.enterState(1);//sending them back to the play screen
		}
		else{
			this.colour = Color.yellow;
		}
		//Checking if the quit button is pressed by making sure that the button is pressed down in a certain range 
		if((mouseX > 149) && (mouseX < 840)&& (mouseY > 300) && (mouseY < 341) && (in.isMouseButtonDown(0))){
			this.colour = Color.yellow;
			System.exit(1);//quiting the game
		}
		
	}

	/**
	 * This matches the number assigned in the game class
	 */
	public int getID() {
		return 2;
	}

}
