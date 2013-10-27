package com.nishu.voxel.geom.tiles;

public class TileVoid extends Tile {

	public TileVoid() {
	}

	@Override
	public String getType() {
		return "Void";
	}

	public boolean isTransparent() {
		return false;
	}

}
