package com.nishu.voxel.geom.chunks;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.utilities.GameObject;

public class ChunkManager implements GameObject {

	private Chunk[][][] chunks;
	private Spritesheet spritesheet;

	public ChunkManager(Spritesheet spritesheet) {
		this.spritesheet = spritesheet;
		init();
	}

	@Override
	public void init() {
		chunks = new Chunk[10][2][10];

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 2; y++) {
				for (int z = 0; z < 10; z++) {
					chunks[x][y][z] = new Chunk(spritesheet, new Vector3f(x * 16, y * 16, z * 16));
				}
			}
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 2; y++) {
				for (int z = 0; z < 10; z++) {
					chunks[x][y][z].render();
				}
			}
		}
	}

	@Override
	public void dispose() {
	}
}