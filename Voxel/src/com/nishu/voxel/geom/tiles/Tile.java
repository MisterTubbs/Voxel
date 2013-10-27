package com.nishu.voxel.geom.tiles;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.geom.Shape;
import com.nishu.voxel.math.AABB;

public abstract class Tile {
	
	Shape shape;
	AABB box;
	
	public static final Tile Grass = new TileGrass(); 
	public static final Tile Stone = new TileStone();
	public static final Tile Void = new TileVoid(); 
	public static final Tile Air = new TileAir();

	public Tile(){
		shape = new Shape();
		box = new AABB(1, 1, 1);
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
	
	public boolean isTransparent(){
		return false;
	}
	
	public abstract String getType();

}
