package com.nishu.voxel.geom;

import static org.lwjgl.opengl.GL11.*;

public class Shape {

	float texSize = 0.125f;
	
	int sx, sy, sz;

	public void createCube(float x, float y, float z, float size, float u, float v) {
		// bottom face
		glTexCoord2f(u, v);
		glVertex3f(x, y, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y, z);

		// top face
		glTexCoord2f(u, v);
		glVertex3f(x, y + size, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z + size);

		// front face
		glTexCoord2f(u, v);
		glVertex3f(x, y, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z);

		// back face
		glTexCoord2f(u, v);
		glVertex3f(x, y + size, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y, z + size);

		// left face
		glTexCoord2f(u, v);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x + size, y + size, z);

		// right face
		glTexCoord2f(u, v);
		glVertex3f(x, y, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x, y, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x, y + size, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z + size);
	}

	public void createCube(float x, float y, float z, float size) {
		// bottom face
		glColor4f(0, 0, 0, 0);
		glVertex3f(x, y, z + size);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x + size, y, z);
		glVertex3f(x, y, z);

		// top face
		glColor4f(0, 0, 0, 0);
		glVertex3f(x, y + size, z);
		glVertex3f(x + size, y + size, z);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x, y + size, z + size);

		// front face
		glColor4f(0, 0, 0, 0);
		glVertex3f(x, y, z);
		glVertex3f(x + size, y, z);
		glVertex3f(x + size, y + size, z);
		glVertex3f(x, y + size, z);

		// back face
		glColor4f(0, 0, 0, 0);
		glVertex3f(x, y + size, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x, y, z + size);

		// left face
		glColor4f(0, 0, 0, 0);
		glVertex3f(x + size, y, z);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y + size, z);

		// right face
		glColor4f(0, 0, 0, 0);
		glVertex3f(x, y, z + size);
		glVertex3f(x, y, z);
		glVertex3f(x, y + size, z);
		glVertex3f(x, y + size, z + size);
	}

	public void createWireFrameCube(double xx, double yy, double zz, int size) {
		int x = (int) xx;
		int y = (int) yy;
		int z = (int) zz;
		
		setSx(x);
		setSy(y);
		setSz(z);
		
		// bottom face
		glVertex3f(x, y, z + size);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x + size, y, z);
		glVertex3f(x, y, z);

		// top face
		glVertex3f(x, y + size, z);
		glVertex3f(x + size, y + size, z);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x, y + size, z + size);

		// front face
		glVertex3f(x, y, z);
		glVertex3f(x + size, y, z);
		glVertex3f(x + size, y + size, z);
		glVertex3f(x, y + size, z);

		// back face
		glVertex3f(x, y + size, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x, y, z + size);

		// left face
		glVertex3f(x + size, y, z);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y + size, z);

		// right face
		glVertex3f(x, y, z + size);
		glVertex3f(x, y, z);
		glVertex3f(x, y + size, z);
		glVertex3f(x, y + size, z + size);
	}

	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public int getSz() {
		return sz;
	}

	public void setSz(int sz) {
		this.sz = sz;
	}

}
