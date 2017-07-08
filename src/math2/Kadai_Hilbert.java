package math2;

public class Kadai_Hilbert {

	public static void main(String[] args) {

		// 演習課題4 : 連立一次方程式の解きにくさ

		int n = 10;				// 行列サイズ
		System.out.println("n= " + n);
		System.out.println();
		// Hilbert行列A
		double A[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = 1.0/((i+1.0)+(j+1.0)-1.0);
			}
		}


		/* (1) */
		System.out.println("(1)");
		double κ = Calc.Condition_Number(A);
		System.out.println("Condition_Number = " + κ);
		System.out.println();


		/* (2) */
		System.out.println("(2)");
		double x_star[] = new double[n];			// 真の解＝要素がすべて1
		for(int i=0; i<n; i++) {
			x_star[i] = 1.0;
		}
		double b[] = new double[n];
		b = Calc.matVec(A, x_star);
		System.out.print("残差ノルム : ||b-Ax_1||_∞ = ");
		System.out.println(Calc.vecNormInf(Calc.residual(A, Calc.PivotGauss(A, b), b)));
		System.out.print("誤差ノルム : ||x_star-x_1||_∞ = ");
		System.out.println(Calc.vecNormInf(Calc.subVec(x_star, Calc.PivotGauss(A, b))));
		System.out.println();


		/* (3) */
		System.out.println("(3)");
		double Δb[] =new double[n];
		Δb[0] = 0.001*b[0];
		System.out.print("解に含まれる誤差の上限 : κ_∞(A)*(||Δb||_∞)/(||b||_∞) = ");
		System.out.println(κ*((Calc.vecNormInf(Δb))/(Calc.vecNormInf(b))));
		System.out.println();


		/* (4) */
		System.out.println("(4)");
		// Ax=b+Δb を部分Pivot選択付きGaussの消去法で
		System.out.print("誤差ノルム : ||x_star-x_2||_∞ = ");
		System.out.println(Calc.vecNormInf(Calc.subVec(x_star, Calc.PivotGauss(A, Calc.addVec(b, Δb)))));


	}
}
