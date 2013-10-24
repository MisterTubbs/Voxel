package com.nishu.voxel.geom;

import com.nishu.voxel.graphics.Texture;

public class Tile {
	
	Shape shape;
	Texture texture;

	public Tile(){
		shape = new Shape();
	}
	
	public void render(){
		texture.bind();
	}

	public void update() {
	}

	public void dispose() {
	}
	
	public void getVertices(float x, float y, float z, float size){
		shape.createCube(x, y, z, size);
	}

}
