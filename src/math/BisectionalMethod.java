package math;

public class BisectionalMethod {

	public static void main(String[] args) {

		/*
		 * 計算が終了したときの区間は、
		 * |b-a|/2^(n+1) <ε
		 * 与えられたεに対し、この式を満たす最小のnが2分法で必要な計算回数
		 */

		double a0 = -3.0;
		double b0 = 0.0;
		double ε = 1.0e-12;
		int iter = 0;

		double a = a0;
		double b = b0;
		double c = 0.0;
		System.out.println("初期値 a= " + a + ", b= " + b);

		while(Math.abs(b-a)/2 >= ε) {
			iter++;
			System.out.print(iter + "回目 ");
			c = (a+b)/2;
			System.out.println("c= " + c);
			double P = func(a)*func(c);
			if(P>0) {
				a=c;
			} else if(P<0) {
				b=c;
			} else if(P==0.0) {
				break;
			}
		}
		System.out.println("許容誤差内に収まりました.");
		System.out.print("近似解は " + c + " です. ");
		System.out.println(iter + "回反復しました.");
		System.out.println("|f(x)|= " + Math.abs(c*c*c -2.0*c*c -c +2.0));
		System.out.println("終了します.");
		System.out.println(Math.log10(2.0));
	}

	static double func(double x) {
		double y = x*x*x -2.0*x*x -x +2.0;
		return y;

	}
}
