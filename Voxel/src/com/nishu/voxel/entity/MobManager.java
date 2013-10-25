package com.nishu.voxel.entity;

import java.util.ArrayList;

import com.nishu.voxel.utilities.GameObject;

public class MobManager implements GameObject {

	private ArrayList<Mob> mobs;
	private Player p;

	public MobManager(float x, float y, float z, float rotx, float roty) {
		init(x, y, z, rotx, roty);
	}

	public void init(float x, float y, float z, float rotx, float roty) {
		mobs = new ArrayList<Mob>();
		p = new Player(x, y, z);
	}

	@Override
	public void update() {
		p.update();
		for (int i = 0; i < mobs.size(); i++) {
			if (mobs.get(i).isDead()) {
				killMob(mobs.get(i));
			} else {
				mobs.get(i).update();
			}
		}
	}

	@Override
	public void render() {
		p.render();
		for (int i = 0; i < mobs.size(); i++) {
			if (mobs.get(i).isDead()) {
				killMob(this.getMob(i));
			} else {
				mobs.get(i).render();
			}
		}
	}

	@Override
	public void dispose() {
	}

	public void spawnMob(float x, float y, float z, float rotx, float roty) {
		spawnMob(new Mob(x, y, z, rotx, roty));
	}

	public void spawnMob(float x, float y, float z) {
		spawnMob(new Mob(x, y, z));
	}

	public void spawnMob(Mob m) {
		addMob(m);
	}

	private void addMob(Mob m) {
		this.mobs.add(m);
	}

	public Mob getMob(int i) {
		return this.mobs.get(i);
	}

	public void killMob(Mob m) {
		this.mobs.remove(m);
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	@Override
	public void init() {
	}

}
