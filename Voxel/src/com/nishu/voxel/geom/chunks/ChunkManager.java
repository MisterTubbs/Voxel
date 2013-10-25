package com.nishu.voxel.geom.chunks;

import com.nishu.voxel.entity.MobManager;
import com.nishu.voxel.utilities.GameObject;

public class ChunkManager implements GameObject {

	private Chunk[][][] chunksPlayer;
	private Chunk c;
	private MobManager mobManager;
	private int px, py, pz;

	public ChunkManager(MobManager mobManager) {
		this.mobManager = mobManager;
		init();
	}

	@Override
	public void init() {
		px = (int) mobManager.getP().getPosition().x;
		py = (int) mobManager.getP().getPosition().y;
		pz = (int) mobManager.getP().getPosition().z;

		//chunksPlayer = new Chunk[px + 32][py + 32][pz + 32];
		c = new Chunk(px, py, pz);

		/*for (int x = px; x < px + 32; x++) {
			for (int y = py; y < py + 32; y++) {
				for (int z = pz; z < pz + 32; z++) {
					chunksPlayer[x / 16][y / 16][z / 16] = new Chunk(x / 16, y / 16, z / 16);
				}
			}
		}*/
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		c.render();
		/*for (int x = px; x < px + 32; x++) {
			for (int y = py; y < py + 32; y++) {
				for (int z = pz; z < pz + 32; z++) {
					chunksPlayer[x / 16][y / 16][z / 16].render();
				}
			}
		}*/
	}

	@Override
	public void dispose() {
	}

}
