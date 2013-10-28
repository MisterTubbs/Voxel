package com.nishu.voxel.geom.tiles;

public class TileWater extends Tile{

	public TileWater() {
		super();
	}

	public boolean isTransparent(){
		return true;
	}

	@Override
	public byte getID() {
		return 4;
	}

}
