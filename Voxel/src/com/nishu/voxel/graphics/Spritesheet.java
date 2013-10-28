package com.nishu.voxel.graphics;

public class Spritesheet {
	
	private Texture sheet;
	
	public Spritesheet(String sheet){
		this.sheet = Texture.loadTexture(sheet);
	}
	
	public float getTextureCoordsX(byte id){
		switch(id){
		case 0:
			return 0;
		case 2:
			return 0.125f;
		case 4:
			return 0.25f;
		case 3:
			return 0.375f;
		}
		return 0;		
	}
	
	public float getTextureCoordsY(byte id){
		switch(id){
		case 0:
			return 0;
		case 2:
			return 0;
		case 4:
			return 0;
		case 3:
			return 0;
		}
		return 0;		
	}
	
	public void bind(){
		sheet.bind();
	}

}
