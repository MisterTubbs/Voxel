package com.nishu.voxel.geom.chunks;

import static org.lwjgl.opengl.GL11.*;

import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.geom.tiles.Tile;
import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.utilities.GameObject;

public class Chunk implements GameObject {

	private int opaqueID, type;
	private Vector3f sPosition, lPosition;
	private byte[][][] tiles;
	private Spritesheet spritesheet;

	Random rand;

	public Chunk(Spritesheet spritesheet, Vector3f sPosition, int type) {
		this.sPosition = sPosition;
		this.lPosition = new Vector3f(sPosition.x + 16, sPosition.y + 16, sPosition.z + 16);
		this.type = type;

		this.spritesheet = spritesheet;

		init();
	}

	@Override
	public void init() {
		rand = new Random();

		opaqueID = glGenLists(1);

		tiles = new byte[(int) lPosition.x][(int) lPosition.y][(int) lPosition.z];

		genRandomWorld();
		rebuild();
	}

	public void genRandomWorld() {
		for (int x = (int) sPosition.x; x < (int) lPosition.x; x++) {
			for (int y = (int) sPosition.y; y < (int) lPosition.y; y++) {
				for (int z = (int) sPosition.z; z < (int) lPosition.z; z++) {
					if (type != 0) {
						tiles[x][y][z] = Tile.Grass.getID();
						if (y == 0) {
							tiles[x][y][z] = Tile.Water.getID();
						}
						if (y <= 8 && y > 1) {
							tiles[x][y][z] = Tile.Stone.getID();
						}
						if (x == lPosition.x || z == lPosition.z || x == sPosition.x || z == sPosition.z) {
							tiles[x][y][z] = Tile.Stone.getID();
						}
					}
				}
			}
		}
	}

	public void rebuild() {
		glNewList(opaqueID, GL_COMPILE);
		glBegin(GL_QUADS);
		for (int x = (int) sPosition.x; x < (int) lPosition.x; x++) {
			for (int y = (int) sPosition.y; y < (int) lPosition.y; y++) {
				for (int z = (int) sPosition.z; z < (int) lPosition.z; z++) {
					if (checkCubeHidden(x, y, z))
						// check if tiles hidden. if not, add vertices to
						// display list
						if (type != 0) {
							if(type == 3){
								System.out.println("true");
							}
							Tile.getTile(tiles[x][y][z]).getVertices(x, y, z, 1, spritesheet.getTextureCoordsX(tiles[x][y][z]), spritesheet.getTextureCoordsY(tiles[x][y][z]));
						} else {
							Tile.getTile(tiles[x][y][z]).getVertices(x, y, z, 1);
						}
				}
			}
		}
		glEnd();
		glEndList();
		spritesheet.bind();
	}

	private boolean checkCubeHidden(int x, int y, int z) {
		// boolean array for faces. true is hidden false is not
		boolean faces[] = new boolean[6];
		if (x > sPosition.x) {
			if (tiles[x - 1][y][z] != 0) {
				faces[0] = true;
			} else {
				faces[0] = false;
			}
		} else {
			faces[0] = false;
		}
		if (x < lPosition.x - 1) {
			if (tiles[x + 1][y][z] != 0) {
				faces[1] = true;
			} else {
				faces[1] = false;
			}
		} else {
			faces[1] = false;
		}

		if (y > sPosition.y) {
			if (tiles[x][y - 1][z] != 0) {
				faces[2] = true;
			} else {
				faces[2] = false;
			}
		} else {
			faces[2] = false;
		}
		if (y < lPosition.y - 1) {
			if (tiles[x][y + 1][z] != 0) {
				faces[3] = true;
			} else {
				faces[3] = false;
			}
		} else {
			faces[3] = false;
		}

		if (z > sPosition.z) {
			if (tiles[x][y][z - 1] != 0) {
				faces[4] = true;
			} else {
				faces[4] = false;
			}
		} else {
			faces[4] = false;
		}
		if (z < lPosition.z - 1) {
			if (tiles[x][y][z + 1] != 0) {
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
		if (tiles.length != -1) {
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			glCallList(opaqueID);
		}
	}

	@Override
	public void dispose() {
	}

	public byte[][][] getTiles() {
		return tiles;
	}

	public byte getTile(int x, int y, int z) {
		if (x > sPosition.x && x < lPosition.x && y > sPosition.y && y < lPosition.y && z > sPosition.z && z < lPosition.z) {
			return tiles[x][y][z];
		}
		return -1;
	}

	public void setTile(double xx, double yy, double zz, byte i) {
		int x = (int) xx;
		int y = (int) yy;
		int z = (int) zz;
		if (x > sPosition.x && x < lPosition.x && y > sPosition.y && y < lPosition.y && z > sPosition.z && z < lPosition.z) {
			tiles[x][y][z] = Tile.getTile(i).getID();
		}
	}

	public Vector3f getMinChunkSize() {
		return sPosition;
	}

	public Vector3f getMaxChunkSize() {
		return lPosition;
	}

	public Vector3f getCenterPos() {
		return new Vector3f(getMaxChunkSize().x - 8, getMaxChunkSize().y - 8, getMaxChunkSize().z - 8);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		if (type > 1)
			type = 1;
		this.type = type;
	}
}
