package com.nishu.voxel.geom.tiles;

public class TileStone extends Tile{
	
	public TileStone(){
		
	}

	@Override
	public String getType() {
		return "Stone";
	}
	
	public boolean isTransparent(){
		return false;
	}

}
