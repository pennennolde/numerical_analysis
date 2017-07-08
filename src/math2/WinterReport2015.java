package math2;

public class WinterReport2015 {

	public static void main(String[] args) {

		/* Jacobi法 */

		/*
		 * A = D + E + F
		 *     =(対角)+(下三角)+(上三角)
		 *
		 * x_(m+1) = -D^(-1)*(E+F)*x_(m) + D^(-1)*b
		 *
		 * 反復行列 T= -D^(-1)*(E+F)
		 */


		double A[][] = {{6.0, 1.0, 1.0, 1.0, 0.0},
				{1.0, 7.0, 1.0, 1.0, 1.0},
				{0.0, 1.0, 8.0, 1.0, 1.0},
				{0.0, 0.0, 1.0, 9.0, 1.0},
				{0.0, 0.0, 0.0, 1.0, 10.0}};

		double b[] = {9.0, 11.0, 11.0, 11.0, 11.0};


		// Step: 1
		double x_0[] = new double[A.length];
		for(int i=0; i<A.length; i++) {
			x_0[i] = 0.0;
		}
		double ε = 1.0e-10;
		int N = 100;

		double AbsoluteError2old = 0.0;


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

			/* 収束判定 全12通り */
			/*// 誤差1-ノルム
			double AbsoluteError1 = Calc.vecNorm1(Calc.subVec(x_new, x_old));
			if( AbsoluteError1<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
			///*// 誤差2-ノルム
			double AbsoluteError2 = Calc.vecNorm2(Calc.subVec(x_new, x_old));
			System.out.println(AbsoluteError2/AbsoluteError2old);
			AbsoluteError2old = AbsoluteError2;
			if( AbsoluteError2<ε) {
				System.out.println("breakしました。");
				System.out.println("m= " + m);
			//	break;
			}
			 //*/
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
			/*
			// 相対誤差∞-ノルム
			double RelativeErrorInf = Calc.vecNormInf(Calc.subVec(x_new, x_old))/Calc.vecNormInf(x_new);
			if( RelativeErrorInf<ε) {
				System.out.println("breakしました。");
				break;
			}
			 */
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

	}
}
