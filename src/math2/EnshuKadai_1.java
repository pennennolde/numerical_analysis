package math2;

public class EnshuKadai_1 {

	// import math.Complex ？

	public static void main(String[] args) {

		/* 後期演習課題1 */

		// 問題1
		System.out.println("問題1: ");
		double x1[] = {1.0, -2.0, 3.0, -4.0};
		System.out.println("||x1||_1 = " + Calc.vecNorm1(x1));
		System.out.println("||x1||_2 = " + Calc.vecNorm2(x1));
		System.out.println("||x1||_∞ = " + Calc.vecNormInf(x1));
		System.out.println();

		// 問題2
		System.out.println("問題2: ");
		double A1[][] = {{1.0, -1.0}, {2.0, 0.0}, {0.0, -2.0}};
		System.out.println("||x1||_1 = " + Calc.matNorm1(A1));
		//System.out.println("||x1||_2 = " + Calc.matNorm2(A1));
		System.out.println("||x1||_∞ = " + Calc.matNormInf(A1));
		System.out.println();


		// 問題3
		System.out.println("問題3: ");
		// ベクトルx2を配列x2に定義
		Complex x2[] = new Complex[3];
		x2[0] = new Complex(1.0, 1.0);
		x2[1] = new Complex(2.0, -2.0);
		x2[2] = new Complex(0.0, -1.0);
		// ベクトルx2の各値の絶対値を配列x2absに定義
		double x2abs[] = new double[3];
		x2abs[0] = Complex.abs(x2[0]);
		x2abs[1] = Complex.abs(x2[1]);
		x2abs[2] = Complex.abs(x2[2]);

		/*
		 *  Norm計算に使われるのは複素数の絶対値のみなので
		 *   絶対値を入れた配列をCalcメソッドに渡せばいける
		 */
		System.out.println("vecNorm1 = " + Calc.vecNorm1(x2abs));
		System.out.println("vecNorm2 = " + Calc.vecNorm2(x2abs));
		System.out.println("vecNormInf = " + Calc.vecNormInf(x2abs));

		//System.out.println(Calc.vecNorm1(x2)); ←これはできない。Calcが複素数に対応していないから
		// import math.Complex ？

		// 問題3 Ver.2
		System.out.println();
		// Norm1は絶対値の列和
		double sum = x2abs[0] + x2abs[1] + x2abs[2];
		System.out.println("vecNorm1 = " + sum);

		// 2NormはEuclidNorm
		double vecNorm2 = Math.sqrt(Math.pow(x2abs[0], 2.0)+Math.pow(x2abs[1], 2.0)+Math.pow(x2abs[2], 2.0));
		System.out.println("vecNorm2 = " + vecNorm2);

		// ∞Normは絶対値の最大行
		double vecNormInf = 0.0;
		for(int i=0; i<x2abs.length; i++) {
			if(vecNormInf<x2abs[i]) {
				vecNormInf = x2abs[i];
			}
		}
		System.out.println("vecNormInf = " + vecNormInf);
		System.out.println();


		// 問題4
		System.out.println("問題4");
		Complex A2[][] = new Complex[2][2];
		A2[0][0] = new Complex(2.0, 0.0);
		A2[0][1] = new Complex(1.0, -1.0);
		A2[1][0] = new Complex(1.0, 1.0);
		A2[1][1] = new Complex(0.0, -2.0);
		double A2abs[][] = new double[2][2];
		A2abs[0][0] = Complex.abs(A2[0][0]);
		A2abs[0][1] = Complex.abs(A2[0][1]);
		A2abs[1][0] = Complex.abs(A2[1][0]);
		A2abs[1][1] = Complex.abs(A2[1][1]);
		System.out.println("||A2||_1 = " + Calc.matNorm1(A2abs));
		// matNorm2だけ複雑
		System.out.println("||A2||_2 = " + "ルートmax{|λ|} : λは(A*A)の固有値(A*はAの共役転置行列)");
		System.out.println("||A2||_∞ = " + Calc.matNormInf(A2abs));
		System.out.println();


		// 問題5
		System.out.println("問題5");
		double x3[] = new double[100];
		for(int i=0; i<x3.length; i++) {
			x3[i] = Math.pow((i+1.0), 0.50);
		}
		System.out.println("||x3||_1 = " + Calc.vecNorm1(x3));
		System.out.println("||x3||_2 = " + Calc.vecNorm2(x3));
		System.out.println("||x3||_∞ = " + Calc.vecNormInf(x3));
		System.out.println();
		// System.out.println(1/2); ←注意：(1/2)=0 ※intのわり算だから


		// 問題6
		System.out.println("問題6");
		double A3[][] = new double[100][100];
		for(int i=0; i<A3.length; i++) {
			for(int j=0; j<A3.length; j++) {
				A3[i][j] = Math.pow((2.0*(i+1.0)+(j+1.0)), 0.50);
			}
		}
		System.out.println("||A3||_1 = " + Calc.matNorm1(A3));
		System.out.println("||A3||_∞ = " + Calc.matNormInf(A3));

	}
}
