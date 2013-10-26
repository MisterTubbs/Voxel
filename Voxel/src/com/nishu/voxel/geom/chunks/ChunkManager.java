package com.nishu.voxel.geom.chunks;

import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.utilities.GameObject;

public class ChunkManager implements GameObject {

	private Chunk[][][] chunksPlayer;
	private Spritesheet spritesheet;

	public ChunkManager(Spritesheet spritesheet) {
		this.spritesheet = spritesheet;
		init();
	}

	@Override
	public void init() {
		chunksPlayer = new Chunk[6][6][6];
		
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				for(int z = 0; z < 6; z++){
					chunksPlayer[x][y][z] = new Chunk(spritesheet, x + 16, y, z + 16);
				}
			}
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				for(int z = 0; z < 6; z++){
					chunksPlayer[x][y][z].render();
				}
			}
		}
	}

	@Override
	public void dispose() {
	}
}
