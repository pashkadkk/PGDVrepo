package dk.aau.oose;
 import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dk.aau.oose.Plant;
import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;
 
public class Life extends GameElement {
	public int size=13;
	public Life() throws SlickException {
		super(new Image ("assets/L.png"));
		position=new Vector2f();
		
		// TODO Auto-generated constructor stub
	}
	public void lifeChanged (int lostLife, Life [] life){
	life[lostLife].destroy();	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
}
