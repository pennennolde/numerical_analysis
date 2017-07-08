package math2;

public class Cholesky {

	public static void main(String[] args) {

		/* Cholesky分解 */

		double A[][] = new double[3][3];
		A[0][0] = 1.0;
		A[1][0] = 2.0;
		A[0][1] = A[1][0];
		A[1][1] = 13.0;
		A[2][0] = 4.0;
		A[0][2] = A[2][0];
		A[2][1] = 23.0;
		A[1][2] = A[2][1];
		A[2][2] = 77.0;


		double L[][] = new double[A.length][A.length];

		for(int j=0; j<A.length; j++) {
			for(int i=j; i<A.length; i++) {
				double sum = 0.0;
				for(int k=0; k<j; k++) {
				sum += L[i][k]*L[j][k];				// Ltの表現に注意
				}
				if( i==j ) {
					L[i][i] = Math.pow((A[i][i]-sum), 0.50);
				} else {
					L[i][j] = (A[i][j]-sum)/L[j][j];
				}
				// System.out.println("L[" + i + "][" + j +"]= " + L[i][j]);
			}
		}
		System.out.println();
		System.out.println("L=");
		Calc.printMat(L);
		System.out.println();

		double Lt[][] = new double[L.length][L.length];
		for(int i=0; i<L.length; i++) {
			for(int j=0; j<L.length; j++) {
				Lt[i][j] = L[j][i];
			}
		}
		System.out.println("A= L*Lt =");
		Calc.printMat(Calc.multipleMat(L, Lt));


	}
}
