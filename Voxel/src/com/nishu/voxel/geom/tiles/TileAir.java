package com.nishu.voxel.geom.tiles;

public class TileAir extends Tile{
	
	public TileAir(){
	}

	@Override
	public String getType() {
		return null;
	}
	
	public boolean isTransparent() {
		return true;
	}

}
