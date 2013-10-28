package com.nishu.voxel.geom.tiles;

public class TileVoid extends Tile {

	public TileVoid() {
	}

	public boolean isTransparent() {
		return false;
	}

	@Override
	public byte getID() {
		return 0;
	}

}
