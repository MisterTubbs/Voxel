package com.nishu.voxel.geom.tiles;

public class TileWater extends Tile{

	public TileWater() {
		super();
	}
	
	@Override
	public String getType() {
		return "Water";
	}
	
	public boolean isTransparent(){
		return true;
	}

}
