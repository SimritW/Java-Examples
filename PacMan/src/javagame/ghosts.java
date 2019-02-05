package javagame;
//Importing the right utilities needed
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ghosts extends Character{

	/**
	 * Drawing the ghost
	 */
	public void draw (Graphics g){
		g.setColor(Color.blue);	//seting the colour of the ghost
		g.fillOval(this.posX, this.posY, this.width, this.height);	//drawing the ghost
		
	}


}
