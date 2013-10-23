package com.nishu.voxel.entity;

import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.utilities.Input;

public class Player extends Mob{

	public Player(float x, float y, float z) {
		super(x, y, z);
	}
	
	public void init(){
		
	}
	
	public void update(){
		if(Input.getKeyDown(Keyboard.KEY_W)){
			this.setPosition(new Vector3f(this.getPosition().x, this.getPosition().y, (this.getPosition().z) += 0.5f));
		}
		
		if(Input.getKeyDown(Keyboard.KEY_S)){
			this.setPosition(new Vector3f(this.getPosition().x, this.getPosition().y, (this.getPosition().z) -= 0.5f));
		}
	}
	
	public void render(){
		glTranslatef(this.getPosition().x, this.getPosition().y, this.getPosition().z);
	}
	
	public void dipose(){
		
	}

}
