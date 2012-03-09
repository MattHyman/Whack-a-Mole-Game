/**
 * Name: Matthew Hyman
 *
 * Subclass of JButton that has two states, alive or dead. If dead the JButton's color is red and the Game class can't interact with it. 
 * If alive it is green and has a randomly determined life count that is decremented till it is eventually 0 hence killing the creature. While it is alive the Game class can let the player 
 * "whack" the creature generating points in Game and killing the creature
 * 
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Creature extends JButton{
	
	private static final int MIN_LIFE = 50;  
	private static final int MAX_LIFE = 300;  
	static Random rand = new Random(); //declare Random statically so it does not have to be re-initiated for each use 
	
	private boolean isAlive; //shows whether creature is alive or not 
	private int life_count; //shows how long the creature has currently been alive if applicable 
	private int final_life; //stores how long the creature will be alive for this life
	
	public Creature() {
		isAlive = false; 
		this.setBackground(Color.RED); 
		life_count = 0; 
		
	}
	
	//return whether the creature is alive or not 
	public boolean getIsAlive() {
		return isAlive; 
	}
	//Precondition: creature must be dead
	//set creature as being alive and determine its max_life(how long it will be alive) and change color to green
	public void revive() {
		if(!isAlive) {
			final_life = MIN_LIFE + rand.nextInt(MAX_LIFE - MIN_LIFE + 1); //set final life 
			isAlive = true; //set creature as being alive  
			this.setBackground(Color.GREEN); 
		}
		
		
	}
	
	//Precondition: creature must be alive 
	//set the creature as no longer being alive, change the background color back to being 
	//red, reset the life count, and decrement the game's creature alive count 
	public void kill() {
			isAlive = false;
			this.setBackground(Color.RED); 
			life_count = 0; 
			Game.creaturesAlive--; 
	}
	
	//if creature is alive increment its life_count and if the life count is equal to its max_life re_set it to being dead
	public void update() {
		if(isAlive) {
			life_count++; 
			
			//if life_count is equal to max_life kill the creature 
			if(life_count == final_life) 
				this.kill();
		}
	}
}