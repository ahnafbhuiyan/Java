package compSciCPT;

public class Eq5 extends Kinematics{
	public double Eq5_v2 (){//v2
		double ad = 2*(a*d);
		double v = Math.pow(v1,2);
		double v2 = Math.sqrt(v+ad);
		return v2;
	}

	public double Eq5_v1(){//v1
		double vdt = (v2 * v2) - (2 * a * d);
		double v1 = Math.sqrt(vdt);
		return v1;
	}

	public double Eq5_a(){//a
		double v22 = Math.pow(v2, 2) - (Math.pow(v1,2));
		double a = v22/(2*d);
		return a;
	}

	public double Eq5_d(){//d
		double d = ((v2 * v2) - (v1 * v1))/(2*a);
		return d;
	}
}
