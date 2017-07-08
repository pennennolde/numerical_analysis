package math;

public class ParallelChord {

	public static void main(String[] args) {

		double x0 = 5.0;
		double ε = 1.0e-10;
		int Nmax = 50;

		double xk = x0;
		System.out.println("初期値x_0= " + xk);

		for(int k=0; k<=Nmax; k++) {
			if(k==Nmax) {
				System.out.println("収束しませんでした.");
				break;
			}
			double xk1 = xk-func1(xk)/func2(x0);
			System.out.println("x_" + (k+1) +"= " + xk1);
			if(
					//Math.abs(func1(xk1))<ε					// 残差
					Math.abs((xk-xk1)/xk1)<ε				// 相対誤差
																						) {
				System.out.print("許容誤差内に収まりました. ");
				System.out.println("近似解は x_" +(k+1) + " になります.");
				break;
			}
			xk = xk1;
		}
		System.out.println("終了します.");
	}

	static double func1(double x) {
		//double y = x*x*x -4.0*x*x +13.0*x/4.0 -3.0/4.0;
		double y = Math.sin(x)/(x-1.0);
		return y;
	}

	static double func2(double x) {
		//double y = 3.0*x*x -8.0*x +13.0/4.0;
		double y = (Math.cos(x)*(x-1.0)-Math.sin(x))/Math.pow(x-1.0, 2.0);
		return y;
	}
}
