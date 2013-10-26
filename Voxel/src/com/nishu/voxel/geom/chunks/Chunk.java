package com.nishu.voxel.geom.chunks;

import static org.lwjgl.opengl.GL11.*;

import java.nio.IntBuffer;
import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.geom.tiles.Tile;
import com.nishu.voxel.geom.tiles.TileGrass;
import com.nishu.voxel.geom.tiles.TileWater;
import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.utilities.GameObject;

public class Chunk implements GameObject {

	private int sx, sy, sz, lx, ly, lz, opaqueID, transID;
	private IntBuffer oID;
	private Tile[][][] tiles;
	private Tile[][][] transparent;
	private Spritesheet spritesheet;

	Random rand;

	public Chunk(Spritesheet spritesheet, int sx, int sy, int sz) {
		this.sx = sx;
		this.sy = sy;
		this.sz = sz;
		this.lx = sx + 16;
		this.ly = sy + 16;
		this.lz = sz + 16;

		this.spritesheet = spritesheet;

		init();
	}

	@Override
	public void init() {
		rand = new Random();

		this.tiles = new Tile[lx][ly][lz];
		this.transparent = new Tile[lx][ly][lz];

		Tile[][][] temp = new Tile[lx][ly][lz];

		opaqueID = glGenLists(1);
		transID = glGenLists(2);

		IntBuffer oID = IntBuffer.allocate(opaqueID);
		
		for (int x = sx; x < lx; x++) {
			for (int y = sy; y < ly; y++) {
				for (int z = sz; z < lz; z++) {
					if (rand.nextInt(10) == 0) {
						transparent[x][y][z] = new TileWater();
						temp[x][y][z] = transparent[x][y][z];
					} else {
						tiles[x][y][z] = new TileGrass();
						temp[x][y][z] = tiles[x][y][z];
					}
				}
			}
		}
		rebuild(temp);
	}

	public void rebuild(Tile[][][] temp) {
		glNewList(opaqueID, GL_COMPILE);
		for (int x = sx; x < lx; x++) {
			for (int y = sy; y < ly; y++) {
				for (int z = sz; z < lz; z++) {
					if (checkCube(x, y, z, temp)) {
						if (temp[x][y][z].isTransparent())
							transparent[x][y][z].getVertices(x, y, z, 1, spritesheet.getTextureCoordsX(transparent[x][y][z].getType()), spritesheet.getTextureCoordsY((transparent[x][y][z].getType())));
						else
							tiles[x][y][z].getVertices(x, y, z, 1, spritesheet.getTextureCoordsX(tiles[x][y][z].getType()), spritesheet.getTextureCoordsY((tiles[x][y][z].getType())));
					}
				}
			}
		}
		glEndList();
		spritesheet.bind();
	}

	private boolean checkCube(int x, int y, int z, Tile[][][] temp) {
		// boolean array for faces. true is hidden false is not
		boolean faces[] = new boolean[6];
		if (x > sx) {
			if (temp[x - 1][y][z] instanceof Tile && !temp[x - 1][y][z].isTransparent()) {
				faces[0] = true;
			} else {
				faces[0] = false;
			}
		} else {
			faces[0] = false;
		}
		if (x < lx - 1) {
			if (temp[x + 1][y][z] instanceof Tile && !temp[x + 1][y][z].isTransparent()) {
				faces[1] = true;
			} else {
				faces[1] = false;
			}
		} else {
			faces[1] = false;
		}

		if (y > sy) {
			if (temp[x][y - 1][z] instanceof Tile && !temp[x][y - 1][z].isTransparent()) {
				faces[2] = true;
			} else {
				faces[2] = false;
			}
		} else {
			faces[2] = false;
		}
		if (y < ly - 1) {
			if (temp[x][y + 1][z] instanceof Tile && !temp[x][y + 1][z].isTransparent()) {
				faces[3] = true;
			} else {
				faces[3] = false;
			}
		} else {
			faces[3] = false;
		}

		if (z > sz) {
			if (temp[x][y][z - 1] instanceof Tile && !temp[x][y][z - 1].isTransparent()) {
				faces[4] = true;
			} else {
				faces[4] = false;
			}
		} else {
			faces[4] = false;
		}
		if (z < lz - 1) {
			if (temp[x][y][z + 1] instanceof Tile && !temp[x][y][z + 1].isTransparent()) {
				faces[5] = true;
			} else {
				faces[5] = false;
			}
		} else {
			faces[5] = false;
		}
		boolean shouldRender = faces[0] && faces[1] && faces[2] && faces[3] && faces[4] && faces[5];
		if (!shouldRender) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		glCallList(oID.get());
		if (transparent.length != -1) {
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			glCallList(transID);
		}
	}

	@Override
	public void dispose() {
	}

	public Tile[][][] getTiles() {
		return tiles;
	}

	public Vector3f getMinChunk() {
		return new Vector3f(sx, sy, sz);
	}

	public Vector3f getMaxChunk() {
		return new Vector3f(lx, ly, lz);
	}

}
