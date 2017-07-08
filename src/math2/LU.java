package math2;

public class LU {

	public static void main(String[] args) {
		// Gaussの消去法に a_ik=α_ik をつけたし、A=LU をつくる

		double A[][] = {{2.0, -1.0, 2.0},
										{-4.0, 4.0, -5.0},
										{6.0, -7.0, 10.0}};

		// double b[] = {7.0, 7.0, 7.0};

		double α = 0.0;
		for(int k=0; k<A.length; k++) {
			for(int i=k+1; i<A.length; i++) {
				α = A[i][k]/A[k][k];
				A[i][k] = α;													// ←これをつけたした
				for(int j=k+1; j<A.length; j++) {
					A[i][j] = A[i][j]-α*A[k][j];
				}
				// b[i] = b[i]-α*b[k];
			}
		}

		System.out.println("A= ");
		Calc.printMat(A);
		// System.out.println();
		// System.out.print("b= ");
		// Calc.printVec(b);

	}
}
