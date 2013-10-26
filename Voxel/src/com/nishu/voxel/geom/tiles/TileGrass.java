package com.nishu.voxel.geom.tiles;

import com.nishu.voxel.graphics.Sprite;

public class TileGrass extends Tile{

	public TileGrass() {
		super(Sprite.Sprite_Grass);
	}

	@Override
	public String getType() {
		return "Grass";
	}

}
