package javagame;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{


	Input in;		//Input variable to get inputs
	PacMan pac1;	//Setting the pacman character to pac1 
	int openOrClosed;//Having a variable that opens and closes the mouth
	int distance;	//the distance between the center of pacman and the ghost 
	boolean scoreCollision;	//A variable that goes off when pacman is touching the pellet 
	int testX;	//Checking is the x coordinate of pacman or the ghost is close to the wall
	int testY;	//Checking is the x coordinate of pacman or the ghost is close to the wall
	//Variable's that checks if pacman is colliding with red walls at any corner 
	boolean leftCollsion;	
	boolean rightCollsion;
	boolean topCollsion;
	boolean bottomCollsion;
	//Veriable's that checks if pacman is colliding with red walls at any corner 
	boolean leftCollsion2;
	boolean rightCollsion2;
	boolean topCollsion2;
	boolean bottomCollsion2;
	boolean blueGhostCollision;
	//Setting the map, the ghost, and the pellets to the correct classes
	pellets pellet;
	map map;
	ghosts blueGhost;
	//Making a protected static variable that can be accessed by other classes
	protected static int score;
	//Importing the font variables 
	private Font awtFont;
	private TrueTypeFont font;
	//Polymoric Array that does nothing
	Character[] polymorphicCharArray = {pac1, blueGhost};

	
	public Play(int State){
	
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//Making pac1 equal to the PacMan Class
		pac1 = new PacMan();
		//Initializing all the variables in the PacMan class
		pac1.setColor(Color.yellow);
		pac1.setWidth(50);
		pac1.setHeight(50);
		pac1.setPosY(100);
		pac1.setPosX(100);
		pac1.setGoodOrNah(true);
		pac1.setName("Pacman");
		pac1.setDirectionAngle(0);
		//A variable that opens the mouth to a certain angle
		openOrClosed = -2;		//start with the mouth closed
		//Initializing more variables 
		leftCollsion = false;
		rightCollsion = false;
		topCollsion = false;
		bottomCollsion = false;
		leftCollsion2 = false;
		rightCollsion2 = false;
		topCollsion2 = false;
		bottomCollsion2 = false;
		testX =0;
		testY =0;
		//Initializing the pellet touching the pacman boolean
		scoreCollision = false;
		//Making the map equal to the map class
		map = new map();
		//Initializing the ghost variables from the ghosts class 
		blueGhost = new ghosts();
		blueGhost.setWidth(50);
		blueGhost.setHeight(50);
		blueGhost.setPosX(300);
		blueGhost.setPosY(300);
		//Initializing the pellet variables from the pellets class 
		pellet = new pellets();
		pellet.setColor(Color.white);
		pellet.setWidth(19);
		pellet.setHeight(19);
		pellet.setPosY((int)(Math.random()*620));
		pellet.setPosX((int)(Math.random()*1004));
		//Making the boolean of pacman touching the ghost to false 
		blueGhostCollision = false;
		//setting the score to zero
		score = 0;
		//Initalizing a variable that holds what font it is and the format of it
		awtFont = new Font("Charlemagne Std", Font.BOLD, 36);
		//Making a variable that creates the font easy to access  
		font = new TrueTypeFont(awtFont, true);
	}
	/**
	 * Rendering the characters to the screen
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//Drawing the ghost to the screen
		blueGhost.draw(g);		
		//Checking if the collision is true then adding 1 to the score, and making the pellet spawn randomly
		if(scoreCollision == true){
			pellet.setPosX(((int)(Math.random()*1000) + 10));
			pellet.setPosY(((int)(Math.random()*600) +10));
			score++;
		}
		else{
			pac1.setColor(Color.yellow);

		}
		//Making pac1 pink if mrs pacman is selected 
		if(Menu.twoPlayers == true){
			pac1.setColor(Color.pink);
			pac1.draw(g);
		}
		//Otherwise just drawing pacman normally
		else{
		pac1.draw(g);//this will draw pacman on the screen
			
		}
		//Drawing the map to the screen
		map.draw(g);
		//Drawing the pellets to the screen
		pellet.draw(g);
		//Setting the font and colour for the score 
		g.setFont(font);
		g.setColor(Color.white);
		//Printing the score
		g.drawString("Score: " + score, 10, 600);
		//Checking if the right corner of pacman is touching the map
		for (int i = -45; i < 45 ; i += 10){
			//Testing the X,Y for the right corner
			testX = (int)( pac1.getPosX() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( pac1.getPosY() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			//Check if that section is red
			if (g.getPixel(testX, testY).equals(Color.red)){
				rightCollsion = true;	//Make collision true
				break;
			}
			else{
				rightCollsion = false;//Make collision false
			}
		}
		//Checking if the bottom corner of pacman is touching the map
		for (int i = 45; i < 135; i += 10){
			//Testing the X,Y for the bottom corner
			testX = (int)( pac1.getPosX() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( pac1.getPosY() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			//Check if that section is red
			if (g.getPixel(testX, testY).equals(Color.red)){
				bottomCollsion = true;//Make collision true
				break;
			}
			else{
				bottomCollsion = false;//Make collision false
			}
		}
		//Checking if the left corner of pacman is touching the map
		for (int i = 135; i < 225; i += 10){
			//Testing the X,Y for the left corner
			testX = (int)( pac1.getPosX() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( pac1.getPosY() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			//Check if that section is red
			if (g.getPixel(testX, testY).equals(Color.red)){
				leftCollsion = true;//Make collision true
				break;
			}
			else{
				leftCollsion = false;//Make collision false
			}
		}		
		//Checking if the top corner of pacman is touching the map
		for (int i = 225; i < 315; i += 10){
			//Testing the X,Y for the top corner
			testX = (int)( pac1.getPosX() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( pac1.getPosY() + (pac1.getWidth()/2.0) + (pac1.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			//Check if that section is red
			if (g.getPixel(testX, testY).equals(Color.red)){
				topCollsion = true;//Make collision true
				break;
			}
			else{
				topCollsion = false;//Make collision false

			}
		}
		//Re doing the previous  for loops for the ghost
		for (int i = -45; i < 45 ; i += 10){
			testX = (int)( blueGhost.getPosX() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( blueGhost.getPosY() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			if (g.getPixel(testX, testY).equals(Color.red)){
				rightCollsion2 = true;
				break;
			}
			else{
				rightCollsion2 = false;

			}
		}
		for (int i = 45; i < 135; i += 10){
			testX = (int)( blueGhost.getPosX() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( blueGhost.getPosY() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			if (g.getPixel(testX, testY).equals(Color.red)){
				bottomCollsion2 = true;
				break;
			}
			else{
				bottomCollsion2 = false;
			}
		}
		for (int i = 135; i < 225; i += 10){
			testX = (int)( blueGhost.getPosX() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( blueGhost.getPosY() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			if (g.getPixel(testX, testY).equals(Color.red)){
				leftCollsion2 = true;
				break;
			}
			else{
				leftCollsion2 = false;
			}
		}
		for (int i = 225; i < 315; i += 10){
			testX = (int)( blueGhost.getPosX() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.cos(i*Math.PI/180.0));
			testY = (int)( blueGhost.getPosY() + (blueGhost.getWidth()/2.0) + (blueGhost.getWidth()/2.0)*Math.sin(i*Math.PI/180.0));
			if (g.getPixel(testX, testY).equals(Color.red)){
				topCollsion2 = true;
				break;
			}
			else{
				topCollsion2 = false;

			}
		}
		//Reseting all the variables to the original positions when pacman is killed by the ghost
		if(blueGhostCollision == true){
			sbg.enterState(2);
			pac1.setPosY(100);
			pac1.setPosX(100);
			blueGhost.setPosX(600);
			blueGhost.setPosY(600); 
			pellet.setPosX(((int)(Math.random()*1000) + 10));
			pellet.setPosY(((int)(Math.random()*600) +10));
		}

	}
	/**
	 * This is the main game loop, updates every cycle
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		//Setting 'in' to get input variables 
		in = gc.getInput();
		//Opening and closing pacmans mouth evey cycle
		pac1.setMouthAngle(pac1.getMouthAngle() + openOrClosed); 
		//Making sure that the mouth veriable is not biger than 30 degrees 
		if ((pac1.getMouthAngle() < 3) || (pac1.getMouthAngle() > 30)){
			openOrClosed = openOrClosed *-1;
		}
		//Moving Pacman when the key is pressed and when pacman is not colliding with anything
		if(in.isKeyDown(Input.KEY_DOWN) && bottomCollsion == false){
			pac1.setPosY(pac1.getPosY() +5) ;
			pac1.setDirectionAngle(90);
		}
		if(in.isKeyDown(Input.KEY_UP) && topCollsion == false){
			pac1.setPosY(pac1.getPosY() -5) ;
			pac1.setDirectionAngle(270);
		}
		if(in.isKeyDown(Input.KEY_LEFT) && leftCollsion == false){
			pac1.setPosX(pac1.getPosX() -5) ;
			pac1.setDirectionAngle(180);
		}
		if(in.isKeyDown(Input.KEY_RIGHT)&& rightCollsion == false){
			pac1.setPosX(pac1.getPosX() +5);
			pac1.setDirectionAngle(0);
		}
		//If pacman is colliding with the wall then make it so that he stops moving
		if(bottomCollsion == true){
			pac1.setPosY(pac1.getPosY() -0) ;
			pac1.setDirectionAngle(90);
		}
		if(topCollsion == true){
			pac1.setPosY(pac1.getPosY() +0) ;
			pac1.setDirectionAngle(270);
		}
		if(leftCollsion == true){
			pac1.setPosX(pac1.getPosX() +0) ;
			pac1.setDirectionAngle(180);
		}
		if(rightCollsion == true){
			pac1.setPosX(pac1.getPosX() -0);
			pac1.setDirectionAngle(0);
		}
		//Making sure the ghost does not go through the walls when hard mode is selected at all sides of the ghost
		if (Menu.hard == true) {
			if(bottomCollsion2 == true){	
			blueGhost.setPosY(blueGhost.getPosY()-4) ;
			}
			if(topCollsion2 == true){
			blueGhost.setPosY(blueGhost.getPosY()+4) ;
			}
			if(leftCollsion2 == true){
				blueGhost.setPosX(blueGhost.getPosX()+4) ;
			}
			if(rightCollsion2 == true){
				blueGhost.setPosX(blueGhost.getPosX()-4);
			}
		}
		//Making sure the ghost does not go through the walls at normal speed at all sides of the ghost
		else{
			if(bottomCollsion2 == true){
				blueGhost.setPosY(blueGhost.getPosY()-2) ;
				}
				if(topCollsion2 == true){
				blueGhost.setPosY(blueGhost.getPosY()+2) ;
				}
				if(leftCollsion2 == true){
					blueGhost.setPosX(blueGhost.getPosX()+2) ;
				}
				if(rightCollsion2 == true){
					blueGhost.setPosX(blueGhost.getPosX()-2);
		}
		}
		//Now calculate the distance between the two pacmen
		distance = distance = (int) Math.sqrt((Math.pow(((pac1.getPosX()+(pac1.getWidth()/2.0))-(pellet.getPosX() + (pellet.getWidth()/2.0))),2) + Math.pow(((pac1.getPosY()+(pac1.getWidth()/2.0))-(pellet.getPosY()+(pellet.getWidth()/2.0))),2)));

		//check if the pacmen are overlapping
		if(distance<0.5*(pac1.getWidth() + pellet.getWidth())){
			scoreCollision = true;
		}
		else{
			scoreCollision = false;
		}
		//Check if the pacmen are overlapping the ghosts 
		distance = (int) Math.sqrt((Math.pow(((pac1.getPosX()+(pac1.getWidth()/2.0))-(blueGhost.getPosX() + (blueGhost.getWidth()/2.0))),2) + 
				Math.pow(((pac1.getPosY()+(pac1.getWidth()/2.0))-(blueGhost.getPosY()+(blueGhost.getWidth()/2.0))),2)));
		//Makes a boolean true or false if Pacman is overlapping the ghost 
		if (distance <= 0.5*(pac1.getWidth() + blueGhost.getWidth())) {
			blueGhostCollision = true;
		}
		else {
			blueGhostCollision = false;
		}
			//Making the ghost follow pacman and move faster when hard more is selected 
				if (Menu.hard == true) {
					if(pac1.getPosX()>blueGhost.getPosX()){
						blueGhost.setPosX(blueGhost.getPosX()+4);
					}
					else{
						blueGhost.setPosX(blueGhost.getPosX()-4);
					}

					if(pac1.getPosY()>blueGhost.getPosY()){
						blueGhost.setPosY(blueGhost.getPosY()+4);
					}
					else{
						blueGhost.setPosY(blueGhost.getPosY()-4);
					}

				}
				//Making the ghost follow pacman and move at a normal speed when a normal more is selected 
				else{
					if(pac1.getPosX()>blueGhost.getPosX()){
						blueGhost.setPosX(blueGhost.getPosX()+2);
					}
					else{
						blueGhost.setPosX(blueGhost.getPosX()-2);
					}
					if(pac1.getPosY()>blueGhost.getPosY()){
						blueGhost.setPosY(blueGhost.getPosY()+2);
					}
					else{
						blueGhost.setPosY(blueGhost.getPosY()-2);
					}
				}
				
	}
	/**
	 * Returning the the id of the Play method to the Game class 
	 */
	public int getID() {
		return 1;
	}

}
