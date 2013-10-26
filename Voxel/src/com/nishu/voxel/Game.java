package com.nishu.voxel;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;

import com.nishu.voxel.entity.MobManager;
import com.nishu.voxel.geom.chunks.ChunkManager;
import com.nishu.voxel.graphics.Spritesheet;
import com.nishu.voxel.utilities.GameObject;

public class Game implements GameObject {

	private int width, height;
	private MobManager mobManager;
	private ChunkManager chunkManager;
	private Spritesheet spritesheet;
	
	private float[] fogColor = {0, 0, 0, 1};
	
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
		
		glFogi(GL_FOG_MODE, GL_LINEAR);
		glFog(GL_FOG_COLOR, fogColor);
	}

	@Override
	public void init() {
		spritesheet = new Spritesheet("spritesheets/tiles.png");
		mobManager = new MobManager(0, 0, 0, 0, 0);
		chunkManager = new ChunkManager(spritesheet);
	}

	@Override
	public void update() {
		chunkManager.update();
		mobManager.update();
	}

	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0, 0, 0.5f, 1);
		
		mobManager.render();
		chunkManager.render();
		
		glLoadIdentity();
	}

	@Override
	public void dispose() {
	}

}
