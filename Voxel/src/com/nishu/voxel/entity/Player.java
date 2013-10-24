package com.nishu.voxel.entity;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Player extends Mob {

	public float yrotrad, xrotrad, mouseDX, mouseDY, mouseX, mouseY, xrot = 0.0f, yrot = 0.0f, zrot = 0.0f, lookSpeed = 0.090f, strafeSpeed = 2f;

	public Player(float x, float y, float z) {
		super(x, y, z);
	}

	public void init() {

	}

	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			System.exit(0);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			this.setPosition(new Vector3f(this.getPosition().x -= (float) (Math.cos(yrotrad)) * strafeSpeed, this.getPosition().getY(), this.getPosition().z -= (float) (Math.sin(yrotrad)) * strafeSpeed));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			this.setPosition(new Vector3f(this.getPosition().x += (float) (Math.cos(yrotrad)) * strafeSpeed, this.getPosition().getY(), this.getPosition().z += (float) (Math.sin(yrotrad)) * strafeSpeed));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			xrotrad = (this.getRotation().x / 180 * 3.141592654f);
			this.setPosition(new Vector3f(this.getPosition().x += (float) (Math.sin(yrotrad)) * strafeSpeed, (this.getPosition().y) -= (float) (Math.sin(xrotrad)) * strafeSpeed, this.getPosition().z -= (Math.cos(yrotrad) * strafeSpeed)));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			xrotrad = (this.getRotation().x / 180 * 3.141592654f);
			this.setPosition(new Vector3f(this.getPosition().x -= (float) (Math.sin(yrotrad)) * strafeSpeed, this.getPosition().y += (float) (Math.sin(xrotrad)) * strafeSpeed, this.getPosition().z += (Math.cos(yrotrad) * strafeSpeed)));
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			this.setPosition(new Vector3f(this.getPosition().x, this.getPosition().y -= 10, this.getPosition().z));
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			this.setPosition(new Vector3f(this.getPosition().x, this.getPosition().y += 10, this.getPosition().z));
		}
		
		mouseX = Mouse.getX();
		mouseY = 1280 - Mouse.getY();
		
		mouseDX = Mouse.getDX();
		mouseDY = -Mouse.getDY();

		this.setRotation(new Vector3f(this.getRotation().x += (float) mouseDY * lookSpeed, this.getRotation().y += (float) mouseDX * lookSpeed, this.getRotation().z));
	}

	public void render() {
		glRotatef(this.getRotation().x, 1, 0, 0);
		glRotatef(this.getRotation().y, 0, 1, 0);
		glTranslatef(this.getPosition().x, this.getPosition().y, this.getPosition().z);
	}

	public void dipose() {

	}

}
