package math2;

public class PivotGauss {

	public static void main(String[] args) {
		// 連立一次方程式 Ax=b を解く
		// 部分Pivot選択付きGaussの消去法

		double A[][] = {{1.0, 2.0, 1.0, 2.0, 1.0},
										{2.0, 3.0, 2.0, 3.0, 2.0},
										{1.0, 2.0, 3.0, 4.0, 5.0},
										{4.0, 3.0, 8.0, 1.0, 2.0},
										{8.0, 2.0, 4.0, 1.0, 9.0}};

		double b[] = {7.0, 7.0, 7.0, 7.0, 7.0};

		int l = 0;													// Pivotの行番号
		double temp = 0.0;		// Pivot選択、入れ替え時の一時保管用


		// 前進消去過程
		double α = 0.0;													// α= (a_ik)/(a_kk)
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
		System.out.println("A= ");
		Calc.printMat(A);
		System.out.println();
		System.out.print("b= ");
		Calc.printVec(b);
		System.out.println();

		// 後退代入過程
		for(int k=A.length-1; k>=0; k--) {
			for(int j=A.length-1; j>k; j--) {
				b[k] = b[k] -A[k][j]*b[j];
			}
			b[k] = b[k]/A[k][k];
		}
		System.out.print("x= ");
		Calc.printVec(b);


	}
}
