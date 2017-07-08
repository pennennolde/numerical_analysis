package math2;

public class ComplexTest {

	public static void main(String[] args) {


	}
}


class Complex {

	double re = 0.0;
	double im = 0.0;

	// コンストラクタ
	public Complex(double a, double b) {
		this.re = a;
		this.im = b;
	}

	// 複素数表示
	public String toString() {
		return re+"+("+im+")i";
	}

	// 加算 a+b
	static Complex add(Complex a, Complex b) {
		Complex y = new Complex(0.0, 0.0);
		y.re = a.re+b.re;
		y.im = a.im+b.im;
		return y;
	}

	// 減算 a-b
	static Complex sub(Complex a, Complex b) {
		Complex y = new Complex(0.0, 0.0);
		y.re = a.re-b.re;
		y.im = a.im-b.im;
		return y;
	}

	// 乗算 a*b
	static Complex mul(Complex a, Complex b) {
		Complex y = new Complex(0.0, 0.0);
		y.re = a.re*b.re - a.im*b.im;
		y.im = a.re*b.im + a.im*b.re;
		return y;
	}

	// 除算 a/b
	static Complex div(Complex a, Complex b) {
		Complex y = new Complex(0.0, 0.0);
		y = mul(a, con(b));
		y.re = y.re/(mul(b, con(b)).re);
		y.im = y.im/(mul(b, con(b)).re);
		return y;
	}

	// 複素共役を返す
	static Complex con(Complex x) {
		Complex y = new Complex(0.0, 0.0);
		y.re = x.re;
		y.im = -x.im;
		return y;
	}

	// 絶対値を返す
	static double abs(Complex x) {
		double y = Math.sqrt(x.re*x.re+x.im*x.im);
		return y;
	}

}
