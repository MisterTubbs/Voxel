package com.nishu.voxel.geom;

import static org.lwjgl.opengl.GL11.*;

public class Shape {
	
	float texSize = 0.125f;
	
	public void createCube(float x, float y, float z, float size, float u, float v){
		glBegin(GL_QUADS);
		
		//bottom face
		glNormal3f(0.0f, -1.0f, 0.0f);
		glTexCoord2f(u, v);
		glVertex3f(x, y, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y, z);
		
		//top face
		glNormal3f(0.0f, 1.0f, 0.0f);
		glTexCoord2f(u, v);
		glVertex3f(x, y + size, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z + size);
		
		//front face
		glNormal3f(0.0f, 0.0f, 1.0f);
		glTexCoord2f(u, v);
		glVertex3f(x, y, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z);

		//back face
		glNormal3f(0.0f, 0.0f, -1.0f);
		glTexCoord2f(u, v);
		glVertex3f(x, y + size, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y, z + size);
		
		//left face
		glNormal3f(-1.0f, 0.0f, 0.0f);
		glTexCoord2f(u, v);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x + size, y + size, z);

		//right face
		glNormal3f(1.0f, 0.0f, 0.0f);
		glTexCoord2f(u, v);
		glVertex3f(x, y, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x, y, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x, y + size, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z + size);

		glEnd();
	}
	
	public void createWireFrameCube(int x, int y, int z, int size){
		glBegin(GL_LINES);

		glEnd();
	}

}
