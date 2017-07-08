package math2;

public class LU2 {

	public static void main(String[] args) {

		// A=LU と分解し、(1)前進代入(Ly=b) と 、(2)後退代入(Ux=y) の2段階の代入法を行い解xを求める

		double A[][] = {{2.0, -1.0, 2.0},
										{-4.0, 4.0, -5.0},
										{6.0, -7.0, 10.0}};

		double b[] = {7, 7, 7};


		// LU分解
		double α = 0.0;
		for(int k=0; k<A.length; k++) {
			for(int i=k+1; i<A.length; i++) {
				α = A[i][k]/A[k][k];
				A[i][k] = α;
				for(int j=k+1; j<A.length; j++) {
					A[i][j] = A[i][j]-α*A[k][j];
				}
				// b[i] = b[i]-α*b[k];
			}
		}


		// (1)前進代入 Ly=b
		for(int k=0; k<A.length; k++) {		// bをyとして使う
			for(int j=0; j<k; j++) {
				b[k] = b[k]-A[k][j]*b[j];
			}
			// b[k] = b[k]/A[k][k];					// ←これはいらない!! Lの対角成分は1!! (実装上は違う値が入っているけど)
		}

		// (2)後退代入 Ux=y
		for(int k=A.length-1; k>=0; k--) {
			for(int j=k+1; j<A.length; j++) {
				b[k] = b[k]-A[k][j]*b[j];
			}
			b[k] = b[k]/A[k][k];
		}

		System.out.println("x= ");
		Calc.printVec(b);
		// 演算回数も考えてみる
		// 解がでたら必ず残差2-ノルムで検証

	}
}
