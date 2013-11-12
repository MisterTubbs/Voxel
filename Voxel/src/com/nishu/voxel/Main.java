package com.nishu.voxel;

import com.nishu.voxel.utilities.Time;

public class Main {
	
	private Window window;
	private Game game;
	
	private boolean isRunning;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	private static final double FRAME_CAP = 1000.0;
	
	public Main(){
		isRunning = false;
		window = new Window(WIDTH, HEIGHT);
		game = new Game(WIDTH, HEIGHT);
		init();
	}
	
	private void init(){
		game.init();
	}
	
	public void start(){
		if(isRunning) return;
		isRunning = true;
		run();
	}
	
	private void run(){
		int frames = 0; 
		int frameCounter = 0; 
		
		final double frameTime = 1.0 / FRAME_CAP;
		
		long lastTime = Time.getTime();
		double unprocessed = 0;
		
		while(isRunning){
			boolean render = false;
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessed += passedTime / (double) Time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessed > frameTime){
				render = true;
				unprocessed -= frameTime;
				
				if(window.isClosed()) end();
				
				Time.setDelta(frameTime);
				
				update();
				
				if(frameCounter >= Time.SECOND){
					//System.out.println("FPS: " + frames);
					frames = 0; 
					frameCounter = 0;
				}
			}
			if(render){
				render();
				frames++;
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		end();
	}
	
	public void update(){
		window.update();
		game.update();
	}
	
	public void render(){
		game.render();
	}
	
	public void end(){
		if(!isRunning) return;
		isRunning = false;
		dispose();
	}
	
	public void dispose(){
		window.dispose();
		game.dispose();
	}
	
	public static void main(String[] args){
		Main game = new Main();
		game.start();
	}

}
