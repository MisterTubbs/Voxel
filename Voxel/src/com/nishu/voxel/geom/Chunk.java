package com.nishu.voxel.geom;

import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glNewList;

import java.util.Random;

import com.nishu.voxel.utilities.GameObject;

public class Chunk implements GameObject {

	private int sx, sy, sz, lx, ly, lz, vertID;

	Random rand;

	private Tile[][][] tiles;

	public Chunk(int sx, int sy, int sz) {
		this.sx = sx;
		this.sy = sy;
		this.sz = sz;
		this.lx = sx + 16;
		this.ly = sy + 16;
		this.lz = sz + 16;

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
					if (rand.nextBoolean()) {
						tiles[x][y][z] = new Tile("grass.png");

					} else {
						tiles[x][y][z] = new Tile("grass.jpg");
					}
				}
			}
		}
	}

	public void rebuild() {
		glNewList(vertID, GL_COMPILE);
		for (int x = sx; x < lx; x++) {
			for (int y = sy; y < ly; y++) {
				for (int z = sz; z < lz; z++) {
					tiles[x][y][z].getVertices(x, y, z, 1);
				}
			}
		}
		glEndList();
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		for (int x = sx; x < lx; x++) {
			for (int y = sy; y < ly; y++) {
				for (int z = sz; z < lz; z++) {
					tiles[x][y][z].render();
				}
			}
		}
		glCallList(vertID);
	}

	@Override
	public void dispose() {
	}

}
