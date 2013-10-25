package com.nishu.voxel.entity;

import java.util.ArrayList;

import com.nishu.voxel.utilities.GameObject;

public class EntityManager implements GameObject{
	
	private ArrayList<Entity> entities;
	
	public EntityManager(){
		init();
	}

	@Override
	public void init() {
		this.entities = new ArrayList<Entity>();
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i) instanceof Mob){
				
			}
		}
	}

	@Override
	public void dispose() {
	}
	
	public void spawnEntity(float x, float y, float z, float rotx, float roty){
		spawnEntity(new Entity(x, y, z, rotx, roty));
	}
	
	public void spawnEntity(float x, float y, float z){
		spawnEntity(new Entity(x, y, z));
	}
	
	public void spawnEntity(Entity e){
		addEntity(e);
	}
	
	private void addEntity(Entity e){
		this.entities.add(e);
	}
	
	public Entity getEntity(int i){
		return this.entities.get(i);
	}
	
	public void killEntity(Entity e){
		this.entities.remove(e);
	}
}
