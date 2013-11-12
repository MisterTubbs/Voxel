package com.nishu.voxel.geom.chunks;

import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

public class ChunkCache {

	ArrayList<Chunk> chunkCache = new ArrayList<Chunk>();
	
	public Chunk getChunk(Vector3f center){
		Chunk c = null;
		for(int i = 0; i < chunkCache.size(); i++){
			if(center.x == chunkCache.get(i).getCenterPos().x){
				if(center.y == chunkCache.get(i).getCenterPos().y){
					if(center.z == chunkCache.get(i).getCenterPos().z){
						c = chunkCache.get(i);
					}					
				}
			}
		}
		return c;
	}
	
	public void cacheChunk(Chunk c){
		chunkCache.add(c);
	}
	
	public Chunk lookupChunk(Vector3f pos){
		return null;
	}
	public boolean deleteChunk(Vector3f pos){
		return false;
	}
	
}
