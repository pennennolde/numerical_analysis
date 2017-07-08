package math2;

public class WinterReport2015_Z {

	public static void main(String[] args) {

		// Z = ωT + (1-ω)I をパラメータω毎に求める

		double D[][] = {{6.0, 0.0, 0.0, 0.0, 0.0},
										{0.0, 7.0, 0.0, 0.0, 0.0},
										{0.0, 0.0, 8.0, 0.0, 0.0},
										{0.0, 0.0, 0.0, 9.0, 0.0},
										{0.0, 0.0, 0.0, 0.0, 10.0}};

		double E[][] = {{0.0, 0.0, 0.0, 0.0, 0.0},
				{1.0, 0.0, 0.0, 0.0, 0.0},
				{0.0, 1.0, 0.0, 0.0, 0.0},
				{0.0, 0.0, 1.0, 0.0, 0.0},
				{0.0, 0.0, 0.0, 1.0, 0.0}};

		double F[][] = {{0.0, 1.0, 1.0, 1.0, 0.0},
			{0.0, 0.0, 1.0, 1.0, 1.0},
			{0.0, 0.0, 0.0, 1.0, 1.0},
			{0.0, 0.0, 0.0, 0.0, 1.0},
			{0.0, 0.0, 0.0, 0.0, 0.0}};

		// (D+E)^(-1)
		double Inv[][] = Calc.LU_Inverse(Calc.addMat(D, E));

		double T[][] = Calc.multipleMat(Inv, F);
		for(int i=0; i<T.length; i++) {
			for(int j=0; j<T.length; j++) {
				T[i][j] = -1*T[i][j];
			}
		}


		for(double ω=0.0; ω<2.1; ω+=0.1) {

			System.out.println("ω= " + ω);
			double Z1[][] = new double[T.length][T.length];
			for(int i=0; i<T.length; i++) {
				for(int j=0; j<T.length; j++) {
					Z1[i][j] = ω*T[i][j];
				}
			}
			double Z2[][] = new double[T.length][T.length];
			for(int i=0; i<T.length; i++) {
				for(int j=0; j<T.length; j++) {
					if( i==j ) {
						Z2[i][j] = 1.0-ω;
					}else if( i!=j ) {
						Z2[i][j] = 0.0;
					}
				}
			}
			double Z[][] = Calc.addMat(Z1, Z2);
			//System.out.print(/*"matNorm1= " + */Calc.matNorm1(Z));
			//System.out.print(/*"matNormInf= " + */Calc.matNormInf(Z));
			//System.out.print(",");

			// Zの共役転置行列
			double Zt[][] = new double[Z.length][Z.length];
			for(int i=0; i<T.length; i++) {
				for(int j=0; j<T.length; j++) {
					Zt[i][j] = Z[j][i];
					}
				}

			double W[][] = new double[Z.length][Z.length];
			W = Calc.multipleMat(Zt, Z);

			// べき乗法 → 絶対値最大の固有値を求める
			// たぶんできてる

			int N = 10000000;
			double ε = 1.0e-10;

			double x_old[] = new double[W.length];
			double x_new[] = new double[W.length];
			int iter = 0;
			int ell = 0;
			double norm = 0.0;
			double λ_old = 0.0;
			double λ_new = 0.0;

			for(int i=0; i<W.length; i++) {
				x_old[i] = Math.random();
			}

			while( iter<N) {
				double x_norm2 = Calc.vecNorm2(x_old);
				for(int i=0; i<W.length; i++) {
					x_old[i] /= x_norm2;
				}
				for(int i=0; i<W.length; i++) {
					x_new[i] = Calc.matVec(W, x_old)[i];
				}
				for(int i=0; i<W.length; i++) {
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
				for(int i=0; i<W.length; i++) {
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
			//System.out.println("絶対値最大固有値: λ_new=" + Math.abs(λ_new));
			//System.out.print("固有ベクトル: x[]_new= ");
			//Calc.printVec(x_new);
			//System.out.println();

			System.out.print(Math.pow(Math.abs(λ_new), 0.50) + ",");
			System.out.println();


		}



	}
}
