package math2;

public class SOR {

	public static void main(String[] args) {

		/* SOR法 */  // Gauss-Seidel法にパラメータωを足した

		/*
		 * A = D + E + F
		 *     =(対角)+(下三角)+(上三角)
		 *
		 * x_(m+1) = (D+ωE)^(-1)*{(1-ω)*D -ω*F}*x_(m) + ω*(D+ω*E)^(-1)*b
		 */

		System.out.println("SOR法");
		System.out.println();

		double A[][] = {{6.0, 1.0, 1.0, 1.0, 0.0},
				{1.0, 7.0, 1.0, 1.0, 1.0},
				{0.0, 1.0, 8.0, 1.0, 1.0},
				{0.0, 0.0, 1.0, 9.0, 1.0},
				{0.0, 0.0, 0.0, 1.0, 10.0}};

		double b[] = {9.0, 11.0, 11.0, 11.0, 11.0};



		for(double ω=0.0; ω<2.1; ω+=0.1) { // ω0.1ごとの反復
			System.out.println("ω= " + ω);


			// Step: 1
			double x_0[] = new double[A.length];
			for(int i=0; i<A.length; i++) {
				x_0[i] = 0.0;
			}
			double ε = 1.0e-10;
			int N = 100;


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


		}


	}
}
