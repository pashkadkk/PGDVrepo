package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.lwjgl.util.vector.Vector2f;

import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;
import dk.aau.oose.Zombie.Direction;


public class SuperZombie extends GameElement implements EnemiesWithDirectionalLoop {
	public int amountOfPoints=100;
   	public dk.aau.oose.Zombie.Direction startingDirection=dk.aau.oose.Zombie.Direction.UP;
   	
	public SuperZombie() throws SlickException {
		super(new Image ("assets/superzombie.png"));
		position = new Vector2f(15,15);
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
						this.position.y+=k;
						if (isInteracting(Wall.class))
							this.position.y-=k;
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
			break;
		case RIGHT:
			this.position.x+=1;
			if (isInteracting(Wall.class))
				{this.position.x-=1;
				startingDirection=directions();}
			break;
		case UP:
			this.position.y-=1;
			if (isInteracting(Wall.class))
				{this.position.y+=1;
				startingDirection=directions();}
			break;
		case DOWN:
			this.position.y+=1;
			if (isInteracting(Wall.class))
				{this.position.y-=1;
				startingDirection=directions();}
			break;
		
		}
	}
	
	public void update() {
		
		directionLoop(startingDirection);
		for(GameElement ge: GameWorld.getGameObjects()){
		if( ge instanceof Plant)
		directionFunction(ge.position.x, ge.position.y);}
		
	}
	
	private boolean isInteracting(Class c){
		for (GameElement g: GameWorld.getGameObjects())
			if (g != this && c.isInstance(g) && g.interacts(this))
				return true;
		return false;
	}
	
	@Override
	public Direction directions() {
		double dir=Math.random();
		if (dir<=0.25) return Direction.LEFT;
		else if (dir<=0.5) return Direction.RIGHT;
			else if (dir<=0.75) return Direction.DOWN;
			else return Direction.UP;
		
	}
}
