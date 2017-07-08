package math2;

public class Kakomon2014 {

	public static void main(String[] args) {

		/*
		 * 指数表記で出力
		 * System.out.println(String.format("%1$3e", x));
		 */








		// 問題1(1)
		double x[] = new double[49];
		for(int i=0; i<x.length; i++) {
			x[i] = Math.sqrt(i+1.0);
		}
		System.out.println("[1](1) ||x||_2= " + Calc.vecNorm2(x));
		System.out.println(String.format("%1$3e", Calc.vecNorm2(x)));
		System.out.println();

		// 問題1(2)
		double A[][] = new double[100][100];
		double sum = 0.0;
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				A[i][j] = (i+1.0)+(j+1.0);
				sum += Math.pow(A[i][j], 2.0);
			}
		}
		System.out.println("[1](2) ||A||_F= " + Math.sqrt(sum));
		System.out.println(String.format("%1$3e", Math.sqrt(sum)));
		System.out.println();


		/*
		 * ユークリッドノルム ⇔ フロベニウスノルム
		 * は、「自然なノルム」ではない。
		 * 自然なノルム⇔||A||=sup(x!=0)[(||Ax||/||x||)]
		 * 単位行列Iに対しては、||I||=1 となるもの
		 */












		/*
		// 問題2
		int n = 6;				// 行列サイズ
		// Hilbert行列A
		double A[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = 1.0/((i+1)+(j+1)-1.0);
			}
		}
		double x_star[] = new double[n];			// 真の解＝要素がすべて1
		for(int i=0; i<n; i++) {
			x_star[i] = 1.0;
		}
		double b[] = new double[n];
		b = Calc.matVec(A, x_star);

		// (1)
		double κ = Calc.Condition_Number(A);
		System.out.print("[2](1) ");
		System.out.println("Condition_Number = " + κ);

		// (2)
		double x_tilde[] = new double[n];
		x_tilde = Calc.PivotGauss(A, b);
		// 相対誤差∞-ノルム
		double RelativeErrorInf = Calc.vecNormInf(Calc.subVec(x_star, x_tilde))/Calc.vecNormInf(x_star);
		System.out.println("[2](2) = " + RelativeErrorInf);

		// (3)
		double Δb[] = new double[n];
		Δb[0] = 0.001*b[0];
		double x2[] = new double[n];
		x2 = Calc.PivotGauss(A, Calc.addVec(b, Δb));
		// 相対誤差∞-ノルム
		double RelativeErrorInf2 = Calc.vecNormInf(Calc.subVec(x_star, x2))/Calc.vecNormInf(x_star);
		System.out.println("[2](3) = " + RelativeErrorInf2);
		*/









		/*
		// 問題3
		double A[][] = {{1.0, -2.0, 2,0},
				{-1.0, 1.0, -1.0},
				{-2.0, -2.0, 1.0}};
		double b[] = {1.0, 1.0, 1.0};
		// Step: 1
		double x_0[] = new double[A.length];
		for(int i=0; i<A.length; i++) {
			x_0[i] = 0.0;
		}
		double ε = 1.0e-12;
		int N = 50;
		*/

		/*
		System.out.println("[3](1)");
		// Step: 2
		int m = 0;
		double x_old[] = x_0.clone();
		double x_new[] = new double[A.length];
		double sum;
		while(true) {
			for(int i=0; i<A.length; i++) {
				sum = 0.0;
				for(int j=0; j<A.length; j++) {
					if( i!=j ) {
						sum += A[i][j]*x_old[j];
					}
				}
				x_new[i] = (b[i]-sum)/A[i][i];
			}
			m++;
			// 相対誤差∞-ノルム
			double RelativeErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old))/Calc.vecNormInf(x_new);
			if( RelativeErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			if( m==N ) {
				System.out.println("収束しません。");
				break;
			}
			for(int k=0; k<A.length; k++) {
				x_old[k] = x_new[k];
			}
		}
		// Step: 3
		System.out.println("反復回数 m= " + m);
		System.out.print("近似解x= ");
		Calc.printVec(x_new);
		System.out.println();
		*/


		/*
		System.out.println("[3](2)");
		// Step: 2
		int m = 0;
		double x_new[] = x_0.clone(); // こちらが主役。i1回ずつ書き換えられてく
		double x_old[] = x_0.clone();   // 収束判定のみに使う
		double sum;

		while(true) {
			for(int i=0; i<A.length; i++) {
				sum = 0.0;
				for(int j=0; j<A.length; j++) {
					if( i!=j ) {
					sum += A[i][j]*x_new[j];
					}
				}
				x_new[i] = (b[i]-sum)/A[i][i];
			}
			m++;
			// 相対誤差∞-ノルム
			double RelativeErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old))/Calc.vecNormInf(x_new);
			if( RelativeErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			if( m==N ) {
				System.out.println("収束しません。");
				break;
			}
			for(int k=0; k<A.length; k++) {
				x_old[k] = x_new[k];
			}
		}
		// Step: 3
		System.out.println("反復回数 m= " + m);
		System.out.print("近似解x= ");
		Calc.printVec(x_new);
		*/









		/*


		// 問題4
		System.out.println("[4]");
		double A[][] = {{0.0, -1.0, 2.0},
				{-4.0, 5.0, 6.0},
				{8.0, 9.0,10.0}};
		double b[] = {3.0, 7.0, 11.0};

		// Step: 1
		double x_0[] = new double[A.length];
		for(int i=0; i<A.length; i++) {
			x_0[i] = 0.0;
		}
		double ε = 1.0e-8;
		int N = 50;

		// Step: 2
		int m = 0;
		double x_old[] = x_0.clone();
		double x_new[] = new double[A.length];
		double sum;

		while(true) {
			for(int i=0; i<A.length; i++) {
				sum = 0.0;
				for(int j=0; j<A.length; j++) {
					if( i!=j ) {
						sum += A[i][j]*x_old[j];
					}
				}
				x_new[i] = (b[i]-sum)/A[i][i];
				System.out.println("A[i][i]= " + A[i][i]);
				System.out.print("x_new = ");
				Calc.printVec(x_new);
			}
			m++;
			// 相対誤差2-ノルム
			double RelativeError2 = Calc.vecNorm2(Calc.subVec(x_new, x_old))/Calc.vecNorm2(x_new);
			System.out.println("vecNorm2(Calc.subVec(x_new, x_old)) = " + Calc.vecNorm2(Calc.subVec(x_new, x_old)));
			System.out.println("vecNorm2(x_new) = "+ Calc.vecNorm2(x_new));
			System.out.println("RelativeError2 = " + RelativeError2);
			if( RelativeError2<ε) {
				System.out.println("breakしました。");
				break;
			}
			if( m==N ) {
				System.out.println("収束しません。");
				break;
			}
			for(int k=0; k<A.length; k++) {
				x_old[k] = x_new[k];
			}
		}

		// Step: 3
		System.out.println("反復回数 m= " + m);
		System.out.print("近似解x= ");
		Calc.printVec(x_new);

		*/









		/*

		// 問題5
		double A[][] = new double[100][100];
		double b[] = new double[100];
		for(int i=0; i<b.length; i++) {
			b[i] = 1.0;
		}



		for(int l=1; l<10; l++) {
		double a = (l+1.0);


		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				if( i==j ) {
					A[i][j] = a;
				} else if( Math.abs(i-j)==1 ) {
					A[i][j] = 4.0;
				}
			}
		}

		for(double ω=0.0; ω<2.1; ω+=0.1) { // ω0.1ごとの反復
			System.out.println("a= " + a);


		// Step: 1
		double x_0[] = new double[A.length];
		for(int i=0; i<A.length; i++) {
			x_0[i] = 0.0;
		}
		double ε = 1.0e-8;
		int N = 500;


		// Step: 2
		int m = 0;
		double x_new[] = x_0.clone(); // こちらが主役。i1回ずつ書き換えられてく
		double x_old[] = x_0.clone();   // SOR法では、収束判定だけでなく反復式にも使う
		double sum;
		//double ω = 0.0; // SOR法のパラメータ

		while(true) {
			for(int i=0; i<A.length; i++) {
				sum = 0.0;
				for(int j=0; j<A.length; j++) {
					if( i!=j ) {
					sum += A[i][j]*x_new[j];
					}
				}
				x_new[i] = (b[i]-sum)/A[i][i];
				x_new[i] = (1.0-ω)*x_old[i] + ω*x_new[i];
			}
			m++;

			// 相対誤差∞-ノルム
			double RelativeErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old))/Calc.vecNormInf(x_new);
			if( RelativeErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}

			if( m==N ) {
				System.out.println("収束しません。");
				break;
			}
			for(int k=0; k<A.length; k++) {
				x_old[k] = x_new[k];
			}
		}


		// Step: 3
		System.out.println("ω= " + ω);
		System.out.println("反復回数 m= " + m);
		System.out.print("近似解x= ");
		Calc.printVec(x_new);
		System.out.println();


		}

		}
		*/







		// 問題6

		/*
		double A[][] = new double[100][100];

		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				if( i==j ) {
					A[i][j] = 4.0;
				} else if( Math.abs(i-j)==1 ) {
					A[i][j] = 2.0;
				} else if( Math.abs(i-j)==2 ) {
					A[i][j] = 1.0;
				}
			}
		}
		double AInv[][] = new double[100][100];
		AInv = Calc.LU_Inverse(A);
		double trA = 0.0;
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				if( i==j ) {
					trA += AInv[i][j];
				}
			}
		}
		System.out.print("[6]= ");
		System.out.println(String.format("%1$3e", trA));
		*/



	}
}
