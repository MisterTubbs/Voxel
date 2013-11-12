package com.nishu.voxel.entity;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.geom.tiles.Tile;
import com.nishu.voxel.utilities.GameObject;

public class Mob extends Entity implements GameObject{
	
	private Tile forward, back, up, down, left, right;
	private Vector3f newPosition;
	private boolean isDead;
	private Tile[][][] tiles;
	private boolean hasMoved;
	
	public Mob(float x, float y, float z) {
		super(x, y, z, 0, 0);
		this.newPosition = new Vector3f(x, y, z);
		init();
	}
	
	public Mob(float x, float y, float z, float rotx, float roty) {
		super(x, y, z, rotx, roty);
		this.newPosition = new Vector3f(x, y, z);
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

	public Tile getForward() {
		return forward;
	}

	public void setForward(Tile forward) {
		this.forward = forward;
	}

	public Tile getBack() {
		return back;
	}

	public void setBack(Tile back) {
		this.back = back;
	}

	public Tile[][][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][][] tiles) {
		this.tiles = tiles;
	}

	public Vector3f getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(Vector3f newPosition) {
		this.newPosition = newPosition;
	}
	
	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
