package util;

public class Matrix {
	public static double[][] unit(int n) {
		double[][] m = new double[n][n];
		
		for(int i =0; i <m[0].length; i++ ) {
			m[i][i] = 1;
		}
		return m;
	}
	
	public static double[][] trans(double[][] m) {
		double[][] t = new double[m[0].length][m.length];
		
		// 전치 행렬 만들기
		for(int y =0; y<m.length; y++) {
			for(int x=0; x<m[y].length; x++) {
				t[x][y] = m[y][x];
			}
		}
		return t;
	}
	
	public static void print(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
		}
		System.out.println();
	}
	
	public static void print(double[][] arr) {
		for(int y=0; y<arr.length; y++) {
			print(arr[y]);
		}
	}

	public static double[][] prod(double[][] mA, double[][] mB) {
		double [][]mC = new double[mA.length][mB[0].length];
		
        for(int i=0;i<mC.length;i++){
            for(int j=0;j<mC[0].length;j++){
                for(int k=0;k<mA[0].length;k++){
                    mC[i][j]+=mA[i][k]*mB[k][j];
                }
            }
        }		
		
		return mC;
	}

	public static double[][] toMatrix(double[] v, int r, int c) {
		double [][]m = new double[r][c];
		
		for(int i = 0; i <v.length; i++) {
			int y = i / c;
			int x = i % c;
			m[y][x] = v[i];
		}
		return m;
	}
	
	
}



