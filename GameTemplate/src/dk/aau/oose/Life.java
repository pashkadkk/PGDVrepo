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
		
		// defines a sprite, that represents an image for each life (shown a "LIFE" on top right of the screen)
	}
	public void lifeChanged (int lostLife, Life [] life){
	life[lostLife].destroy();	
	// if life is changed - one life should be substracted, thus destroyed from screen. This function destroys one life if required.
	}
	@Override
	public void update() {
	}
}
