package com.nishu.voxel.entity;

import com.nishu.voxel.geom.tiles.Tile;
import com.nishu.voxel.utilities.GameObject;

public class Mob extends Entity implements GameObject{
	
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

	@Override
	public void update() {
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

}
