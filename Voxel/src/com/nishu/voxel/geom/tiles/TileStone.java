package com.nishu.voxel.geom.tiles;

public class TileStone extends Tile{
	
	public TileStone(){
	}

	public boolean isTransparent(){
		return false;
	}

	@Override
	public byte getID() {
		return 3;
	}

}
