package math2;

public class WinterReport2015_2 {

	public static void main(String[] args) {


		// べき乗法 → 絶対値最大の固有値を求める
		// たぶんできてる

		int N = 100000;
		double ε = 1.0e-10;


		// T= -D^(-1)*(E+F) // Jacobi
		/*
		double T[][] = {{0.0, -1.0/6.0, -1.0/6.0, -1.0/6.0, 0.0},
				{-1.0/7.0, 0.0, -1.0/7.0, -1.0/7.0, -1.0/7.0},
				{0.0, -1.0/8.0, 0.0, -1.0/8.0, -1.0/8.0},
				{0.0, 0.0, -1.0/9.0, 0.0, -1.0/9.0},
				{0.0, 0.0, 0.0, -1.0/10.0, 0.0}};
				*/

		//System.out.println("matNorm1= " + Calc.matNorm1(T));
		//System.out.println("matNormInf= " + Calc.matNormInf(T));



		double T[][] = new double[5][5]; // T= -(D+E)^(-1)*F // Gauss-Seidel

		// -(D+E)^(-1)
		double Inv[][] = {{-0.16666666666666666, 0.0, 0.0, 0.0, 0.0},
											{0.023809523809523808, -0.14285714285714285, 0.0, 0.0, 0.0},
											{-0.002976190476190476, 0.017857142857142856, -0.125, 0.0, 0.0},
											{3.3068783068783067E-4, -0.001984126984126984, 0.013888888888888888, -0.1111111111111111, 0.0},
											{-3.3068783068783064E-5, 1.984126984126984E-4, -0.0013888888888888887, 0.01111111111111111, -0.1}};

		double F[][] = {{0.0, 1.0, 1.0, 1.0, 0.0},
										{0.0, 0.0, 1.0, 1.0, 1.0},
										{0.0, 0.0, 0.0, 1.0, 1.0},
										{0.0, 0.0, 0.0, 0.0, 1.0},
										{0.0, 0.0, 0.0, 0.0, 0.0}};

		T = Calc.multipleMat(Inv, F);
		//Calc.printMat(T);

		// このGauss-Seidel法の反復行列TからSOR法の反復行列ZをつくりTに代入して2Normを計算
		for(double ω=0.1; ω<2.1; ω+=0.1) {
			//System.out.println("ω= " + ω);


		double Z[][] = new double[5][5];
		for(int i=0; i<T.length; i++) {
			for(int j=0; j<T.length; j++) {
				Z[i][j] = ω*T[i][j];
			}
		}
		for(int i=0; i<T.length; i++) {
			Z[i][i] = Z[i][i]+(1.0-ω);
		}
		for(int i=0; i<T.length; i++) {
			for(int j=0; j<T.length; j++) {
				T[i][j] = Z[i][j];
			}
		}


		// 行列の2ノルム
				double T2[][] = new double[T.length][T.length];	// 特に共役じゃない転置行列
				for(int i=0; i<T.length; i++) {
					for(int j=0; j<T.length; j++) {
						T2[i][j] = T[j][i];
					}
				}
				T = Calc.multipleMat(T2, T);  //(A*)*(A)



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
				//System.out.println("breakします。");
				break;
			}
			for(int i=0; i<T.length; i++) {
				x_old[i] = x_new[i];
			}
			λ_old = λ_new;
			iter++;
		}

		if( iter==N ) {
			//System.out.println("収束しませんでした。");
		}


		double x_norm2 = Calc.vecNorm2(x_new);
		for(int i=0; i<T.length; i++) {
			x_new[i] /= x_norm2;
		}

		//System.out.println("反復回数: iter= " + iter);
		//System.out.println("絶対値最大固有値: λ_new=" + Math.abs(λ_new));
		//System.out.print("固有ベクトル: x[]_new= ");
		//Calc.printVec(x_new);
		//System.out.println();

		//System.out.println("2-Norm = " + Math.pow(Math.abs(λ_new), 0.5));
		System.out.print(Math.pow(Math.abs(λ_new), 0.5) + ",");

		}

	}
}
