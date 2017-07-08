package math;

public class SummerReport2015 {

	public static void main(String[] args) {

		// 複素ニュートン法
		// f(x)= x^2+1

		Complex x0 = new Complex(18.0, -66.0);
		double ε = 1.0e-24;
		int Nmax = 100;

		Complex xk = x0;
		System.out.println("初期値x_0= " + xk);

		for(int k=0; k<=Nmax; k++) {
			if(k==Nmax) {
				System.out.println("収束しませんでした.");
				break;
			}
			Complex xk1 = Complex.sub(xk, Complex.div(func1(xk), func2(xk)));
			System.out.println("x_" + (k+1) +"= " + xk1);
			if(
					//Complex.abs(func1(xk1))<ε					// 残差
					Complex.abs(Complex.div(Complex.sub(xk, xk1), xk1))<ε				// 相対誤差
																						) {
				System.out.print("許容誤差内に収まりました. ");
				System.out.println("近似解は x_" +(k+1) + " になります.");
				break;
			}
			xk = xk1;
		}
		System.out.println("終了します.");
	}

	static Complex func1(Complex x) {
		Complex y = Complex.mul(x, x);
		y.re += 1.0;
		return y;
	}

	static Complex func2(Complex x) {
		Complex y = x;
		Complex z = new Complex(2.0, 0.0);
		y = Complex.mul(y, z);
		/*
		 * Complex y = x;
		 * y.re *= 2.0;
		 * y.im *= 2.0;
		 * return y;
		 * ではダメ。xにもyと同様の操作がかかってしまう → 参照とかの問題?
		 */
		return y;
	}

}
