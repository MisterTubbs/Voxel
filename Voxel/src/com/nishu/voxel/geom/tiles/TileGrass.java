package com.nishu.voxel.geom.tiles;

public class TileGrass extends Tile {

	public TileGrass() {
	}

	public boolean isTransparent() {
		return false;
	}
	
	@Override
	public byte getID() {
		return 2;
	}

}
