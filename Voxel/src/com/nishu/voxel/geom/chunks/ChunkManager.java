package com.nishu.voxel.geom.chunks;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.entity.MobManager;
import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.math.Frustum;
import com.nishu.voxel.utilities.GameObject;

public class ChunkManager implements GameObject {

	private Spritesheet spritesheet;
	private MobManager mobManager;
	private ChunkGenerator chunkGenerator;

	private Chunk[][][] chunks;
	private ArrayList<Chunk> currentChunks;

	private int cx = 20, cy = 5, cz = 20;

	Random rand;

	public ChunkManager(Spritesheet spritesheet) {
		this.spritesheet = spritesheet;
		this.chunkGenerator = new ChunkGenerator();

		rand = new Random();

		init();
	}
	
	public void setMobManager(MobManager mobManager){
		this.mobManager = mobManager;
	}

	@Override
	public void init() {
		chunks = new Chunk[cx][cy][cz];
		currentChunks = new ArrayList<Chunk>();

		for (int x = 0; x < cx; x++) {
			for (int y = 0; y < cy; y++) {
				for (int z = 0; z < cz; z++) {
					chunks[x][y][z] = chunkGenerator.generateChunk(spritesheet, new Vector3f(x * 16, y * 16, z * 16), 1);
					if(y == 3){
						chunks[x][y][z] = chunkGenerator.generateChunk(spritesheet, new Vector3f(x * 16, y * 16, z * 16), 0);
					}
					currentChunks.add(chunks[x][y][z]);
				}
			}
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		Frustum frustum = Frustum.getFrustum();
		for (int i = 0; i < currentChunks.size(); i++) {
			if (frustum.cubeInFrustum(currentChunks.get(i).getMinChunkSize().x, currentChunks.get(i).getMinChunkSize().y, currentChunks.get(i).getMinChunkSize().z, currentChunks.get(i).getMaxChunkSize().x, currentChunks.get(i).getMaxChunkSize().y, currentChunks.get(i).getMaxChunkSize().z)) {
				if (currentChunks.get(i) != null && Math.abs(currentChunks.get(i).getCenterPos().x - (int) -mobManager.getP().getPosition().x) < 32 && currentChunks.get(i) != null && Math.abs(currentChunks.get(i).getCenterPos().z - (int) -mobManager.getP().getPosition().z) < 32 && currentChunks.get(i) != null && Math.abs(currentChunks.get(i).getCenterPos().y - (int) -mobManager.getP().getPosition().y) < 16) {
					if(currentChunks.get(i).getType() != 0){
						currentChunks.get(i).render();
					}
				}else{
					if(currentChunks.get(i) == null){
						//if()
					}
				}
			}else{
				//currentChunks.remove(currentChunks.get(i));
			}
		}
	}
	
	public Chunk lookupChunk(Vector3f pos){
		Chunk c = null;
		for(int i = 0; i < currentChunks.size(); i++){
			if(pos.x >= currentChunks.get(i).getMinChunkSize().x && pos.x <= currentChunks.get(i).getMaxChunkSize().x && pos.y >= currentChunks.get(i).getMinChunkSize().y && pos.y <= currentChunks.get(i).getMaxChunkSize().y && pos.z >= currentChunks.get(i).getMinChunkSize().z && pos.z <= currentChunks.get(i).getMaxChunkSize().z){
				c = currentChunks.get(i);
				return c;
			}
		}
		return null;
	}

	@Override
	public void dispose() {
	}
}