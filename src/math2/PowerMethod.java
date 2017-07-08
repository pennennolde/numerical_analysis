package math2;

public class PowerMethod {

	public static void main(String[] args) {

		// べき乗法 → 絶対値最大の固有値を求める
		// たぶんできてる

		int N = 500;
		double ε = 1.0e-10;

		double T[][] = {{4, 2, 0},
										{2, 4, 1},
										{0, 1, 4}};

		double x_old[] = new double[T.length];
		double x_new[] = new double[T.length];
		int iter = 0;
		int ell = 0;
		double norm = 0.0;
		double λ_old = 0.0;
		double λ_new = 0.0;

		for(int i=0; i<T.length; i++) {
			x_old[i] = Math.random();
		}

		while( iter<N) {
			double x_norm2 = Calc.vecNorm2(x_old);
			for(int i=0; i<T.length; i++) {
				x_old[i] /= x_norm2;
			}
			for(int i=0; i<T.length; i++) {
				x_new[i] = Calc.matVec(T, x_old)[i];
			}
			for(int i=0; i<T.length; i++) {
				if( Math.abs(x_old[0]) < Math.abs(x_old[i]) ) {
					ell = i;
					x_old[0] = x_old[i];
				}
			}
			λ_new = x_new[ell]/x_old[ell];
			norm = Math.abs(λ_new - λ_old)/Math.abs(λ_new);
			if( norm<ε ) {
				System.out.println("breakします。");
				break;
			}
			for(int i=0; i<T.length; i++) {
				x_old[i] = x_new[i];
			}
			λ_old = λ_new;
			iter++;
		}

		if( iter==N ) {
			System.out.println("収束しませんでした。");
		}


		double x_norm2 = Calc.vecNorm2(x_new);
		for(int i=0; i<T.length; i++) {
			x_new[i] /= x_norm2;
		}

		System.out.println("反復回数: iter= " + iter);
		System.out.println("絶対値最大固有値: λ_new=" + λ_new);
		System.out.print("固有ベクトル: x[]_new= ");
		Calc.printVec(x_new);



	}
}
