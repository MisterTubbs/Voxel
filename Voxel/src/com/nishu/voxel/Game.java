package com.nishu.voxel;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import com.nishu.voxel.entity.Player;
import com.nishu.voxel.utilities.GameObject;
import com.nishu.voxel.utilities.Input;

public class Game implements GameObject {

	private Player e;
	private int width, height;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		initGL();
	}

	private void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		gluPerspective((float) 67, width / height, 0.001f, 100f);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_DEPTH_TEST);
	}

	@Override
	public void init() {
		e = new Player(0, 0, -10);
	}

	@Override
	public void update() {
		Input.update();
		e.update();
	}

	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		e.render();
		
		glBegin(GL_QUADS); // Draw The Cube Using quads
		glColor3f(0.0f, 1.0f, 0.0f); // Color Blue
		glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
		glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
		glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)
		
		glColor3f(1.0f, 0.5f, 0.0f); // Color Orange
		glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The Quad (Bottom)
		glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The Quad (Bottom)
		glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Bottom)
		glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Bottom)
		
		glColor3f(1.0f, 0.0f, 0.0f); // Color Red
		glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
		glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
		glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad (Front)
		glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad (Front)
		
		glColor3f(1.0f, 1.0f, 0.0f); // Color Yellow
		glVertex3f(1.0f, -1.0f, -1.0f); // Top Right Of The Quad (Back)
		glVertex3f(-1.0f, -1.0f, -1.0f); // Top Left Of The Quad (Back)
		glVertex3f(-1.0f, 1.0f, -1.0f); // Bottom Left Of The Quad (Back)
		glVertex3f(1.0f, 1.0f, -1.0f); // Bottom Right Of The Quad (Back)
		
		glColor3f(0.0f, 0.0f, 1.0f); // Color Blue
		glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Left)
		glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Left)
		glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad (Left)
		
		glColor3f(1.0f, 0.0f, 1.0f); // Color Violet
		glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Right)
		glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Right)
		glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad (Right)
		glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Right)
		glEnd(); // End Dra - See more at:
		
		glLoadIdentity();
	}

	@Override
	public void dispose() {

	}

}
