package com.nishu.voxel.entity;

import com.nishu.voxel.geom.tiles.Tile;
import com.nishu.voxel.utilities.GameObject;

public class Mob extends Entity implements GameObject{
	
	private Tile up, down, left, right;
	
	private boolean isDead;
	private Tile[][][] tiles;

	public Mob(float x, float y, float z) {
		super(x, y, z, 0, 0);
		init();
	}
	
	public Mob(float x, float y, float z, float rotx, float roty) {
		super(x, y, z, rotx, roty);
		init();
	}

	@Override
	public void init() {
		setDead(false);
	}

	public void update(Tile[][][] tiles) {
	}

	@Override
	public void render() {
	}

	@Override
	public void dispose() {
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public Tile getUp() {
		return up;
	}

	public void setUp(Tile up) {
		this.up = up;
	}

	public Tile getDown() {
		return down;
	}

	public void setDown(Tile down) {
		this.down = down;
	}

	public Tile getLeft() {
		return left;
	}

	public void setLeft(Tile left) {
		this.left = left;
	}

	public Tile getRight() {
		return right;
	}

	public void setRight(Tile right) {
		this.right = right;
	}

	public Tile[][][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][][] tiles) {
		this.tiles = tiles;
	}

	@Override
	public void update() {
	}

}
