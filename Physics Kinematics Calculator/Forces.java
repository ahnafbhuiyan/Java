package compSciCPT;

public class Forces extends Dynamics{
	public double Eq6_f(double m, double a) {
		double f = m * a;
		return f;
	}
	
	public double Eq6_m(double f, double a) {
		double m = f / a;
		return m;
	}
	
	public double Eq6_a(double f, double m) {
		double a = f / m;
		return a;
	}
}
