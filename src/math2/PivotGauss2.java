package math2;

public class PivotGauss2 {

	public static void main(String[] args) {
		// 部分Pivot選択付きGaussの消去法・完成見本

		double A[][] = {{1.0, 2.0, 1.0, 2.0, 1.0},
										{2.0, 3.0, 2.0, 3.0, 2.0},
										{1.0, 2.0, 3.0, 4.0, 5.0},
										{4.0, 3.0, 8.0, 1.0, 2.0},
										{8.0, 2.0, 4.0, 1.0, 9.0}};

		double b[] = {7.0, 7.0, 7.0, 7.0, 7.0};

		int l = 0;
		double α = 0.0;
		double pivot = 0.0;

		for(int k=0; k<A.length-1; k++) {
			l = k;
			pivot = Math.abs(A[k][k]);
			for(int i=k+1; i<A.length; i++) {
				if(pivot < Math.abs(A[i][k])) {
					pivot = Math.abs(A[i][k]);
					l = i;
				}
			}
			for(int j=k; j<A.length; j++) {
				pivot = A[k][j];
				A[k][j] = A[l][j];
				A[l][j] = pivot;
			}
			pivot = b[k];
			b[k] = b[l];
			b[l] = pivot;
			for(int i=k+1; i<A.length; i++) {				// a_kk についての計算を i 行で
				α = A[i][k]/A[k][k];
				for(int j=k+1; j<A.length; j++) {			// a_kk についての計算を i 行 j 列で
					A[i][j] = A[i][j]-α*A[k][j];
				}
				b[i] = b[i]-α*b[k];
			}
		}
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
