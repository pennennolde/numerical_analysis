package math;

public class ZenkiTest {

	public static void main(String[] args) {

		/*
		double d = 1.0;
		double k;
		for(int i=0; i<20; i++) {
			k = i+1;
			for(int j=i+1; j>1; j--) {
				k *= j-1;
			}
			System.out.println(k);
			d += 1.0/k;
		}
		System.out.println();
		System.out.println(d);
		*/

		/*
		float d = 1.0f;
		float k;
		for(int i=0; i<20; i++) {
			k = i+1;
			for(int j=i+1; j>1; j--) {
				k *= j-1;
			}
			System.out.println(k);
			d += 1.0/k;
		}
		System.out.println();
		System.out.println(d);
		*/


		//ここから

		/*
		// step 1
		double z = 100.65625;
		int x = (int) z;
		double y = z - x;

		// step 2
		int[] a = new int[20];

		int n =0;

		for( int i = 0; i <a.length; i++) {
			a[i] = x%4;
			x = x/4;
			if( x<4) {
				a[i+1] = x;
				n = i+1;
				break;
			}
		}

		// step 3
		int[] b = new int[20];

		for( int i = 0; i < b.length; i++) {
			b[i] = (int)(y*4);
			y = y*4 - b[i];
		}

		// step 4
		while( n >= 0 ) {
			System.out.print(a[n]);
			n--;
		}

		System.out.print(".");

		for( int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
		*/

		/*
		int[] a = new int[7]; //2進数の整数部分
		int[] b = new int[5]; //2進数の小数部分

		a[0] = 1; // 0の位
		a[1] = 1; // 2の位
		a[2] = 1;
		a[3] = 1;
		a[4] = 1;
		a[5] = 1;
		a[6] = 1;

		b[0] = 0; // 0の位
		b[1] = 0; // (1/2)の位
		b[2] = 1;
		b[3] = 0;
		b[4] = 1;

		//整数部分
		double[] y = new double[7];
		y[6] = a[6];
		for( int k = 5; k >= 0; k--) {
			y[k] = y[k+1]*2+a[k];
		}
		System.out.println( y[0] );

		//少数部分
		double[] z = new double[5];
		z[4] = b[4];
		for( int k =3; k >= 0; k--) {
			z[k] = z[k+1]/2+b[k];
		}
		System.out.println( z[0] );

		// 解
		double A = y[0] + z[0];
		System.out.println( "A="+A );
		*/


		/*
		double z = 120;


		System.out.println( Integer.toHexString( (int)z ));



		int x = (int)z;
		double y = z-x;

		// 整数部分
		int a[] = new int[20];
		int i1 = 0;

		while( x>0 ) {
			int w = x%16;
			if( w<10 ) {
				a[i1] = w;
			}else{
				a[i1] = HexaDecimal(w);
			}
			x = x/16;
			i1++;
		}
		i1--;

		// 少数部分
		int b[] = new int[20];
		int i2 = 0;

		while( y>0 ) {
			int w = (int)(y*16);
			if( w<10 ) {
				b[i2] = w;
			} else {
				b[i2] = HexaDecimal(w);
			}
			y = y*16-w;
			i2++;
		}
		i2--;

		// 出力
		while( i1>=0 ) {
			if( a[i1]<10 ) {
				System.out.print(a[i1]);
			} else {
				System.out.print((char)a[i1]);
			}
			i1--;
		}
		System.out.print(".");
		for( int k=0; k<=i2; k++) {
			if( b[k]<10 ) {
				System.out.print(b[k]);
			} else {
				System.out.print((char)b[k]);
			}
		}
	}


	static char HexaDecimal(int x) {
		char y = 'X';
		if( x==10) y = 'A';
		else if( x==11) y = 'B';
		else if( x==12) y = 'C';
		else if( x==13) y = 'D';
		else if( x==14) y = 'E';
		else if( x==15) y = 'F';
		else System.out.println("例外が発生しました。");
		return y;
		*/

		/*
		double[] F = new double[71];
		F[0] = 0.0;
		F[1] = 1.0;
		for(int n=0; n<=68; n++) {
			F[n+2] = F[n+1]+F[n];
		}
		System.out.println("F[70]= " + F[70]);
		System.out.println();
		*/

		/*
		double a = 1.0e-9;
		double b = 9.999e-10;
		System.out.println("絶対誤差：" + Math.abs(a-b));
		System.out.println("相対誤差：" + Math.abs((a-b)/a));
		*/

		/*
		double en = 1.0;
		double en1=1.0;
		double val = 1.0;
		int iter = 0;
		while(en>0) {
			iter++;
			System.out.print(iter + " ");
			val = val*iter;
			en1 = en + Math.pow(1.5, iter)/val;
			if(en==en1) {
				System.out.println("終り");
				System.out.println("en= " + en);
				System.out.println("en1= " + en1);
				break;
			}
			en = en1;
		}
		*/


		/*
		double x0 = -2.0;
		double ε = 1.0e-12;
		int Nmax = 200;

		double xk = x0;
		System.out.println("初期値x_0= " + xk);

		for(int k=0; k<=Nmax; k++) {
			if(k==Nmax) {
				System.out.println("収束しませんでした.");
				break;
			}
			double xk1 = xk-func1(xk)/func2(xk);
			System.out.println("x_" + (k+1) +"= " + xk1);
			if(
					Math.abs(func1(xk1))<ε					// 残差
					//Math.abs((xk-xk1)/xk1)<ε				// 相対誤差
																						) {
				System.out.print("許容誤差内に収まりました. ");
				System.out.println("近似解は x_" +(k+1) + " になります.");
				break;
			}
			xk = xk1;
		}
		System.out.println("終了します.");
	}

	static double func1(double x) {
		//double y = x*x*x -4.0*x*x +13.0*x/4.0 -3.0/4.0;
		//double y = Math.sin(x)/(x-1.0);
		double y = x*x*x*x -13.0*x*x*x/2.0 +15.0*x*x -14.0*x +4;
		return y;
	}

	static double func2(double x) {
		//double y = 3.0*x*x -8.0*x +13.0/4.0;
		//double y = (Math.cos(x)*(x-1.0)-Math.sin(x))/Math.pow(x-1.0, 2.0);
		double y = 4.0*x*x*x -39.0*x*x/2.0 +30.0*x -14.0;
		return y;
	}
	*/




		double x0 = 1.0;
		double x1 = 1.5;
		double ε = 1.0e-12;
		int Nmax = 200;

		double xk = x0;
		double xk1 = x1;
		System.out.println("初期値x_0= " + xk);
		System.out.println("初期値x_1= " + xk1);

		for(int k=0; k<=Nmax; k++) {
			if(k==Nmax) {
				System.out.println("収束しませんでした.");
				break;
			}
			//double xk2 = xk-func(xk)*(xk-xk1)/(func(xk)-func(xk1));
			double xk2 = xk1-func(xk1)*(xk-xk1)/(func(xk)-func(xk1));
			System.out.println("x_" + (k+2) + "= " + xk2);
			if(
					//Math.abs(func(xk2))<ε					// 残差
					Math.abs((xk1-xk2)/xk2)<ε		// 相対誤差
																					) {
				System.out.print("許容誤差内に収まりました. ");
				System.out.print("近似解はx_" + (k+2) + "になります. ");
				System.out.println((k+1) + "回反復しました.");
				break;
			}
			xk = xk1;
			xk1 = xk2;
		}
		System.out.println("終了します.");
	}

	static double func(double x) {
		//double y = x*x*x -4.0*x*x +13.0*x/4.0 -3.0/4.0;
		double y = 4.0*x*x*x -39.0*x*x/2.0 +30.0*x -14.0;
		return y;
	}


}

