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
		chunks = new Chunk[50];

		for (int i = 0; i < chunks.length; i++) {
			chunks[i] = new Chunk(spritesheet, i + 16, 0, i + 16);
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
	
	public void rebuildChunk(){
		chunks[0].rebuild();
	}
	
	public Chunk lookUpChunk(float x, float y, float z){
		for(int i = 0; i < chunks.length; i++){
			if(x > chunks[i].getMinChunkSize().x && x < chunks[i].getMaxChunkSize().x && y > chunks[i].getMinChunkSize().y && y < chunks[i].getMaxChunkSize().y && z > chunks[i].getMinChunkSize().z && z < chunks[i].getMaxChunkSize().z){
				return chunks[i];
			}
		}
		return null;
	}

	public Chunk[] getChunks() {
		return chunks;
	}

	public void setChunks(Chunk[] chunks) {
		this.chunks = chunks;
	}
}
