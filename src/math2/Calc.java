package math2;

public class Calc {

	// 行列,ベクトルのコンソール出力

		// ベクトルをコンソール出力
		public static void printVec(double x[]) {
			System.out.print( "( " );
			for( int i=0; i<x.length; i++) {
				System.out.print(x[i] + " ");
			}
			System.out.println( ")t");
		}

		// 行列をコンソール出力
		public static void printMat(double A[][]) {
			for( int i=0; i<A.length; i++) {
				for( int j=0; j<A[i].length; j++) {
					System.out.printf(A[i][j] + " ");
				}
				System.out.println();
			}
		}


	// ベクトルに関する演算

		// ベクトルxをスカラーc倍
		public static double[] scalarMultiple(double c, double x[]) {
			double y[] = new double[x.length];
			for(int i=0; i<x.length; i++) {
				y[i] = c*x[i];
			}
			return y;
		}

		// ベクトル同士の加算を計算
		public static double[] addVec(double x[], double y[]) {
			double z[] = new double[x.length];
			for(int i=0; i<x.length; i++) {
				z[i] = x[i]+y[i];
			}
			return z;
		}

		// ベクトル同士の減算を計算
		public static double[] subVec(double x[], double y[]) {
			double z[] = new double[x.length];
			for(int i=0; i<x.length; i++) {
				z[i] = x[i]-y[i];
			}
			return z;
		}
		// ベクトル同士の内積を計算
		public static double innProd(double x[], double y[]) {
			double z=0.0;
			for(int i=0; i<x.length; i++) {
				z += x[i]*y[i];
			}
			return z;
		}


	// 行列,ベクトルに関する演算

		// 行列Aとベクトルxの積を計算
		public static double[] matVec(double A[][], double x[]) {
			double y[] = new double[x.length];
			for( int i=0; i<x.length; i++) {
				for( int j=0; j<A[i].length; j++) {
					y[i] += A[i][j]*x[j];
				}
			}
			return y;
		}

		// 行列Aとベクトルx,bに対して残差(Ax-b)を計算
		public static double[] residual(double A[][], double x[], double b[]) {
			double y[] = new double[x.length];
			double Ax[] = new double[x.length];
			Ax = Calc.matVec(A, x);
			y = Calc.subVec(Ax, b);
			return y;
		}


	// 行列同士の演算

		// 行列同士の加算を計算
		public static double[][] addMat(double A[][], double B[][]) {
			double X[][] = new double[A.length][A[0].length];
			for(int i=0; i<A.length; i++) {
				for(int j=0; j<A[i].length; j++) {
					X[i][j] = A[i][j]+B[i][j];
				}
			}
			return X;
		}

		// 行列同士の積を計算
		public static double[][] multipleMat(double A[][], double B[][]) {
			double X[][] = new double[A.length][A[0].length];
			for(int i=0; i<A.length; i++) {
				for(int j=0; j<A[i].length; j++) {
					for(int k=0; k<B.length; k++) {
						X[i][j] += A[i][k]*B[k][j];
					}
				}
			}
			return X;
		}


	// ベクトルノルム

		// ベクトルの1ノルムを計算(最大列和)
		public static double vecNorm1(double x[]) {
			double y=0.0;
			for(int i=0; i<x.length; i++) {
				y += Math.abs(x[i]);
			}
			return y;
		}

		// ベクトルの2ノルムを計算(ユークリッドノルム)
		public static double vecNorm2(double x[]) {
			double y=0.0;
			for(int i=0; i<x.length; i++) {
				y += Math.pow(Math.abs(x[i]), 2);
			}
			y = Math.sqrt(y);
			return y;
		}

		// ベクトルの∞ノルムを計算(最大行和)
		public static double vecNormInf(double x[]) {
			double y=0.0;
			for(int i=0; i<x.length; i++) {
				y = Math.max(y, Math.abs(x[i]));
			}
			return y;
		}


	// 行列ノルム

		// 行列の1ノルムを計算(最大列和)
		public static double matNorm1(double A[][]) {
			double y=0.0;
			double X[] = new double[A[0].length];
			for(int j=0; j<A[0].length; j++) {
				for(int i=0; i<A.length; i++) {
					X[j] += Math.abs(A[i][j]);
				}
			}
			for(int k=0; k<X.length; k++) {
			y = Math.max(y, X[k]);
			}
			return y;
		}

		// 行列の2ノルムを計算(これだけ複雑)
		/*
		 *  λ を (A*A) の固有値 (A*はAの共役転置行列) とすると、
		 *  matNorm2 = (√max{|λ|})  ←(A*A)の最大固有値の絶対値のルート
		 */

		// 行列の∞ノルムを計算(最大行和)
		public static double matNormInf(double A[][]) {
			double y=0.0;
			double X[] = new double[A.length];
			for(int i=0; i<A.length; i++) {
				for(int j=0; j<A[0].length; j++) {
					X[i] += Math.abs(A[i][j]);
				}
			}
			for(int k=0; k<X.length; k++) {
			y = Math.max(y, X[k]);
			}
			return y;
		}



		// Gaussの消去法
		public static double[] Gauss(double A[][], double b[]) {
			int n = A.length;
			double A1[][] = new double[n][n];
			double b1[] = new double[n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					A1[i][j] = A[i][j];
				}
				b1[i] = b[i];
			}
			double α = 0.0;
			for(int k=0; k<n-1; k++) {  // 第k+1列目の消去を計算
				for(int i=k+1; i<n; i++) {  // i行
					α = A1[i][k]/A1[k][k];
					for(int j=k+1; j<n; j++) {  // j列
						A1[i][j] = A1[i][j] - α*A1[k][j];
					}
					b1[i] = b1[i] - α*b1[k];
				}
			}
			for(int i=n-1; i>=0; i--) {
				for(int j=n-1; j>i; j--) {
					b1[i] -= A1[i][j]*b1[j];
				}
				b1[i] = b1[i]/A1[i][i];
			}
			return b1; // 解
		}

		// LU分解
		public static double[] LU(double A[][], double b[]) {
			int n = A.length;
			double A1[][] = new double[n][n];
			double b1[] = new double[n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					A1[i][j] = A[i][j];
				}
				b1[i] = b[i];
			}
			for(int k=0; k<n-1; k++) {
				for(int i=k+1; i<n; i++) {
					A1[i][k] = A1[i][k]/A1[k][k];
					for(int j=k+1; j<n; j++) {
						A1[i][j] = A1[i][j] - A1[i][k]*A1[k][j];
					}
				}
			}
			double y[] = new double[n];
			for(int i=0; i<n; i++) {
				y[i] = b1[i];
				for(int j=0; j<i; j++) {
					y[i] -= A1[i][j]*y[j];
				}
			}
			double x[] = new double[n];
			for(int i=n-1; i>=0; i--) {
				x[i] = y[i];
				for(int j=n-1; j>i; j--) {
					x[i] -= A1[i][j]*x[j];
				}
				x[i] = x[i]/A1[i][i];
			}
			return x; // 解
		}

		// 部分Pivot選択付きGaussの消去法
		public static double[] PivotGauss(double A[][], double b[]) {
			int n=A.length;
			//A,bのコピーA1,b1をとってA,bは変化させない
			double A1[][] = new double[n][n];
			double b1[] = new double[n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					A1[i][j] = A[i][j];
				}
				b1[i] = b[i];
			}
			for(int k=0; k<n-1; k++) {
				int l=k;
				for(int i=k+1; i<n; i++) {
					double x = Math.abs(A1[l][k]);
					double y = Math.abs(A1[i][k]);
					if(x<y) {
						l = i;
					}
				}
				/*
				if(A[l][k]<10e-10) {
					System.out.println("例外処理：絶対値最大数が0または非常に小さい場合");
				}
				*/
				double temp;
				for(int j=k; j<n; j++) {
					temp = A1[k][j];
					A1[k][j] = A1[l][j];
					A1[l][j] = temp;
				}
				temp = b1[k];
				b1[k] = b1[l];
				b1[l] = temp;
				double α = 0.0;
				for(int i=k+1; i<n; i++) {
					α = A1[i][k]/A1[k][k];
					for(int j=k+1; j<n; j++) {
						A1[i][j] = A1[i][j] - α*A1[k][j];
					}
					b1[i] = b1[i] - α*b1[k];
				}
			}
			/* 後退代入ver.1 */ //＊ver.1とver.2では結果が微妙に違ってる → 丸め誤差の影響?
			/*
			double α = 0.0;
			int k = b1.length-1;
			b1[k] = b1[k]/A1[k][k];
			for(int i=k-1; i>=0; i--) {
				α = 0.0;
				for(int j=k; j>i; j--) {
					α += A1[i][j]*b1[j];
				}
				b1[i] = (b1[i]-α)/A1[i][i];
			}
			*/
			/* 後退代入ver.2 */
			for(int k=A1.length-1; k>=0; k--) {
				for(int j=A1.length-1; j>k; j--) {
					b1[k] = b1[k] -A1[k][j]*b1[j];
				}
				b1[k] = b1[k]/A1[k][k];
			}
			return b1; // 解
		}

		//LU分解を用いて AX=E を解いて A^(-1) を求める
		public static double[][] LU_Inverse(double[][] A) {
			int n = A.length;
			// Aの値は変えたくないのでAのコピーA1をつくってA1を使う
			double[][] A1 = new double[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					A1[i][j] = A[i][j];
				}
			}
			double E[][] = new double[n][n];
			for( int i=0; i<n; i++) {
				for( int j=0; j<n; j++) {
					if( i==j ) {
						E[i][j] = 1;
					} else {
						E[i][j] = 0;
					}
				}
			}
			for(int k=0; k<n-1; k++) {
				for(int i=k+1; i<n; i++) {
					A1[i][k] = A1[i][k]/A1[k][k];
					for(int j=k+1; j<n; j++) {
						A1[i][j] = A1[i][j] - A1[i][k]*A1[k][j];
					}
				}
			}
			double y[][] = new double[n][n];
			for(int a=0; a<n; a++) {
				for(int i=0; i<n; i++) {
					y[i][a] = E[i][a];
					for(int j=0; j<i; j++) {
						y[i][a] = y[i][a] - A1[i][j]*y[j][a];
					}
				}
			}
			double x[][] = new double[n][n];
			for(int a=0; a<n; a++) {
				for(int i=n-1; i>=0; i--) {
					x[i][a] = y[i][a];
					for(int j=n-1; j>i; j--) {
						x[i][a] = x[i][a]- A1[i][j]*x[j][a];
					}
					x[i][a] = x[i][a]/A1[i][i];
				}
			}
			return x;
		}

		// ∞ノルムによる条件数 κ_∞(A)=(||A||_∞)*(||A^(-1)||_∞)
		public static double Condition_Number(double[][] A) {
			double κ = 0.0;
			κ = (Calc.matNormInf(A))*(Calc.matNormInf(Calc.LU_Inverse(A)));
			return κ;
		}
		/*
		 *   ||Δx|| <= ||A^(-1)||*||Δb|| ,  ||A||*||x|| >= ||b||
		 *   ⇒  (||Δx||/||x||)  <=   κ(A) * (||Δb||/||b||)
		 *
		 *   誤差e=(x_tilde)-x ,  残差r=b-A*(x_tilde) の関係
		 *    ⇒  (||e||/||x||) <=  κ(A) * (||r||/(||A||*||x||))
		 *    また、
		 *    ⇒  (||e||/||x||) <=  κ(A) * (||r||/||b||)
		 *    ⇔ (||x-x_(tilde)||/||x||) <=  κ(A) * (||b-Ax||/||b||)
		 */

	}

