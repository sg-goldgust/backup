package chapter05;

import util.Matrix;

public class MatrixEx4 {

	public static void main(String[] args) {
		double []v = { 1, 2, 3, 4, 5, 6, 
					   7, 8, 9 ,10, 11, 12 };
		
		double [][] m = Matrix.toMatrix(v, 3, 4);
		Matrix.print(m);
		

	}

}
