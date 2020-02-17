package compSciCPT;

public class Kinematics {
	static double v1;
	static double v2;
	static double a;
	static double d;
	static double t;
	
	Kinematics (double v1, double v2, double a, double d, double t){
		this.v1 = v1;
		this.v2 = v2;
		this.a= a;
		this.d = d;
		this.t= t;
	}
	
	Kinematics (){
		
	}

	public static double getV1() {
		return v1;
	}

	public static void setV1(double v1) {
		Kinematics.v1 = v1;
	}

	public static double getV2() {
		return v2;
	}

	public static void setV2(double v2) {
		Kinematics.v2 = v2;
	}

	public static double getA() {
		return a;
	}

	public static void setA(double a) {
		Kinematics.a = a;
	}

	public static double getD() {
		return d;
	}

	public static void setD(double d) {
		Kinematics.d = d;
	}

	public static double getT() {
		return t;
	}

	public static void setT(double t) {
		Kinematics.t = t;
	}

	public static String description() {

		return " Kinematics is a branch of classical "

        + "\n mechanics that describes the motion of points, bodies (objects), "

        + "\n and systems of bodies (groups of objects) without considering the mass of each or the forces that caused the motion. "

        + "\n Kinematics, as a field of study, is often referred to as the \"geometry of motion\" and is occasionally seen as a branch of mathematics. "

        + "\n A kinematics problem begins by describing the geometry of the system and declaring the initial conditions of any known values of position, velocity and/or acceleration of points within the system. "

        + "\n Then, using arguments from geometry, the position, velocity and acceleration of any unknown parts of the system can be determined. The study of how forces act on masses falls within kinetics.";

	}
}
