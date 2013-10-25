package com.nishu.voxel.math;

public class CollisionLibrary {
	
	public static boolean boxCollision(AABB a, AABB b){
		if(Math.abs(a.center.x - b.center.x) > (a.r[0] + b.r[0])) return false;
		return false;
	}

}
