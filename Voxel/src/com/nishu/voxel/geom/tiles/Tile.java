package com.nishu.voxel.geom.tiles;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.geom.Shape;
import com.nishu.voxel.graphics.Sprite;
import com.nishu.voxel.math.AABB;

public abstract class Tile {
	
	Shape shape;
	AABB box;
	Sprite sprite;
	
	public static final Tile Grass = new TileGrass(); 
	public static final Tile Void = new TileVoid(); 

	public Tile(Sprite sprite){
		shape = new Shape();
		this.sprite = sprite;
	}
	
	public void render(){
		sprite.bind();
	}

	public void update() {
	}

	public void dispose() {
	}
	
	public void getVertices(float x, float y, float z, float size, float u, float v){
		shape.createCube(x, y, z, size, u, v);
	}

	public AABB getBox() {
		return box;
	}

	public void setBox(AABB box) {
		this.box = box;
	}
	
	public void setBox(float x, float y, float z){
		this.box = new AABB(x, y, z);
		box.update(new Vector3f(x, y, z));
	}
	
	public abstract String getType();

}
