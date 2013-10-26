package com.nishu.voxel.graphics;

public class Sprite {
	
	Texture texture;
	
	public static final Sprite Sprite_Grass = new Sprite("grass.jpg");
	public static final Sprite Sprite_Void = new Sprite("void.png");
	
	public Sprite(String type){
		texture = Texture.loadTexture(type);
	}
	
	public void bind(){
		texture.bind();
	}

}
