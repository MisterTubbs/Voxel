package com.nishu.voxel.geom;

import static org.lwjgl.opengl.GL11.*;

public class Shape {
	
	float texSize = 0.125f;
	
	public void createCube(float x, float y, float z, float size, float u, float v){
		glBegin(GL_QUADS);
		
		//bottom face
		glTexCoord2f(u, v);
		glVertex3f(x, y, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y, z);
		
		//top face
		glTexCoord2f(u, v);
		glVertex3f(x, y + size, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z + size);
		
		//front face
		glTexCoord2f(u, v);
		glVertex3f(x, y, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y + size, z);

		//back face
		glTexCoord2f(u, v);
		glVertex3f(x, y + size, z + size);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x, y, z + size);
		
		//left face
		glTexCoord2f(u, v);
		glVertex3f(x + size, y, z);
		glTexCoord2f(u + texSize, v);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(u + texSize, v + texSize);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(u, v + texSize);
		glVertex3f(x + size, y + size, z);

		//right face
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
	
	public void createCube(float x, float y, float z, float size){
		glBegin(GL_QUADS);
		
		//bottom face
		glVertex3f(x, y, z + size);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x + size, y, z);
		glVertex3f(x, y, z);
		
		//top face
		glVertex3f(x, y + size, z);
		glVertex3f(x + size, y + size, z);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x, y + size, z + size);
		
		//front face
		glVertex3f(x, y, z);
		glVertex3f(x + size, y, z);
		glVertex3f(x + size, y + size, z);
		glVertex3f(x, y + size, z);

		//back face
		glVertex3f(x, y + size, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x, y, z + size);
		
		//left face
		glVertex3f(x + size, y, z);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y + size, z);

		//right face
		glVertex3f(x, y, z + size);
		glVertex3f(x, y, z);
		glVertex3f(x, y + size, z);
		glVertex3f(x, y + size, z + size);

		glEnd();
	}
	
	public void createWireFrameCube(int x, int y, int z, int size){
		glBegin(GL_LINES);

		glEnd();
	}

}
