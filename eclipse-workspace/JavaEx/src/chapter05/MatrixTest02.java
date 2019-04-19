package chapter05;

import util.UArray;
import util.Matrix;

public class MatrixTest02 {
	public static void main(String[] args) {
		double[][] m = {
				{ 1, 2, 3},
		//		{ 4, 5, 6},
		//		{ 7, 8, 9},
		};
		Matrix.print(m);
		System.out.println();
		
		double [][]t = Matrix.trans(m);
		
		Matrix.print(t);
		
	}
	
}
