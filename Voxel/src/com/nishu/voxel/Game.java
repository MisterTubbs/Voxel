package com.nishu.voxel;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
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
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		initGL();
	}

	private void initGL() {
		FloatBuffer fog = BufferUtils.createFloatBuffer(4);
		fog.put(0).put(0).put(1).put(1).flip();
		
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		gluPerspective((float) 67, width / height, 0.001f, 1000f);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_DEPTH_TEST);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_FRONT);
		
		glEnable(GL_FOG);
		glFogi(GL_FOG_MODE, GL_LINEAR);
		glFog(GL_FOG_COLOR, fog);
		glFogf(GL_FOG_DENSITY, 0.15f);
		glHint(GL_FOG_HINT, GL_DONT_CARE);
		glFogf(GL_FOG_START, 30f);
		glFogf(GL_FOG_END, 100f);
		
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		glShadeModel(GL_SMOOTH);
	}

	@Override
	public void init() {
		spritesheet = new Spritesheet("spritesheets/tiles.png");
		chunkManager = new ChunkManager(spritesheet);
		mobManager = new MobManager(chunkManager, 0, 0, 0, 0, 0);
	}

	@Override
	public void update() {
		chunkManager.update();
		mobManager.update();
	}

	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0, 0, 1, 1);
		
		mobManager.render();
		chunkManager.render();
		
		glLoadIdentity();
	}

	@Override
	public void dispose() {
	}

}
