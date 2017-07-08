package math;

public class Secant {

	public static void main(String[] args) {

		double x0 = 5.0;
		double x1 = 6.0;
		double ε = 1.0e-10;
		int Nmax = 50;

		double xk = x0;
		double xk1 = x1;
		System.out.println("初期値x_0= " + xk);
		System.out.println("初期値x_1= " + xk1);

		for(int k=0; k<=Nmax; k++) {
			if(k==Nmax) {
				System.out.println("収束しませんでした.");
				break;
			}
			//double xk2 = xk-func(xk)*(xk-xk1)/(func(xk)-func(xk1));
			double xk2 = xk1-func(xk1)*(xk-xk1)/(func(xk)-func(xk1));
			System.out.println("x_" + (k+2) + "= " + xk2);
			if(
					//Math.abs(func(xk2))<ε					// 残差
					Math.abs((xk1-xk2)/xk2)<ε		// 相対誤差
																					) {
				System.out.print("許容誤差内に収まりました. ");
				System.out.print("近似解はx_" + (k+2) + "になります. ");
				System.out.println((k+1) + "回反復しました.");
				break;
			}
			xk = xk1;
			xk1 = xk2;
		}
		System.out.println("終了します.");
	}

	static double func(double x) {
		//double y = x*x*x -4.0*x*x +13.0*x/4.0 -3.0/4.0;
		double y = Math.sin(x)/(x-1.0);
		return y;
	}

}
