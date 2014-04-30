package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.lwjgl.util.vector.Vector2f;

import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;
import dk.aau.oose.Plant;
import dk.aau.oose.Wall;

public class Zombie extends GameElement implements EnemiesWithDirectionalLoop {

	public int fightPoints=500;
   	public  enum Direction{LEFT, RIGHT, UP, DOWN};
   	public Direction startingDirection=Direction.UP;
	public Zombie() throws SlickException {
		super(new Image ("assets/zombie.png"));
		position = new Vector2f(0,0);
		// defines a sprite for zombie object
	size=new Vector2f(9,9);
	}
	
	@Override
	public void directionFunction(float targetX, float targetY){
		boolean foundTarget=false;
		for (int i=-20;i<=20;i++){
			for (int k=-20;k<=20;k++){
				if(this.position.x+i==targetX && this.position.y+k==targetY )
				{
					if(i!=0 && this.position.x+i!=1)
					{
						this.position.x+=i;
						if (isInteracting(Wall.class))
							this.position.x-=i; 
						// if there is a target nearby and no wall between zombie and a specified target X and Y - the zombie changes it's position
						this.position.y+=k;
						if (isInteracting(Wall.class))
							this.position.y-=k;
						// if there is a target nearby and no wall between zombie and a specified target X and Y - the zombie changes it's position
					}
				}
			
				}
			}
		
		}
	
	@Override
	public void directionLoop(Direction direction){
		switch (direction)
		{ case LEFT:
			this.position.x-=1;
			if (isInteracting(Wall.class))
				{this.position.x+=1;
				startingDirection=directions();}
			// change direction to the left if just has interacted with a wall
			break;
		case RIGHT:
			this.position.x+=1;
			if (isInteracting(Wall.class))
				{this.position.x-=1;
				startingDirection=directions();}
			// change direction to the right if just has interacted with a wall
			break;
		case UP:
			this.position.y-=1;
			if (isInteracting(Wall.class))
				{this.position.y+=1;
				startingDirection=directions();}
			// change direction to the up if just has interacted with a wall
			break;
		case DOWN:
			this.position.y+=1;
			if (isInteracting(Wall.class))
				{this.position.y-=1;
				startingDirection=directions();}
			// change direction to the down if just has interacted with a wall
			break;
		
		}
	}
	
	public void update() {
		
		directionLoop(startingDirection);
		for(GameElement ge: GameWorld.getGameObjects()){
		if( ge instanceof Plant)
		directionFunction(ge.position.x, ge.position.y);}
		// calls for a loop for changing the direction of zombie starting with 'startingdirection'. Later on it changes based on zombie location.
	}
	
	private boolean isInteracting(Class c){
		for (GameElement g: GameWorld.getGameObjects())
			if (g != this && c.isInstance(g) && g.interacts(this))
				return true;
		return false;
		// a function that is used to check whether object a interacts with object B or not and returns true/false statement as a result
	}
	
	@Override
	public Direction directions() {
		double dir=Math.random();
		if (dir<=0.25) return Direction.LEFT;
		else if (dir<=0.5) return Direction.RIGHT;
			else if (dir<=0.75) return Direction.DOWN;
			else return Direction.UP;
		// a function that is used to change a direction to a random one 25% as each direction change, since there are four of em(up/down/left/right)
	}
}



	