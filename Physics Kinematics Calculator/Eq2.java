package compSciCPT;

public class Eq2 extends Kinematics{
	public double Eq2_d() {
		double d = (v1 * t) + (1/2.0)*a*(t*t);
		return d;
	}
	public double Eq2_v1() {
		double v1 = (d - ((1/2.0)* a * (t * t)))/t;
		return v1;
	}
	public double Eq2_a() {
		double a = (2 * (d - (v1*t)))/((t*t));
		return a;

	}
	public double Eq2_t1() {
		double ac4 = (v1* v1) + (4 *(-a/2.0)*(-d));
		double srqqt = Math.sqrt(ac4);
		double t1 = ((-v1)+srqqt)/(a);
		return t1;
	}
	public double Eq2_t2() {
		double ac4 = (v1*v1) + (4*(-a/2.0)*(-d));
		double srqqt = Math.sqrt(ac4);
		double t2 = ((-v1)-srqqt)/(a);
		return t2;
	}
}
