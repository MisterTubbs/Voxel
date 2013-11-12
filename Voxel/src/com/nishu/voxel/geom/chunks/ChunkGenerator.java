package com.nishu.voxel.geom.chunks;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.graphics.Spritesheet;

public class ChunkGenerator {

	ChunkCache cache;

	public ChunkGenerator() {
		this.cache = new ChunkCache();
	}

	public Chunk generateChunk(Spritesheet sheet, Vector3f pos, int id) {
		Chunk c = null;
		if (id == 0) {
			c = generateAirChunk(sheet, pos);
		}
		if (id == 1) {
			c = generateMixedChunk(sheet, pos);
		}
		return c;
	}

	private Chunk generateAirChunk(Spritesheet sheet, Vector3f pos) {
		if (cache.getChunk(pos) != null) {
			return cache.getChunk(pos);
		} else {
			return new Chunk(sheet, pos, 0);
		}
	}

	private Chunk generateMixedChunk(Spritesheet sheet, Vector3f pos) {
		if (cache.getChunk(pos) != null) {
			return cache.getChunk(pos);
		} else {
			return new Chunk(sheet, pos, 1);
		}
	}

	public ChunkCache getCache() {
		return cache;
	}
}
