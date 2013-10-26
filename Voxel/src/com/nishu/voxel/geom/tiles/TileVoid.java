package com.nishu.voxel.geom.tiles;

import com.nishu.voxel.graphics.Sprite;

public class TileVoid extends Tile{

	public TileVoid() {
		super(Sprite.Sprite_Void);
	}

	@Override
	public String getType() {
		return "Void";
	}

}
