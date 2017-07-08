package math2;

public class WinterReport2015_Inv {

	public static void main(String[] args) {

		// 条件数κ も求める

		double A[][] = {{6.0, 1.0, 1.0, 1.0, 0.0},
				{1.0, 7.0, 1.0, 1.0, 1.0},
				{0.0, 1.0, 8.0, 1.0, 1.0},
				{0.0, 0.0, 1.0, 9.0, 1.0},
				{0.0, 0.0, 0.0, 1.0, 10.0}};

		System.out.println("κ_∞(A)= " + Calc.Condition_Number(A));

	}
}
