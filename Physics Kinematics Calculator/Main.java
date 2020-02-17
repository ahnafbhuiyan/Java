package compSciCPT;
//package compSciCPT;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{

	Eq1 one = new Eq1();
	Eq2 two = new Eq2();
	Eq3 three = new Eq3();
	Eq4 four = new Eq4();
	Eq5 five = new Eq5();
	Forces fNet = new Forces();

	double iV1=0,iV2=0,iT=0,iA=0,iD=0,iFnet=0,iM=0,iFa=0;
	//            boolean Ft,Fv1,Fv2,Fa,Fd,Ffnet,Fm,Ffa;

	//            boolean Nt,Nv1,Nv2,Na,Nd;
	boolean[][] findAndTake = new boolean[8][8];

	Kinematics kine = new Kinematics();
	Dynamics die = new Dynamics();

	JPanel val = new JPanel();
	JPanel miss = new JPanel();
	JPanel stud = new JPanel();
	double [][] variables = new double [5][10];
	double [][] results = new double [5][10];

	JTextField v1 = new JTextField(8);
	JTextField v2 = new JTextField(8);
	JTextField d = new JTextField(8);
	JTextField a = new JTextField(8);
	JTextField t = new JTextField(8);
	JLabel v1t = new JLabel("v1:");
	JLabel v2t = new JLabel("v2:");
	JLabel dt = new JLabel("d:");
	JLabel at = new JLabel("a:");
	JLabel tt = new JLabel("t:");

	JTextField f = new JTextField(8);
	JTextField m = new JTextField(8);
	JTextField fa = new JTextField(8);
	JLabel ft = new JLabel("f:");
	JLabel mt = new JLabel("m:");
	JLabel fat = new JLabel("a:");
	JLabel ans1;
	JLabel ans2;
	JLabel fill = new JLabel("       ");

	JButton [][] var = new JButton [2][5];
	JButton nf = new JButton("Net Force");
	JButton mass = new JButton("Mass");
	JButton acc = new JButton("Acceleration");
	JButton mnf = new JButton("Net Force");
	JButton mmass = new JButton("Mass");
	JButton macc = new JButton("Acceleration");
	JButton kin = new JButton("Kinematics");
	JButton forc = new JButton("Forces");
	JButton submitf = new JButton("Submit");
	JButton submitk = new JButton("Submit");
	JButton reset = new JButton("Reset");
	JButton kdesc = new JButton("Kinematics Description");
	JButton fdesc = new JButton("Dynamics Description");
	JButton inst = new JButton("Instructions");

	JPanel variable = new JPanel();
	JPanel missing = new JPanel();
	JPanel fvariable = new JPanel();
	JPanel fmissing = new JPanel();
	JPanel decision = new JPanel();
	JPanel start = new JPanel();
	JPanel ktf = new JPanel();
	JPanel ftf = new JPanel();
	JPanel bot = new JPanel();

	JLabel pc = new JLabel ("Physics Calculator");
	JLabel unit = new JLabel ("Which calculator would you like to use?");
	JLabel wv = new JLabel("What variable are you looking for?");
	JLabel nh = new JLabel("What variable do you not have?");
	JLabel fwv = new JLabel("What variable are you looking for?");
	JLabel fnh = new JLabel("What variable do you not have?");
	JLabel name = new JLabel("By Arnab and Ahnaf");

	//  static int [][] variables = new int [5][10]; // t,v1,v1,d,a

	//  static int [][] results = new int [1][10];

	//  static int [][] forcesVariable = new int [3][10];

	//  static int variableCount, rowCounter;

	static int eqUsed;

	double answer, answer2;

	String sAnswer, sAnswer2;

	ImageIcon pic = new ImageIcon(getClass().getResource("physics.png"));
	JLabel photo = new JLabel (pic);

	int i = 0;

	Main(){
		getContentPane().setLayout( new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));
		photo.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(photo);

		//Start Screen
		kin.setPreferredSize(new Dimension(100, 25));
		kin.setFocusable(false);
		kin.addActionListener(this);

		forc.setPreferredSize(new Dimension(100, 25));
		forc.setFocusable(false);
		forc.addActionListener(this);

		decision.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		decision.add(kin);
		decision.add(forc);
		unit.setAlignmentX(CENTER_ALIGNMENT);
		reset.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(unit);
		getContentPane().add(decision);
		getContentPane().add(reset);

		//Kinematics

		while (i < 5) {
			if (i == 0) {
				var[0][i] = new JButton("Displacement");	
			}
			else if (i == 1) {
				var[0][i] = new JButton("Time");
			}
			else if (i == 2) {
				var[0][i] = new JButton("Initial Velocity");
			}
			else if (i == 3) {
				var[0][i] = new JButton("Final Velocity");
			}
			else if (i == 4) {
				var[0][i] = new JButton("Acceleration");
			}
			var[0][i].setPreferredSize(new Dimension(140, 25));
			var[0][i].setFocusable(false);
			var[0][i].addActionListener(this);
			var[0][i].setVisible(false);
			i++;
		}

		variable.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		variable.add(var[0][0]);
		variable.add(var[0][1]);
		variable.add(var[0][2]);
		variable.add(var[0][3]);
		variable.add(var[0][4]);
		wv.setAlignmentX(CENTER_ALIGNMENT);
		wv.setVisible(false);
		getContentPane().add(wv);
		getContentPane().add(variable);


		for(int x = 0; x < 5; x++) {
			if (x == 0) {
				var[1][x] = new JButton("Displacement");
			}
			else if (x == 1) {
				var[1][x] = new JButton("Time");
			}
			else if (x == 2) {
				var[1][x] = new JButton("Initial Velocity");
			}
			else if (x == 3) {
				var[1][x] = new JButton("Final Velocity");
			}
			else if (x == 4) {
				var[1][x] = new JButton("Acceleration");
			}
			var[1][x].setPreferredSize(new Dimension(140, 25));
			var[1][x].setFocusable(false);
			var[1][x].addActionListener(this);
			var[1][x].setVisible(false);
		}

		missing.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		missing.add(var[1][0]);
		missing.add(var[1][1]);
		missing.add(var[1][2]);
		missing.add(var[1][3]);
		missing.add(var[1][4]);
		nh.setAlignmentX(CENTER_ALIGNMENT);
		nh.setVisible(false);
		getContentPane().add(nh);
		getContentPane().add(missing);

		ktf.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		ktf.add(v1t);
		v1.addActionListener(this);
		ktf.add(v1);
		ktf.add(v2t);
		v2.addActionListener(this);
		ktf.add(v2);
		ktf.add(dt);
		d.addActionListener(this);
		ktf.add(d);
		ktf.add(at);
		a.addActionListener(this);
		ktf.add(a);
		ktf.add(tt);
		t.addActionListener(this);
		ktf.add(t);
		submitk.addActionListener(this);
		ktf.add(submitk);
		ktf.setVisible(false);
		getContentPane().add(ktf);

		//Forces
		acc.setPreferredSize(new Dimension(140, 25));
		acc.setFocusable(false);
		acc.addActionListener(this);
		acc.setVisible(false);

		nf.setPreferredSize(new Dimension(140, 25));
		nf.setFocusable(false);
		nf.addActionListener(this);
		nf.setVisible(false);

		mass.setPreferredSize(new Dimension(140, 25));
		mass.setFocusable(false);
		mass.addActionListener(this);
		mass.setVisible(false);

		fvariable.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		fvariable.add(acc);
		fvariable.add(nf);
		fvariable.add(mass);
		fwv.setAlignmentX(CENTER_ALIGNMENT);
		fwv.setVisible(false);
		getContentPane().add(fwv);
		getContentPane().add(fvariable);

		ftf.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		ftf.add(ft);
		f.addActionListener(this);
		ftf.add(f);
		ftf.add(mt);
		m.addActionListener(this);
		ftf.add(m);
		ftf.add(fat);
		fa.addActionListener(this);
		ftf.add(fa);
		ftf.add(submitf);
		submitf.addActionListener(this);
		ftf.setVisible(false);
		getContentPane().add(ftf);

		ans1 = new JLabel ();
		ans1.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(ans1);
		ans2 = new JLabel ();
		ans2.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(ans2);
		getContentPane().add(fill);

		bot.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		reset.addActionListener(this);
		kdesc.addActionListener(this);
		fdesc.addActionListener(this);
		inst.addActionListener(this);
		bot.add(reset);
		bot.add(kdesc);
		bot.add(fdesc);
		bot.add(inst);
		getContentPane().add(bot);

		name.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(name);

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Physics Calculator");

	}

	public static void main(String[]args) {
		new Main();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == kin) {
			getContentPane().remove(fvariable);
			getContentPane().remove(fmissing);
			wv.setVisible(true);
			kin.setEnabled(false);
			forc.setEnabled(false);
			var[0][0].setVisible(true);
			var[0][1].setVisible(true);
			var[0][2].setVisible(true);
			var[0][3].setVisible(true);
			var[0][4].setVisible(true);
		}
		if(e.getSource() == var[0][0]) {
			findAndTake[0][4]= true;
			nh.setVisible(true);
			d.setEnabled(false);
			var[0][1].setEnabled(false);
			var[0][2].setEnabled(false);
			var[0][3].setEnabled(false);
			var[0][4].setEnabled(false);
			var[1][0].setVisible(true);
			var[1][1].setVisible(true);
			var[1][2].setVisible(true);
			var[1][3].setVisible(true);
			var[1][4].setVisible(true);
			var[1][0].setEnabled(false);
			var[1][1].setEnabled(true);
			var[1][2].setEnabled(true);
			var[1][3].setEnabled(true);
			var[1][4].setEnabled(true);
		}
		if(e.getSource() == var[0][1]) {
			findAndTake[0][0]= true;
			nh.setVisible(true);
			t.setEnabled(false);
			var[0][0].setEnabled(false);
			var[0][2].setEnabled(false);
			var[0][3].setEnabled(false);
			var[0][4].setEnabled(false);
			var[1][0].setVisible(true);
			var[1][1].setVisible(true);
			var[1][2].setVisible(true);
			var[1][3].setVisible(true);
			var[1][4].setVisible(true);
			var[1][0].setEnabled(true);
			var[1][1].setEnabled(false);
			var[1][2].setEnabled(true);
			var[1][3].setEnabled(true);
			var[1][4].setEnabled(true);
		}
		if(e.getSource() == var[0][2]) {
			findAndTake[0][1]= true;
			nh.setVisible(true);
			v1.setEnabled(false);
			var[0][0].setEnabled(false);
			var[0][1].setEnabled(false);
			var[0][3].setEnabled(false);
			var[0][4].setEnabled(false);
			var[1][0].setVisible(true);
			var[1][1].setVisible(true);
			var[1][2].setVisible(true);
			var[1][3].setVisible(true);
			var[1][4].setVisible(true);
			var[1][0].setEnabled(true);
			var[1][1].setEnabled(true);
			var[1][2].setEnabled(false);
			var[1][3].setEnabled(true);
			var[1][4].setEnabled(true);
		}
		if(e.getSource() == var[0][3]) {
			findAndTake[0][2]= true;
			nh.setVisible(true);
			v2.setEnabled(false);
			var[0][0].setEnabled(false);
			var[0][1].setEnabled(false);
			var[0][2].setEnabled(false);
			var[0][4].setEnabled(false);
			var[1][0].setVisible(true);
			var[1][1].setVisible(true);
			var[1][2].setVisible(true);
			var[1][3].setVisible(true);
			var[1][4].setVisible(true);
			var[1][0].setEnabled(true);
			var[1][1].setEnabled(true);
			var[1][2].setEnabled(true);
			var[1][3].setEnabled(false);
			var[1][4].setEnabled(true);
		}
		if(e.getSource() == var[0][4]) {
			findAndTake[0][3]= true;
			nh.setVisible(true);
			a.setEnabled(false);
			var[0][0].setEnabled(false);
			var[0][1].setEnabled(false);
			var[0][2].setEnabled(false);
			var[0][3].setEnabled(false);
			var[1][0].setVisible(true);
			var[1][1].setVisible(true);
			var[1][2].setVisible(true);
			var[1][3].setVisible(true);
			var[1][4].setVisible(true);
			var[1][0].setEnabled(true);
			var[1][1].setEnabled(true);
			var[1][2].setEnabled(true);
			var[1][3].setEnabled(true);
			var[1][4].setEnabled(false);
		}

		if(e.getSource() == var[1][0]) {
			findAndTake[1][4] = true;
			ktf.setVisible(true);
			d.setEnabled(false);
			var[1][1].setEnabled(false);
			var[1][2].setEnabled(false);
			var[1][3].setEnabled(false);
			var[1][4].setEnabled(false);
		}

		if(e.getSource() == var[1][1]) {
			findAndTake[1][0] = true;
			ktf.setVisible(true);
			t.setEnabled(false);
			var[1][0].setEnabled(false);
			var[1][2].setEnabled(false);
			var[1][3].setEnabled(false);
			var[1][4].setEnabled(false);
		}

		if(e.getSource() == var[1][2]) {
			findAndTake[1][1] = true;
			ktf.setVisible(true);
			v1.setEnabled(false);
			var[1][0].setEnabled(false);
			var[1][1].setEnabled(false);
			var[1][3].setEnabled(false);
			var[1][4].setEnabled(false);
		}

		if(e.getSource() == var[1][3]) {
			findAndTake[1][2] = true;
			ktf.setVisible(true);
			v2.setEnabled(false);
			var[1][0].setEnabled(false);
			var[1][1].setEnabled(false);
			var[1][2].setEnabled(false);
			var[1][4].setEnabled(false);
		}

		if(e.getSource() == var[1][4]) {
			findAndTake[1][3] = true;
			ktf.setVisible(true);
			a.setEnabled(false);
			var[1][0].setEnabled(false);
			var[1][1].setEnabled(false);
			var[1][2].setEnabled(false);
			var[1][3].setEnabled(false);
		}

		if (e.getSource() == forc) {
			getContentPane().remove(variable);
			getContentPane().remove(missing);
			wv.setVisible(true);
			forc.setEnabled(false);
			kin.setEnabled(false);
			acc.setVisible(true);
			mass.setVisible(true);
			nf.setVisible(true);

		}
		if(e.getSource() == acc) {
			findAndTake[0][7] = true;
			ftf.setVisible(true);
			nf.setEnabled(false);
			mass.setEnabled(false);
			acc.setEnabled(false);
			fa.setEnabled(false);
		}
		if(e.getSource() == nf) {
			findAndTake[0][5]= true;
			ftf.setVisible(true);
			nf.setEnabled(false);
			mass.setEnabled(false);
			acc.setEnabled(false);
			f.setEnabled(false);
		}
		if(e.getSource() == mass) {
			findAndTake[0][6]= true;
			ftf.setVisible(true);
			nf.setEnabled(false);
			mass.setEnabled(false);
			acc.setEnabled(false);
			m.setEnabled(false);
		}

		if(e.getSource() == submitk) {
			setVariables();
			if (findAndTake[1][4]) {
				choose_Eq1();
			}
			else if (findAndTake[1][2]) {
				choose_Eq2();
			}
			else if (findAndTake[1][3]) {
				choose_Eq3();
			}
			else if(findAndTake[1][1]) {
				choose_Eq4();
			}
			else if (findAndTake[1][0]) {
				choose_Eq5();
			}

			if (findAndTake[0][0]&&findAndTake[1][1] || findAndTake[0][0]&&findAndTake[1][2]) {
				sAnswer2 = Double.toString(answer2);
				ans2.setText(" and " + sAnswer2);
			}
			sAnswer = Double.toString(answer);
			ans1.setText("The answer is: " + sAnswer);


			//Tests
			System.out.println (iV2+"v2");
			System.out.println (iV1+"v1");
			System.out.println (iD+"d");
			System.out.println (iA+"A");
			System.out.println (iT+"t");
			//System.out.println (t.getText());
			System.out.println(answer+"answer");
			///
		}
		if(e.getSource() == submitf) {
			setVariables();

			choose_Forces(iFnet,iM,iFa);

			sAnswer = Double.toString(answer);
			ans1.setText("The answer is: " + sAnswer);
		}
		if(e.getSource() == reset) {
			dispose();
			Main game = new Main();
			game.setVisible(true);
		}
		if(e.getSource() == kdesc) {
			JOptionPane.showMessageDialog(null, Kinematics.description(), "Description",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == fdesc) {
			JOptionPane.showMessageDialog(null, Dynamics.description(), "Description",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == inst) {
			JOptionPane.showMessageDialog(null, Instruction.description(), "Description",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void setVariables() {
		if (v1.getText().equals("")) {
			iV1=0;
		}
		else {
			String numV1 = v1.getText();     
			iV1=Double.parseDouble(numV1);
			Kinematics.setV1(iV1);
		}
		if (v2.getText().equals("")) {
			iV2=0;
		}
		else {
			String numV2 = v2.getText();     
			iV2 = Double.parseDouble(numV2);
			Kinematics.setV2(iV2);
		}
		if (d.getText().equals("")) {
			iD=0;
		}
		else {
			String numD = d.getText();     
			iD = Double.parseDouble(numD);
			Kinematics.setD(iD);
		}
		if (a.getText().equals("")) {
			iA=0;
		}
		else {
			String numA = a.getText();     
			iA = Double.parseDouble(numA);
			Kinematics.setA(iA);
		}
		if (t.getText().equals("")) {
			iT=0;
		}
		else {
			String numT = t.getText();     
			iT =Double.parseDouble(numT);
			Kinematics.setT(iT);
		}
		if (fa.getText().equals("")) {
			iFa=0;
		}
		else {
			String numfA = fa.getText();     
			iFa = Double.parseDouble(numfA);
		}
		if (m.getText().equals("")) {
			iM=0;
		}
		else {
			String numM = m.getText();     
			iM = Double.parseDouble(numM);
		}
		if (f.getText().equals("")) {
			iFnet=0;
		}
		else {
			String numF = f.getText();     
			iFnet = Double.parseDouble(numF);
		}
	}

	//Choosing methods

	public void choose_Eq1() {

		if (findAndTake[0][2]) {
			answer = one.Eq1_v2();
		}
		else if (findAndTake[0][1]) {
			answer = one.Eq1_v1();
		}
		else if (findAndTake[0][3]) {

			answer = one.Eq1_a();
		}
		else if (findAndTake[0][0]) {
			answer = one.Eq1_t();
		}
		System.out.println("Chose Eq1");
	}



	public void choose_Eq2() {

		if (findAndTake[0][4]) {
			answer = two.Eq2_d();
		}
		else if (findAndTake[0][1]) {
			answer = two.Eq2_v1();
		}

		else if (findAndTake[0][3]) {
			answer = two.Eq2_a();
		}

		else if (findAndTake[0][0]) {
			answer = two.Eq2_t1();
			answer2 =two.Eq2_t2();
		}

		//System.out.println("Chose Eq2");
	}

	public void choose_Eq3() {

		if (findAndTake[0][1]) {
			answer = three.Eq3_v1();
		}
		else if (findAndTake[0][4]) {
			answer = three.Eq3_d();
		}
		else if (findAndTake[0][2]) {
			answer = three.Eq3_v2();
		}
		else if (findAndTake[0][0]) {
			answer = three.Eq3_t();
		}
		System.out.println("Chose Eq3");
	}



	public void choose_Eq4() {

		if (findAndTake[0][3]) {
			answer =four.Eq4_a();
		}
		else if (findAndTake[0][2]) {
			answer = four.Eq4_v2();
		}
		else if (findAndTake[0][4]) {
			answer = four.Eq4_d();
		}
		else if (findAndTake[0][0]) {
			answer = four.Eq4_t();
			answer2 = four.Eq4_t2();
		}
		System.out.println("Chose Eq4");
	}

	public void choose_Eq5 () {

		if (findAndTake[0][2]) {
			answer = five.Eq5_v2();
		}
		else if (findAndTake[0][1]) {
			answer = five.Eq5_v1();
		}
		else if (findAndTake[0][3]) {
			answer = five.Eq5_a();
		}
		else if (findAndTake[0][4]) {
			answer = five.Eq5_d();
		}
		System.out.println("Chose Eq5");
	}

	public void choose_Forces(double f,double m,double a) {

		if (findAndTake[0][5]) {
			answer = fNet.Eq6_f(m, a);
		}
		else if (findAndTake[0][6]) {
			answer = fNet.Eq6_m(f, a);
		}
		else if (findAndTake[0][7]) {
			answer = fNet.Eq6_a(f, m);
		}
		System.out.println("Chose forces");
	}
}

