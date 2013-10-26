package com.nishu.voxel.geom.tiles;

public class TileGrass extends Tile {

	public TileGrass() {
		super();
	}

	@Override
	public String getType() {
		return "Grass";
	}

	public boolean isTransparent() {
		return false;
	}

}
