package math;

public class EnshuKadai1 {

	public static void main(String[] args) {

		// 演習課題1 プログラミングの復習

		System.out.print("問題1 (1)  ");
		double a = 4.0;
		double b = 7.0;
		System.out.println(Math.pow(Math.pow(a, 7)/Math.pow(b, 9), 0.5));
		System.out.println();

		System.out.print("問題1 (2)  ");
		double x = Math.cos(3*Math.PI/4)-Math.pow(Math.E, 6)*Math.pow(Math.log(5), 0.5);
		System.out.println(Math.abs(x));
		System.out.println();

		System.out.println("問題2  ");
		double[] F = new double[41];
		F[0] = 0.0;
		F[1] = 1.0;
		for(int n=0; n<=38; n++) {
			F[n+2] = F[n+1]+F[n];
		}
		System.out.println("F[40]= " + F[40]);
		System.out.println();

		System.out.println("問題3  ");
		double an = 0.0;
		double s = 0.0;
		for(int n=1; n>0; n++) {
			an = 1/Math.pow(3.0, n);
			s += an;
			if(an<1.0e-5) {
				System.out.println("an= " + an);
				System.out.println("n= " + n );
				System.out.println("s= " + s);
				break;
			}
		}
		System.out.println();

		System.out.println("問題4  ");
		double e=2.0;
		double k=0.0;
		for(int n=2; n<=9; n++) {
			k = n;
			for(int i=n-1; i>0; i--) {
				k *= i;
			}
			e += 1.0/k;
		}
		System.out.println("e= " +e);
		System.out.println();

		System.out.println("問題5");
		double A[][] = new double[3][3];
		double B[][] = new double[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				A[i][j] = (i+1)+(j+1);
			}
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				B[i][j] = Math.pow((i+1)*(j+1), 0.5);
			}
		}
		System.out.println("A+B= ");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				A[i][j] += B[i][j];
				System.out.print(A[i][j] +" ");
			}
			System.out.println();
		}






	}
}
