package javagame;

//Importing all the utilities needed for this class
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**This is the main part of the game, where all of the screens are created and the screen size is created.
 * 
 * @author simrit
 *
 */
public class Game extends StateBasedGame {

	//Creating the screens for the game ie the menu, the play screen, and the end screen  
	public static final String gameName = "myGame";
	public static final int menu = 0; //Each screen of your game has a number assigned to it
	public static final int play = 1; //Setting the play screen to a value of 1
	public static final int endScreen = 2;	//Setting the end screen to a value of 2


	/**
	 * The constructor for the standard game
	 * @param gameName
	 */
	public Game(String gameName) {
		super(gameName);
		//Adding all of the screens to the game 
		this.addState(new Menu(menu)); 	//adding the menu
		this.addState(new Play(play));	//adding the play screem
		this.addState(new end(endScreen));	//adding the end screen
	}
	/**
	 * This method initializes all the screens
	 */

	public void initStatesList(GameContainer gc) throws SlickException {
		//Initializing all of the screens
		this.getState(menu).init(gc, this);	//initializing the menu
		this.getState(play).init(gc, this);	//initializing the play screen
		this.getState(endScreen).init(gc, this);	//initializing the end screen 

		this.enterState(menu); //Tells the program to start at the 'Menu' screen
	}       

	/**
	 * This is the main method, it starts the game running
	 * @param args
	 */
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {	//trying to make the game and start it
			appgc = new AppGameContainer(new Game(gameName));	//telling the game container that the game name is gameName
			appgc.setDisplayMode(1024, 640, false);	//Making the screen size
			appgc.setTargetFrameRate(60);	//Setting the FPS limit to 60 FPS
			appgc.setVSync(true);	//turning VSync on so that the game is processing the image correct
			appgc.start();	//starting the game
		} catch(SlickException e) {	//catching all of the error that are created by the program
			e.printStackTrace();	//print in the counsel what is being created and what the errors are
		}
	}

}
