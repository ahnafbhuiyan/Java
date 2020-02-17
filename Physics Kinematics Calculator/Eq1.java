package compSciCPT;

public class Eq1 extends Kinematics{
	public double Eq1_v2(){ //finds v2  
		double v2 = v1+ (a*t);
		return v2;

	}

	public double Eq1_v1 (){//v1
		double v1 = v2 - (a*t);
		return v1;
	}

	public double Eq1_a(){//a
		double a = (v2-v1)/t;
		return a;
	}

	public double Eq1_t(){//t
		double t = (v2-v1)/a;
		return t;
	}
}
