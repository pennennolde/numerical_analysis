package math2;

public class WinterReport2015_GeometricSeries {

	public static void main(String[] args) {

		// SOR法の一般解がZの等比級数で表されたため等比級数の様子を確認する(初期値0-vectorのとき)


		double E = 1.0;
		double T = 0.5;
		//double ω = 1.0;


		for(double ω=0.0;   ω<2.1; ω+=0.1) {

			double Z = ω*T + (1.0-ω)*E;
			System.out.println("○ ω= " + ω);
			System.out.println("    Z= " + Z);
			System.out.println();

			double x_old = 0.0;

			for(double m=0.0; m<10.0; m+=1.0) {
				double x_m = 0.0;
				for(double i=0.0; i<(m+1); i+=1.0) {
					x_m += Math.pow(Z, i);
				}
				//System.out.println("x_" + (int)(m+1) + "= " + x_m);
				System.out.print(x_m/x_old + ",");
				x_old = x_m;
			}
			System.out.println();
			System.out.println();

		}

	}
}
