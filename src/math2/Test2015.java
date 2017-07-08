package math2;

public class Test2015 {

	public static void main(String[] args) {


		// System.out.println(String.format("%1$3e", x));


		//問題1(1)
		/*
		double A[][] = new double[100][100];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				A[i][j] = Math.sqrt(2.0*(i+1.0)+(j+1.0));
			}
		}
		System.out.println(String.format("%1$3e", Calc.matNorm1(A)));
		System.out.println(String.format("%1$3e", Calc.matNormInf(A)));
		System.out.println(Calc.matNorm1(A));
		System.out.println(Calc.matNormInf(A));
		*/

		/*
		double x[] = new double[100];
		double sum = 0.0;
		for(int i=0; i<x.length; i++) {
			x[i] = i+1.0;
				sum += Math.pow(x[i], 3.0);
		}
		System.out.println(String.format("%1$3e", Math.pow(sum, 1.0/3.0)));
		System.out.println(1.0/3.0);
		*/


		/*
		double A[][] = {{-1.1, 2.2, 3.3},
				{4.4, -5.5, 6.6},
				{7.7, 8.8, -9.9}};
		Calc.printMat(Calc.LU_Inverse(A));
		double AInv[][] = new double[3][3];
		AInv = Calc.LU_Inverse(A);
		Calc.printMat(AInv);
		System.out.println(AInv[0][0]+AInv[1][1]+AInv[2][2]);
		*/


		/*

		int n = 7;				// 行列サイズ
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

		double κ = 0.0;
		κ = (Calc.matNorm1(A))*(Calc.matNorm1(Calc.LU_Inverse(A)));
		System.out.println(String.format("%1$3e", κ));

		double x1[] = Calc.PivotGauss(A, b);
		double RelativeError1 = Calc.vecNorm1(Calc.subVec(x_star, x1))/Calc.vecNorm1(x_star);
		System.out.println(String.format("%1$3e", RelativeError1));

		double Δb[] = new double[n];
		Δb[0] = 0.001*b[0];
		double x2[] = new double[n];
		x2 = Calc.PivotGauss(A, Calc.addVec(b, Δb));
		double RelativeError1_2 = Calc.vecNorm1(Calc.subVec(x_star, x2))/Calc.vecNorm1(x_star);
		System.out.println(String.format("%1$3e", RelativeError1_2));

		*/


		for(int n=3; n<100; n++) {


		double A[][] = new double[n][n];
		double b[] = new double[n];
		double x0[] = new double[n];
		for(int i=0; i<n; i++) {
			b[i] = 1.0;
			x0[i] = 0.0;
			for(int j=0; j<n; j++) {
				if( i==j ) {
					A[i][j] = n;
				} else if( i>j ) {
					A[i][j] = -1.0;
				} else if( i<j ) {
					A[i][j] = 1.0;
				}
			}
		}
		double ε = 1.0e-10;
		int N = 1000;

		//for(double ω=0.0; ω<2.1; ω+=0.1) { // ω0.1ごとの反復
		int m = 0;
		double x_new[] = x0.clone(); // こちらが主役。i1回ずつ書き換えられてく
		double x_old[] = x0.clone();   // 収束判定のみに使う
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
		System.out.println("n=" + n);
		System.out.println("反復回数 m= " + m);
		System.out.print("近似解x= ");
		Calc.printVec(x_new);





		/*
		int m = 0;
		double x_old[] = x0.clone();
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

			/* 収束判定 全12通り */
			/*// 誤差1-ノルム
			double AbsoluteError1 = Calc.vecNorm1(Calc.subVec(x_new, x_old));
			if( AbsoluteError1<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 誤差2-ノルム
			double AbsoluteError2 = Calc.vecNorm2(Calc.subVec(x_new, x_old));
			if( AbsoluteError2<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 誤差∞-ノルム
			double AbsoluteErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old));
			if( AbsoluteErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 残差1-ノルム
			double AbsoluteResidual1 = Calc.vecNorm1(Calc.residual(A, x_new, b));
			if( AbsoluteResidual1<ε ) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 残差2-ノルム
			double AbsoluteResidual2 = Calc.vecNorm2(Calc.residual(A, x_new, b));
			if( AbsoluteResidual2<ε ) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 残差∞-ノルム
			double AbsoluteResidualInf = Calc.vecNormInf(Calc.residual(A, x_new, b));
			if( AbsoluteResidualInf<ε ) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対誤差1-ノルム
			double RelativeError1 = Calc.vecNorm1(Calc.subVec(x_new, x_old))/Calc.vecNorm1(x_new);
			if( RelativeError1<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対誤差2-ノルム
			double RelativeError2 = Calc.vecNorm2(Calc.subVec(x_new, x_old))/Calc.vecNorm2(x_new);
			if( RelativeError2<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			///*
		/*
			// 相対誤差∞-ノルム
			double RelativeErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old))/Calc.vecNormInf(x_new);
			if( RelativeErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			 //*/
			/*// 相対残差1-ノルム
			double RelativeResidual1 = Calc.vecNorm1(Calc.residual(A, x_new, b))/Calc.vecNorm1(b);
			if( RelativeResidual1<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対残差2-ノルム
			double RelativeResidual2 = Calc.vecNorm2(Calc.residual(A, x_new, b))/Calc.vecNorm2(b);
			if( RelativeResidual2<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対残差∞-ノルム
			double RelativeResidualInf = Calc.vecNormInf(Calc.residual(A, x_new, b))/Calc.vecNormInf(b);
			if( RelativeResidualInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			*/

		/*
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

		int n = 100;
		double A[][] = new double[n][n];
		double b[] = new double[n];
		double x0[] = new double[n];
		for(int i=0; i<n; i++) {
			b[i] = 1.0;
			x0[i] = 0.0;
			for(int j=0; j<n; j++) {
				if( i==j ) {
					A[i][j] = n;
				} else if( i>j ) {
					A[i][j] = -1.0;
				} else if( i<j ) {
					A[i][j] = 1.0;
				}
			}
		}
		double ε = 1.0e-10;
		int N = 1000;

		for(double ω=0.0; ω<2.1; ω+=0.1) { // ω0.1ごとの反復


		// Step: 1
		double x_0[] = new double[A.length];
		for(int i=0; i<A.length; i++) {
			x_0[i] = 0.0;
		}



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

			/* 収束判定 全12通り */
			/*// 誤差1-ノルム
			double AbsoluteError1 = Calc.vecNorm1(Calc.subVec(x_new, x_old));
			if( AbsoluteError1<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 誤差2-ノルム
			double AbsoluteError2 = Calc.vecNorm2(Calc.subVec(x_new, x_old));
			if( AbsoluteError2<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 誤差∞-ノルム
			double AbsoluteErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old));
			if( AbsoluteErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 残差1-ノルム
			double AbsoluteResidual1 = Calc.vecNorm1(Calc.residual(A, x_new, b));
			if( AbsoluteResidual1<ε ) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 残差2-ノルム
			double AbsoluteResidual2 = Calc.vecNorm2(Calc.residual(A, x_new, b));
			if( AbsoluteResidual2<ε ) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 残差∞-ノルム
			double AbsoluteResidualInf = Calc.vecNormInf(Calc.residual(A, x_new, b));
			if( AbsoluteResidualInf<ε ) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対誤差1-ノルム
			double RelativeError1 = Calc.vecNorm1(Calc.subVec(x_new, x_old))/Calc.vecNorm1(x_new);
			if( RelativeError1<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対誤差2-ノルム
			double RelativeError2 = Calc.vecNorm2(Calc.subVec(x_new, x_old))/Calc.vecNorm2(x_new);
			if( RelativeError2<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			///*
			// 相対誤差∞-ノルム
		/*
			double RelativeErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old))/Calc.vecNormInf(x_new);
			if( RelativeErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			 //*/
			/*// 相対残差1-ノルム
			double RelativeResidual1 = Calc.vecNorm1(Calc.residual(A, x_new, b))/Calc.vecNorm1(b);
			if( RelativeResidual1<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対残差2-ノルム
			double RelativeResidual2 = Calc.vecNorm2(Calc.residual(A, x_new, b))/Calc.vecNorm2(b);
			if( RelativeResidual2<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			/*// 相対残差∞-ノルム
			double RelativeResidualInf = Calc.vecNormInf(Calc.residual(A, x_new, b))/Calc.vecNormInf(b);
			if( RelativeResidualInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			*/

			/*
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
		*/


		}

	}
}
