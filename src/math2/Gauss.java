package math2;

public class Gauss {

	public static void main(String[] args) {
		// 連立一次方程式 Ax=b を解く
		// 前進消去と後退代入をあわせ、Gaussの消去法を完成させる

		double A[][] = {{1.0, 2.0, 1.0, 2.0, 1.0},
										{2.0, 3.0, 2.0, 3.0, 2.0},
										{1.0, 2.0, 3.0, 4.0, 5.0},
										{4.0, 3.0, 8.0, 1.0, 2.0},
										{8.0, 2.0, 4.0, 1.0, 9.0}};

		double b[] = {7.0, 7.0, 7.0, 7.0, 7.0};

		int n = 0;		// 四則演算の回数を記録する

		// 前進消去過程
		double α = 0.0;													// α= (a_ik)/(a_kk)
		for(int k=0; k<A.length; k++) {					// a_kk をピボット?とする
			for(int i=k+1; i<A.length; i++) {				// a_kk についての計算を i 行で
				α = A[i][k]/A[k][k];
				n++;
				for(int j=k+1; j<A.length; j++) {			// a_kk についての計算を i 行 j 列で
					A[i][j] = A[i][j]-α*A[k][j];
					n += 2;
				}
				b[i] = b[i]-α*b[k];
				n += 2;
			}
		}
		System.out.println("A= ");
		Calc.printMat(A);
		System.out.println();
		System.out.print("b= ");
		Calc.printVec(b);
		System.out.println();
		System.out.println("以上で四則演算を " + n + " 回しました。");
		System.out.println();

		// 後退代入過程
		for(int k=A.length-1; k>=0; k--) {
			for(int j=A.length-1; j>k; j--) {
				b[k] = b[k] -A[k][j]*b[j];
			}
			b[k] = b[k]/A[k][k];
		}
		System.out.print("x= ");
		Calc.printVec(b);

	}
}
