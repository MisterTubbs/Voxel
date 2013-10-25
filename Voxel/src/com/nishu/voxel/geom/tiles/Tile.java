package com.nishu.voxel.geom.tiles;

import com.nishu.voxel.geom.Shape;
import com.nishu.voxel.graphics.Texture;
import com.nishu.voxel.math.AABB;

public class Tile {
	
	Shape shape;
	Texture texture;
	AABB box;

	public Tile(float x, float y, float z, String type){
		shape = new Shape();
		texture = Texture.loadTexture(type);
		box = new AABB(x, y, z);
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
