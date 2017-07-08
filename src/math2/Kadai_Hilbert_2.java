package math2;

public class Kadai_Hilbert_2 {

	public static void main(String[] args) {


		//int n = 5;
		for(int n=5; n<20; n+=5) {

			System.out.println("n= " + n);

			double A[][] = new double[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					A[i][j] = 1.0/((i+1.0)+(j+1.0)-1.0);
				}
			}
			double xstar[] = new double[n];
			for(int i=0; i<n; i++) {
				xstar[i] = 1.0;
			}
			double b[] = new double[n];
			for(int i=0; i<n; i++) {
				b[i] = Calc.matVec(A, xstar)[i];
			}

			System.out.println(Calc.vecNormInf(Calc.subVec(b, Calc.matVec(A, Calc.PivotGauss(A, b)))));

		}

	}
}
