package com.nishu.voxel;

public class Main {
	
	private Window window;
	private Game game;
	
	private boolean isRunning;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
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
		while (isRunning && !window.isClosed()){
			update();
			render();
		}
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
