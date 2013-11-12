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
	public static final Tile Water = new TileWater();

	public Tile(){
		shape = new Shape();
		box = new AABB(1, 1, 1);
	}
	
	public void update() {
	}

	public void dispose() {
	}
	
	public abstract byte getID();
	
	public static Tile getTile(byte id){
		switch(id){
		case 0:
			return Tile.Void;
		case 1:
			return Tile.Air;
		case 2:
			return Tile.Grass;
		case 3:
			return Tile.Stone;
		case 4:
			return Tile.Water;
		}
		return Tile.Air;
	}
	
	public void getVertices(float x, float y, float z, float size, float u, float v){
		shape.createCube(x, y, z, size, u, v);
	}
	
	public void getVertices(float x, float y, float z, float size){
		shape.createCube(x, y, z, size);
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
}
