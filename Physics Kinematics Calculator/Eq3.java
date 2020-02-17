package compSciCPT;

public class Eq3 extends Kinematics{
	public double Eq3_d() {
		double d = ((v1+v2)/2.0) * t;
		return d;
	}
	
	public double Eq3_v1() {
		double v1 = 2 * (d/t) - v2;
		return v1;
	}
	
	public double Eq3_v2() {
		double v2 = ((2 * d)/t) - v1;
		return v2;
	}
	
	public double Eq3_t() {
		double t = d / ((v1+v2)/2.0);
		return t;
	}
	
	
}
