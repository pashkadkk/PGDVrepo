package dk.aau.oose;


import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.SlickException;

import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;


public class Points extends GameElement {

 	public Points() throws SlickException{
 		super(null);
 		size=new Vector2f(100,500);
	}

	/**
	 * 
	 */
	
	public int totalPoints=0; // defines amount of totalpoints acquired
	private String text=""; // used to export amount of points ot the console
 	
 	public void updatePoints (int points){
 	  totalPoints+=points;
 	  text=Integer.toString(totalPoints); // if amount of points updates - a new amount of points is calculated and outputted to the console

 		
 	}
 	
 	@Override
	public void draw() {
		Graphics g=GameWorld.getGameContainer().getGraphics();
		g.setColor(Color.white);
		g.drawString(text, 100, 500); // tries to draw score into the screen, NEEDS TO BE FIXED
	}

	@Override
	public void update() {		
	}
 }
	
