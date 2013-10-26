package com.nishu.voxel.geom.chunks;

import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glNewList;

import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.geom.tiles.Tile;
import com.nishu.voxel.geom.tiles.TileGrass;
import com.nishu.voxel.geom.tiles.TileVoid;
import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.utilities.GameObject;

public class Chunk implements GameObject {

	private int sx, sy, sz, lx, ly, lz, vertID;

	private Tile[][][] tiles;
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
		vertID = glGenLists(1);

		for (int x = sx; x < lx; x++) {
			for (int y = sy; y < ly; y++) {
				for (int z = sz; z < lz; z++) {
					if (rand.nextInt(10) == 0) {
						tiles[x][y][z] = new TileVoid();
					} else {
						tiles[x][y][z] = new TileGrass();
					}
				}
			}
		}
		rebuild();
	}

	public void rebuild() {
		glNewList(vertID, GL_COMPILE);
		for (int x = sx; x < lx; x++) {
			for (int y = sy; y < ly; y++) {
				for (int z = sz; z < lz; z++) {
					if (checkCube(x, y, z)) {
						tiles[x][y][z].getVertices(x, y, z, 1, spritesheet.getTextureCoordsX(tiles[x][y][z].getType()), spritesheet.getTextureCoordsY((tiles[x][y][z].getType())));
					}
				}
			}
		}
		glEndList();
		spritesheet.bind();
	}

	private boolean checkCube(int x, int y, int z) {
		// boolean array for faces. true is hidden false is not
		boolean faces[] = new boolean[6];
		if (x > sx) {
			if (tiles[x - 1][y][z] instanceof Tile){
				faces[0] = true;
			}else{
				faces[0] = false;
			}
		} else {
			faces[0] = false;
		}
		if(x < lx - 1){
			if(tiles[x + 1][y][z] instanceof Tile) {
				faces[1] = true;
			}else{
				faces[1] = false;
			}
		}else{
			faces[1] = false;
		}
		
		if (y > sy) {
			if (tiles[x][y - 1][z] instanceof Tile){
				faces[2] = true;
			}else{
				faces[2] = false;
			}
		} else {
			faces[2] = false;
		}
		if(y < ly - 1){
			if(tiles[x][y + 1][z] instanceof Tile) {
				faces[3] = true;
			}else{
				faces[3] = false;
			}
		}else{
			faces[3] = false;
		}
		
		if (z > sz) {
			if (tiles[x][y][z - 1] instanceof Tile){
				faces[4] = true;
			}else{
				faces[4] = false;
			}
		} else {
			faces[4] = false;
		}
		if(z < lz - 1){
			if(tiles[x][y][z + 1] instanceof Tile) {
				faces[5] = true;
			}else{
				faces[5] = false;
			}
		}else{
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
		glCallList(vertID);
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
