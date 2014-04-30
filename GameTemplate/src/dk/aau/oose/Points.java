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
 	
 		
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	
	public int totalPoints=0;
	private String text="";
 	
 	public void updatePoints (int points){
 	  totalPoints+=points;
 	  text=Integer.toString(totalPoints);

 		
 	}
 	
 	@Override
	public void draw() {
		Graphics g=GameWorld.getGameContainer().getGraphics();
		g.setColor(Color.white);
		g.drawString(text, 100, 500);	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
 }
	
