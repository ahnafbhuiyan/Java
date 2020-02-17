package compSciCPT;

public class Eq4 extends Kinematics{
	public double Eq4_d(){//d
		double d = (v2 * t) - (0.5 * a * (t * t));
		return d;
	}

	public double Eq4_v2(){
		double v2t = d+((a*(Math.pow(t, 2)))*0.5);
		double v2 = v2t/t;
		return v2;
	}

	public double Eq4_a (){
		double at = d-(v2*t);
		double a05 = at/(Math.pow(t, 2));
		double a = a05*(-2);
		return a;
	}

	public double Eq4_t(){
		double ac4 = Math.pow(v2, 2)-(4*(-a/2.0)*(-d));
		double srqqt = Math.sqrt(ac4);
		double t1 = ((-v2)+ srqqt)/(-a);
		return t1;
	}

	public double Eq4_t2(){
		double ac4 = Math.pow(v2, 2)-(4*(-a/2.0)*(-d));
		double srqqt = Math.sqrt(ac4);
		double t2 = ((-v2)-srqqt)/(-a);
		return t2;            
	}
}
