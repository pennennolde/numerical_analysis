package math2;

public class Condition_Number {

	public static void main(String[] args) {

		// 条件数 κ_∞(A) = (||A||_∞)*(||A^(-1)||_∞)

		double A[][] = {{6, 1, 1, 1, 0},
										{1, 7, 1, 1, 1},
										{0, 1, 8, 1, 1},
										{0, 0, 1, 9, 1},
										{0, 0, 0, 1, 10}};

		double κ = Calc.Condition_Number(A);

		System.out.println("Condition_Number = " + κ);



		/*
		int n = A.length;

		double E[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) {
					E[i][j] = 1.0;
				} else {
					E[i][j] = 0.0;
				}
			}
		}

		double originA[][] = new double[n][n];		// 後であってるか確認するための
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				originA[i][j] = A[i][j];
			}
		}


		// LU分解
		double α = 0.0;
		for(int k=0; k<n; k++) {
			for(int i=k+1; i<n; i++) {
				α = A[i][k]/A[k][k];
				A[i][k] = α;
				for(int j=k+1; j<n; j++) {
					A[i][j] = A[i][j]-α*A[k][j];
				}
				// b[i] = b[i]-α*b[k];
			}
		}
		Calc.printMat(A);
		System.out.println();



		// XとYを用いず、AとEだけで行う方法

		for(int i=0; i<n; i++) {

			// (1)前進代入 Ly=b → Ly_i=e_i
			for(int k=0; k<n; k++) {
				for(int j=0; j<k; j++) {
					E[k][i] = E[k][i]-A[k][j]*E[j][i];
				}
			}

			// (2)後退代入 Ux=y → Ux_i=y_i
			for(int k=n-1; k>=0; k--) {
				for(int j=k+1; j<n; j++) {
					E[k][i] = E[k][i]-A[k][j]*E[j][i];
				}
				E[k][i] = E[k][i]/A[k][k];
			}

		}

		System.out.println(Calc.matNormInf(E)*Calc.matNormInf(originA));
		*/

	}
}
