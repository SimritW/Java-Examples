package javagame;
//Importing all of the utilities that are needed 
import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//Extending the BasicGameState to the menu class
public class Menu extends BasicGameState{


	private Font awtFont;	//Making a variable that holds what font it is and the format of it  
	private TrueTypeFont font;	//Making a variable that creates the font easy to access  
	Color colour;	//Creating a color variable called color
	private int mouseX;	//A variable that holds the x coordinate of the mouse 
	private int mouseY;	//A variable that holds the y coordinate of the mouse
	protected static boolean twoPlayers = false;	//A variable that is used by the play and menu class to make sure that mrs.pacman is selected over mr.pacman  
	protected static boolean hard = false;			//A variable that is used by the play and menu classes to make sure if the difficulty is normal or hard
	Image pacman; 	//A image variable that holds the picture called pacman

	/**
	 * This method makes it so that the Game class is able to creat a screen called Menu
	 * @param menu
	 */
	public Menu(int menu) {
	}
	/**
	 * All global variables are initialized in this method
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		awtFont = new Font("Charlemagne Std", Font.BOLD, 36);
		font = new TrueTypeFont(awtFont, true);
		colour = Color.yellow;
		twoPlayers = false;
		hard = false;
		pacman = new Image ("res/PacManMenu.png");
	}
	/**
	 * Place objects on the screen at their starting locations
	 */

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//Drawing the pacman image to the screen and moving the image to the bottom right and scaling it to the right size
		g.drawImage(pacman,720,348,1000,600,0,0,pacman.getWidth(),pacman.getHeight());

		//Creating a button that tells the user how to play and start the game
		g.setColor(Color.blue);//setting the colour
		g.fillRect(256,100,470,40);//creating the shape
		g.setFont(font);//making the font
		g.setColor(colour);//chaning the colour of the font
		g.drawString("Press to Enter Game!", 256, 100);//Placeing the words over the box created
		g.drawString("Use Arrow Keys", 325, 150);

		//Creating a button that tells the user how to play and start the game as Mrs.Pacman
		g.setColor(Color.blue);
		g.fillRect(150,300,690,40);
		g.setFont(font);
		g.setColor(colour);
		g.drawString("Press Enter to Play two Player", 150, 300);
		g.drawString("Use Arrow Keys for Mrs.Pacman", 75, 350);

		//Creating a button tells raises the difficulty to the double the speed of the ghost
		g.setColor(Color.blue);
		g.fillRect(325,500,370,40);
		g.setFont(font);
		g.setColor(colour);
		g.drawString("Hard Dificulty", 325, 500);

	}
	/**
	 * This is the main game loop, updates every cycle
	 */

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		//Inputing the cordinates of the mouse to the variavles
		Input in = gc.getInput();
		//Setting the mouse variables to the actual mouse
		mouseX = in.getMouseX();
		mouseY = in.getMouseY();

		//Checking if the first button is pressed by making sure that the button is pressed down in a certain range 
		if((mouseX > 256) && (mouseX < 725)&& (mouseY > 101) && (mouseY < 140) && (in.isMouseButtonDown(0))){
			sbg.enterState(1);//Sending the user to the play screen
			hard = false;		// Making the hard variable false and so the game starts at a normal difficulty
			twoPlayers = false; // Making sure that Mrs.Pacman is not on screen when pacman is selected 
			this.colour = Color.yellow;
		}
		
		//Checking if the second button is pressed by making sure that the button is pressed down in a certain range
		if((mouseX > 149) && (mouseX < 840)&& (mouseY > 300) && (mouseY < 341) && (in.isMouseButtonDown(0))){
			hard = false;// Making the hard variable false and so the game starts at a normal difficulty
			twoPlayers = true;// Making sure that Mrs.Pacman is on screen when pacman is DESELECTED 
			this.colour = Color.yellow;
			sbg.enterState(1);//NOW ENTER THE PLAY SCREEN!!
		}
		
		//Checking if the third button is pressed by making sure that the button is pressed down in a certain range 
		if((mouseX > 325) && (mouseX < 695)&& (mouseY > 500) && (mouseY < 541) && (in.isMouseButtonDown(0))){
			twoPlayers = false; // Making sure that Mrs.Pacman is not on screen when pacman is selected 
			hard = true; // Making sure that the difficulty is set to hard when this button is pressed 
			this.colour = Color.yellow;
			sbg.enterState(1);//NOW ENTER THE PLAY SCREEN!!
		}
		
	}
	/**
	 * This matches the number assigned in the game class
	 */
	public int getID() {
		return 0;
	}


}
