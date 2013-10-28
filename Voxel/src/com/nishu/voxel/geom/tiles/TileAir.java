package com.nishu.voxel.geom.tiles;

public class TileAir extends Tile{
	
	public TileAir(){
	}
	
	public boolean isTransparent() {
		return true;
	}

	@Override
	public byte getID() {
		return 1;
	}

}
