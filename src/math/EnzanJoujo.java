package math;

public class EnzanJoujo {

	public static void main(String[] args) {

		/*
		 * 	3/4を記述する
		 * 	→3/4と書くと、int型なので0になっていしまう。
		 * 	→3.0/4.0と書かなくてはならない。
		 */

		double x =3.0;
		double y =4.0;
		int a = 3;
		int b = 4;
		System.out.println(func1(x));
		System.out.println(func2(x));
		System.out.println(func3(x));
		System.out.println(func4(x));
		System.out.println(func5(x));
		System.out.println(x/y);
		System.out.println(a/b);
	}

	static double func1(double x) {
		double y = 13.0/4.0*x;
		return y;
	}

	static double func2(double x) {
		double y = 13*x/4; //おうけい
		return y;
	}
	static double func3(double x) {
		double y = (13*x)/4; //おうけい
		return y;
	}

	static double func4(double x) {
		double y = (13/4)*x; //ダメ
		return y;
	}

	static double func5(double x) {
		double y = x*x*x -4.0*x*x +(13.0*x)/4.0 -3.0/4.0;
		return y;
	}



}
