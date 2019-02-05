package javagame;
//Importing everthing nedded to creat a map
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class map {
	/**
	 * This method draws to the screen
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(Color.red);	//Setting the color of the map to red
		//Drawing the border 
		g.fillRect(0, 0, 1024, 5);
		g.fillRect(0,0, 5, 640);
		g.fillRect(1019,0, 5, 640);
		g.fillRect(0, 635, 1024, 5);

		//Drawing the Map
		g.fillRect(135,90,700,20);
		g.fillRect(135, 175, 20, 250);
		g.fillRect(135,500,700,20);
		g.fillRect(820, 175, 20, 250);
		g.fillRect(300, 250, 400, 20);
		g.fillRect(305, 350, 400, 20);
		
	}


}
