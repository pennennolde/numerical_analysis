package math;

public class SummerReport2015Zettaigosa {

	public static void main(String[] args) {

		// 複素ニュートン法を施した結果を吟味する用の絶対誤差を求める

		Complex[] X = new Complex[20];
		X[0] = new Complex(18.0, -66.0);
		X[1] = new Complex(8.998076923076923, -33.00705128205128);
		X[2] = new Complex(4.495194544944267, -16.517626026389436);
		X[3] = new Complex(2.2399273062236937, -8.286996361626047);
		X[4] = new Complex(1.104765667032712, -4.199725744534351);
		X[5] = new Complex(0.523091452008488, -2.211212973634807);
		X[6] = new Complex(0.21088888028560215, -1.3197431813215608);
		X[7] = new Complex(0.046411484491337085, -1.0292999862630907);
		X[8] = new Complex(0.001346784748073121, -0.9994313979625);
		X[9] = new Complex(-7.652139888765421E-7, -0.9999992532843972);
		X[10] = new Complex(5.713976410531127E-13, -0.999999999999986);
		X[11] = new Complex(-7.976961473594871E-27, -1.0);
		//X[12] = new Complex(0.0, 1.0);


		for(int i=0; i<12; i++) {
			Complex x = X[i];
			Complex α = new Complex(0.0, 1.0); // ここに真の解αを代入
			Complex a = Complex.sub(x, α);
			System.out.println("絶対誤差 |x_" + i + " -α|= " + Complex.abs(a));
		}

	}
}
