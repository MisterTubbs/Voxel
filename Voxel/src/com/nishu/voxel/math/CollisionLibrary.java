package com.nishu.voxel.math;

public class CollisionLibrary {
	
	public static boolean boxCollision(AABB a, AABB b){
		if(Math.abs(a.center.x - b.center.x) > (a.r[0] + b.r[0])) return false;
		if(Math.abs(a.center.y - b.center.y) > (a.r[1] + b.r[1])) return false;
		if(Math.abs(a.center.z - b.center.z) > (a.r[2] + b.r[2])) return false;
		return true;
	}

}
