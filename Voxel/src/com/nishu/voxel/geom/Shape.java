package com.nishu.voxel.geom;

import static org.lwjgl.opengl.GL11.*;

public class Shape {
	
	public void createCube(float x, float y, float z, float size){
		glBegin(GL_QUADS);
		
		//bottom face
		//glColor3f(0, 0, 1);
		glTexCoord2f(0, 0);
		glVertex3f(x, y, z + size);
		glTexCoord2f(1, 0);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(0, 1);
		glVertex3f(x + size, y, z);
		glTexCoord2f(1, 1);
		glVertex3f(x, y, z);
		
		//top face
		//glColor3f(0, 1, 1);
		glTexCoord2f(0, 0);
		glVertex3f(x, y + size, z);
		glTexCoord2f(1, 0);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(0, 1);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(1, 1);
		glVertex3f(x, y + size, z + size);
		
		//front face
		//glColor3f(1, 1, 1);
		glTexCoord2f(0, 0);
		glVertex3f(x, y, z);
		glTexCoord2f(1, 0);
		glVertex3f(x + size, y, z);
		glTexCoord2f(1, 1);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(0, 1);
		glVertex3f(x, y + size, z);

		//back face
		//glColor3f(1, 0, 1);
		glVertex3f(x, y + size, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x, y, z + size);
		
		//left face
		//glColor3f(1, 0, 0);
		glVertex3f(x + size, y, z);
		glVertex3f(x + size, y, z + size);
		glVertex3f(x + size, y + size, z + size);
		glVertex3f(x + size, y + size, z);

		//right face
		//glColor3f(1, 1, 0);
		glVertex3f(x, y, z + size);
		glVertex3f(x, y, z);
		glVertex3f(x, y + size, z);
		glVertex3f(x, y + size, z + size);

		glEnd();
	}

}
