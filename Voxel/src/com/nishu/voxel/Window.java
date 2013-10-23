package com.nishu.voxel;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

	public Window(int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("Nishu Voxels");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isClosed(){
		return Display.isCloseRequested();
	}
	
	public void update(){
		Display.update();
		Display.sync(60);
	}
	
	public void dispose(){
		Display.destroy();
	}
}
