package com.nishu.voxel.geom;

import com.nishu.voxel.utilities.GameObject;

public class Chunk implements GameObject{
	
	private int sx, sy, sz, lx, ly, lz, vertID;

	public Chunk(int sx, int sy, int sz, int lx, int ly, int lz) {
		this.sx = sx;
		this.sy = sy;
		this.sz = sz;
		this.lx = sx + 16;
		this.ly = sy + 16;
		this.lz = sz + 16;
	}

	@Override
	public void init() {
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

}
