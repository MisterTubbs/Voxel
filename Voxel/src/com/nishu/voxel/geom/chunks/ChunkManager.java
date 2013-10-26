package com.nishu.voxel.geom.chunks;

import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.utilities.GameObject;

public class ChunkManager implements GameObject {

	private Chunk[] chunks;
	private Spritesheet spritesheet;

	public ChunkManager(Spritesheet spritesheet) {
		this.spritesheet = spritesheet;
		init();
	}

	@Override
	public void init() {
		chunks = new Chunk[175];

		for (int i = 0; i < chunks.length; i++) {
			chunks[i] = new Chunk(spritesheet, i, i, i);
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		for (int i = 0; i < chunks.length; i++) {
			chunks[i].render();
		}
	}

	@Override
	public void dispose() {
	}
}
