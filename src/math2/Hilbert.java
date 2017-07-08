package math2;

public class Hilbert {

	public static void main(String[] args) {

		// Hilbert行列 A=(a_ij), a_ij=1/(i+j-1) を作成

		int n = 5;				// 行列サイズ

		double A[][] = new double[n][n];

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = 1.0/((i+1)+(j+1)-1.0);
			}
		}

		Calc.printMat(A);

	}
}
