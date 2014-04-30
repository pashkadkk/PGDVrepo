package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.lwjgl.util.vector.Vector2f;

import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;
import dk.aau.oose.Zombie;



public class Plant extends GameElement  {
	
	public int amountOfLives=5;
	public Life[] health;
	public int totalSuns=405; // 405
	public int points=0;
	public int speed = 2;
	public boolean ateCherry=false;
	public long timerAteCherry=0;
	public  float initialX;
	public  float initialY;
	public EndScreen gameEnded=new EndScreen ();
	public EndScreen gameWon= new EndScreen ();
	public Maze lvl= new Maze();
	public Congratz congratulations=new Congratz (400, 300);
	
	
	
	public Plant() throws SlickException {
		super(new Image ("assets/Plant.png"));
		position = new Vector2f(GameWorld.getGameContainer().getWidth()-100,GameWorld.getGameContainer().getHeight()-20);
		size=new Vector2f(9,9);
		
		lvl.buildMaze();
		this.initialX=position.x;
		this.initialY=position.y;
		health= new Life[amountOfLives];
	
		
		for (int i=0;i<amountOfLives;i++)
		{	
			health[i]=new Life();
			health[i].position.x=GameWorld.getGameContainer().getWidth()-55;
			health[i].position.y=100-(i*18);
	
		}
		for(int i=0;i<amountOfLives;i++)
		  GameWorld.add(health[i]);
		
	}

	@Override
	public void update(){
	
		movement ();
		controlPower();
		System.out.println(points);
		for (GameElement g: GameWorld.getGameObjects())
			if (g.interacts(this) && g instanceof Zombie)
				if (fight((Zombie)g))
					g.destroy();
		for (GameElement g: GameWorld.getGameObjects())
			if (g.interacts(this) && g instanceof SuperZombie)
				if (fightSuper((SuperZombie)g))
					g.destroy();
		if (this.amountOfLives<0) 
		{this.destroy(); 
;
		}
		if (this.totalSuns==0)
		{  lvl.updateMaze();
		  GameWorld.add(congratulations);
		}
		
				
	}
	
	private boolean isColliding(Class c){
		for (GameElement g: GameWorld.getGameObjects())
			if (g != this && c.isInstance(g) && g.interacts(this))
				return true;
		return false;
	}
	
	public void movement () {
		
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_LEFT)) 
			if (position.x > 0)
				{position.x-=speed;
				 if (isColliding(Wall.class)) position.x+=speed;
				}
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_RIGHT)) 
			if (position.x< GameWorld.getGameContainer().getWidth() && !isColliding(Wall.class))
				{position.x+=speed;
				if (isColliding(Wall.class)) position.x-=speed;
				}
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_UP)) 
			if (position.y> 0 && !isColliding(Wall.class))
			   {position.y-=speed;
			   if (isColliding(Wall.class)) position.y+=speed;
			   }
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_DOWN)) 
			if (position.y < GameWorld.getGameContainer().getHeight() && !isColliding(Wall.class) )
				{position.y+=speed;
				if (isColliding(Wall.class)) position.y-=speed;
				}
	}

	public boolean fight(Zombie zombie){
		
		if (ateCherry==true) { 
		
			points+=zombie.fightPoints;
			return true;
		}
		 
		else { 
				this.health[amountOfLives-1].lifeChanged(amountOfLives-1, health);
				this.amountOfLives--;
				this.position.x=initialX;
				this.position.y=initialY;
				
				
		}		
		return false;
	}
public boolean fightSuper(SuperZombie superzombie){
		
		if (ateCherry==true) { 
		
			points+=superzombie.amountOfPoints;
			return true;
		}
		 
		else { 
				this.health[amountOfLives-1].lifeChanged(amountOfLives-1, health);
				this.amountOfLives--;
				this.position.x=initialX;
				this.position.y=initialY;
				
				
		}		
		return false;
	}
	public void controlPower (){
		if (ateCherry==true ) 
		
				if (System.currentTimeMillis()-timerAteCherry>10000)
						{ateCherry=false;
						}
	}

	
}
