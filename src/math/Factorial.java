package math;

public class Factorial {

	public static void main(String[] args) {

		// nの階乗を計算する

		int n = 7;
		int y = 1;			// 結果

		 for(int i=0; i<n; i++) {
			 y *= n-i;
		 }
		 System.out.println(n + "!= " + y );

	}
}
