package com.nishu.voxel.graphics;

public class Spritesheet {
	
	private Texture sheet;
	
	public Spritesheet(String sheet){
		this.sheet = Texture.loadTexture(sheet);
	}
	
	public float getTextureCoordsX(String texture){
		switch(texture){
		case "Void":
			return 0;
		case "Grass":
			return 0.125f;
		case "Water":
			return 0.25f;
		case "Stone":
			return 0.375f;
		}
		return 0;		
	}
	
	public float getTextureCoordsY(String texture){
		switch(texture){
		case "Void":
			return 0;
		case "Grass":
			return 0;
		case "Water":
			return 0;
		case "Stone":
			return 0;
		}
		return 0;		
	}
	
	public void bind(){
		sheet.bind();
	}

}
