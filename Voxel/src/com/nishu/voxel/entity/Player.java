package com.nishu.voxel.entity;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.nio.FloatBuffer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import com.nishu.voxel.geom.Shape;
import com.nishu.voxel.geom.chunks.Chunk;
import com.nishu.voxel.geom.chunks.ChunkManager;
import com.nishu.voxel.math.AABB;
import com.nishu.voxel.utilities.Time;

public class Player extends Mob {

	AABB box;
	Shape cube;
	ChunkManager chunkManager;
	float yrotrad, xrotrad, mouseDX, mouseDY, mouseX, mouseY, lookSpeed = 0.090f, strafeSpeed = 8f;
	FloatBuffer ambient, diffuse, position;

	public Player(ChunkManager chunkManager, float x, float y, float z) {
		super(x, y, z);
		this.chunkManager = chunkManager;
		init();
	}

	public Player(float x, float y, float z, float rotx, float roty) {
		super(x, y, z, rotx, roty);
		init();
	}

	public void init() {
		box = new AABB(1, 1, 1);
		cube = new Shape();
	}

	public void update() {
		box.update(this.getPosition());
		
		
		if(Mouse.isButtonDown(0)){
			Chunk c = chunkManager.lookupChunk(new Vector3f((float) cube.getSx(), (float) cube.getSy(), (float) cube.getSz()));
			if(c != null){
				if(c.getType() == 0) {
					c.setType(1);
				}
				c.setTile((float) cube.getSx(), (float) cube.getSy(), (float) cube.getSz(), (byte) 3);
				c.rebuild();
			}
		}
		
		if(Mouse.isButtonDown(1)){
			Chunk c = chunkManager.lookupChunk(new Vector3f((float) cube.getSx(), (float) cube.getSy(), (float) cube.getSz()));
			if(c != null){
				c.setTile((float) cube.getSx(), (float) cube.getSy(), (float) cube.getSz(), (byte) 1);
				c.rebuild();
			}
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			System.exit(0);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			this.getPosition().set(this.getPosition().x -= ((float) (Math.cos(yrotrad)) * strafeSpeed) * Time.getDelta(), this.getPosition().getY(), this.getPosition().z -= (float) ((Math.sin(yrotrad)) * strafeSpeed) * Time.getDelta());
			this.setHasMoved(true);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			this.getPosition().set(this.getPosition().x += (float) ((Math.cos(yrotrad)) * strafeSpeed) * Time.getDelta(), this.getPosition().getY(), this.getPosition().z += (float) ((Math.sin(yrotrad)) * strafeSpeed) * Time.getDelta());
			this.setHasMoved(true);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			xrotrad = (this.getRotation().x / 180 * 3.141592654f);
			this.getPosition().set(this.getPosition().x += (float) ((Math.sin(yrotrad)) * strafeSpeed) * Time.getDelta(), (this.getPosition().y) -= (float) ((Math.sin(xrotrad)) * strafeSpeed) * Time.getDelta(), this.getPosition().z -= (Math.cos(yrotrad) * strafeSpeed) * Time.getDelta());
			this.setHasMoved(true);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yrotrad = (this.getRotation().y / 180 * 3.141592654f);
			xrotrad = (this.getRotation().x / 180 * 3.141592654f);
			this.getPosition().set(this.getPosition().x -= (float) ((Math.sin(yrotrad)) * strafeSpeed) * Time.getDelta(), this.getPosition().y += (float) ((Math.sin(xrotrad)) * strafeSpeed) * Time.getDelta(), this.getPosition().z += (Math.cos(yrotrad) * strafeSpeed) * Time.getDelta());
			this.setHasMoved(true);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			this.getPosition().setY(this.getPosition().y -= strafeSpeed * Time.getDelta());
			this.setHasMoved(true);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			this.getPosition().setY(this.getPosition().y += strafeSpeed * Time.getDelta());
			this.setHasMoved(true);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_F1)) {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
			GL11.glDisable(GL11.GL_CULL_FACE);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_F2)) {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
			GL11.glEnable(GL11.GL_CULL_FACE);
		}

		if (Mouse.isGrabbed()) {
			mouseX = Mouse.getX();
			mouseY = 1280 - Mouse.getY();

			mouseDX = Mouse.getDX();
			mouseDY = -Mouse.getDY();
		}

		this.getRotation().set(this.getRotation().x += (float) mouseDY * lookSpeed, this.getRotation().y += (float) mouseDX * lookSpeed, 0);
	}

	public void render() {
		if (this.getRotation().x < -45)
			this.getRotation().setX(-45);
		if (this.getRotation().x > 90)
			this.getRotation().setX(90);
		
		cube.createWireFrameCube(-this.getPosition().x + (4 * Math.cos(this.getRotation().x * (Math.PI / 180)) * Math.sin(this.getRotation().y * (Math.PI / 180))), -this.getPosition().y + (4 * Math.sin(this.getRotation().x * (Math.PI / 180)) * Math.sin(this.getRotation().y * (Math.PI / 180))), -this.getPosition().z + (4 * Math.cos(this.getRotation().y * (Math.PI / 180))), 1);

		glRotatef(this.getRotation().x, 1, 0, 0);
		glRotatef(this.getRotation().y, 0, 1, 0);
		glTranslatef(this.getPosition().x, this.getPosition().y, this.getPosition().z);
		
		//setHasMoved(false);
	}

	public void dipose() {

	}

}
