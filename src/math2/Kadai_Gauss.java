package math2;

public class Kadai_Gauss {

	public static void main(String[] args) {

		/* A, b の作成、保管用のoriginA, originb の作成 */
		int n = 500;													// 行列サイズ
		double A[][] = new double[n][n];
		double b[] = new double[n];
		double originA[][] = new double[n][n];
		double  originb[] = new double[n];


		for(int r=0; r<100; r++) {							//A_r*x=b_r  r個の方程式を解く

			for(int i=0; i<A.length; i++) {
				for(int j=0; j<A.length; j++) {
					A[i][j] = Math.random();
					originA[i][j] = A[i][j];
				}
				b[i] = Math.random();
				originb[i] = b[i];
			}


			/* Gaussの消去法(Pivot選択なし) */
			// 前進消去過程
			double α = 0.0;													// α= (a_ik)/(a_kk)
			for(int k=0; k<A.length-1; k++) {					// a_kk をピボット?とする
				for(int i=k+1; i<A.length; i++) {				// a_kk についての計算を i 行で
					α = A[i][k]/A[k][k];
					for(int j=k+1; j<A.length; j++) {			// a_kk についての計算を i 行 j 列で
						A[i][j] = A[i][j]-α*A[k][j];
					}
					b[i] = b[i]-α*b[k];
				}
			}
			// 後退代入過程
			for(int k=A.length-1; k>=0; k--) {
				for(int j=A.length-1; j>k; j--) {
					b[k] = b[k] -A[k][j]*b[j];
				}
				b[k] = b[k]/A[k][k];
			}

			/* 残差2ノルム ||b-Ax||_2 を算出 */
			System.out.print("x_" +(r+1) + "= ");
			System.out.println(Calc.vecNorm2(Calc.residual(originA, b, originb)));


			/* A, b を初期値に戻す */
			for(int i=0; i<A.length; i++) {
				for(int j=0; j<A.length; j++) {
					A[i][j] = originA[i][j];
				}
				b[i] = originb[i];
			}



			/* 部分Pivot選択付きGaussの消去法 */
			int l = 0;													// Pivotの行番号
			double temp = 0.0;		// Pivot選択、入れ替え時の一時保管用
			// 前進消去過程
			α = 0.0;													// α= (a_ik)/(a_kk)
			for(int k=0; k<A.length-1; k++) {					// a_kk をピボット?とする
				// Pivot選択用に追加
				temp = Math.abs(A[k][k]);
				l = k;
				for(int i=k+1; i<A.length; i++) {				// Pivotの選択
					if(temp < Math.abs(A[i][k])) {				// 選択したものをtempに入れるだけで、行列の中身は変えていない
						temp = Math.abs(A[i][k]);
						l = i;
					}
				}
				if(Math.abs(A[k][k]) < 1.0e-10) {			// Pivotの例外処理
					System.out.println("Pivot= " + A[k][k]);
					System.out.println("絶対値最大成分が0または非常に小さいので、解けないと判断します。");
					break;
				}
				for(int j=k; j<A.length; j++) {				// k行目とl行目を入れ替える
					temp = A[l][j];
					A[l][j] = A[k][j];
					A[k][j] = temp;
				}
				temp = b[l];													// bの入れ替えも忘れずに
				b[l] = b[k];
				b[k] = temp;
				// 通常の消去
				for(int i=k+1; i<A.length; i++) {				// a_kk についての計算を i 行で
					α = A[i][k]/A[k][k];
					for(int j=k+1; j<A.length; j++) {			// a_kk についての計算を i 行 j 列で
						A[i][j] = A[i][j]-α*A[k][j];
					}
					b[i] = b[i]-α*b[k];
				}
			}
			// 後退代入過程
			for(int k=A.length-1; k>=0; k--) {
				for(int j=A.length-1; j>k; j--) {
					b[k] = b[k] -A[k][j]*b[j];
				}
				b[k] = b[k]/A[k][k];
			}

			/* 残差2ノルム ||b-Ax||_2 を算出 */
			System.out.print("x_" + (r+1) + "= ");
			System.out.println(Calc.vecNorm2(Calc.residual(originA, b, originb)));

			System.out.println();


		}
	}
}
