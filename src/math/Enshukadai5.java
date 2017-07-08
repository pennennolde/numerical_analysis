package math;

public class Enshukadai5 {

	public static void main(String[] args) {

		// 演習課題5 非線型方程式の数値解法

		// f(x) = sinx/(x-1)
		// g(x) = (x-1)^4

//問1

		/*
		//Newton法
		// 相対誤差による収束判定
		double x0 = -5.0;
		double e = 1.0e-10;
		int Nmax = 50;

		double xk = x0;

		for( int k=0; k<=Nmax; k++) {
			System.out.println("反復"+ (k+1));
			double xk1 = xk - f1(xk)/f2(xk);
			if( Math.abs( (xk1-xk)/xk1)<e ) {
				System.out.println( xk1 );
				break;
			}
			xk = xk1;
		}
		System.out.println("終了");
	}

	static double f1(double x) {
		double y = Math.sin(x)/(x-1);
		return y;
	}

	static double f2(double x) {
		double y = ((x-1)*Math.cos(x)-Math.sin(x))/Math.pow((x-1), 2);
		return y;
	}
		 */


		/*
		// Secant法
		// 相対誤差による収束判定法
		double x0 = 5.0;
		double x1 = 6.0;
		double e = 1.0e-10;
		int Nmax = 50;

		double xk0 = x0;
		double xk1 = x1;
		int iter = 0;

		while( iter <= Nmax) {
			double xk02 = xk1;
			xk1 = xk1 - func(xk1)*(xk0-xk1)/(func(xk0)-func(xk1));
			xk0 = xk02;
			iter++;
			if( Math.abs((xk1-xk0)/xk1)<e ) {
				break;
			}
		}

		if( iter==(Nmax+1)) {
			System.out.println("収束しない");
		} else {
			System.out.println("反復回数 : " + iter);
			System.out.println("近似解 : " + xk1);
		}
	}

	static double func(double x) {
		double y = Math.sin(x)/(x-1);
		return y;
	}
		 */

		/*
		//ParallelCode法
		// 相対誤差による収束判定法
		double x0 = -5.0;
		double e = 1.0e-10;
		int Nmax = 50;

		double xk = x0;
		int iter = 0;

		while( iter<=Nmax ) {
			double xk0 = xk;
			xk = xk - f(xk)/f1(x0);
			iter++;
			if(Math.abs((xk-xk0)/xk)<e) {
				break;
			}
		}

		if( iter==(Nmax+1)) {
			System.out.println("収束しない");
		} else {
			System.out.println("反復回数 : " + iter);
			System.out.println("近似解 : " + xk);
		}
	}

	static double f(double x) {
		double y = Math.sin(x)/(x-1);
		return y;
	}

	static double f1(double x) {
		double y = ((x-1)*Math.cos(x)-Math.sin(x))/Math.pow((x-1), 2);
		return y;

	}
	*/


//問2

		//Newton法
		// 相対誤差による収束判定
		double x0 = 5.0;
		double e = 1.0e-10;
		int Nmax = 50;
		double α =6.283185307179586;

		double xk = x0;

		for( int k=0; k<=Nmax; k++) {
			System.out.println("反復"+ (k+1));
			double xk1 = xk - f1(xk)/f2(xk);
			System.out.print("|e_" + (k+1) +"| = ");
			System.out.printf("%e%n", Math.abs(xk1-α));  //指数形式で出力
			if( Math.abs( (xk1-xk)/xk1)<e ) {
				System.out.println( xk1 );
				break;
			}
			xk = xk1;
		}
		System.out.println("終了");
	}

	static double f1(double x) {
		double y = Math.sin(x)/(x-1);
		return y;
	}

	static double f2(double x) {
		double y = ((x-1)*Math.cos(x)-Math.sin(x))/Math.pow((x-1), 2);
		return y;
	}


}
