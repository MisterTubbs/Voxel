package com.nishu.voxel;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;

import com.nishu.voxel.entity.Player;
import com.nishu.voxel.geom.Chunk;
import com.nishu.voxel.utilities.GameObject;

public class Game implements GameObject {

	private Player e;
	private int width, height;
	
	Chunk c;
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		initGL();
	}

	private void initGL() {
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		gluPerspective((float) 67, width / height, 0.001f, 1000f);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_DEPTH_TEST);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_FRONT);
	}

	@Override
	public void init() {
		e = new Player(0, 0, -10);
		c = new Chunk(0, 0, 0);
		c.rebuild();
	}

	@Override
	public void update() {
		e.update();
	}

	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		e.render();
		
		c.render();
		
		glLoadIdentity();
	}
	
	@Override
	public void dispose() {
	}

}
