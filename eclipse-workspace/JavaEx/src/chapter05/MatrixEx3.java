package chapter05;

import util.Matrix;

public class MatrixEx3 {

	public static void main(String[] args) {
		double [][]mA = {
				{1, 2, 3},
				{4, 5, 6}
		};
		double [][]mB = {
				{10, 20},
				{30, 40},
				{50, 60},
		};
		
		double [][]mC = Matrix.prod(mA, mB);
		System.out.println("행렬 A");
		Matrix.print(mA);
		System.out.println("행렬 B");
		Matrix.print(mB);
		System.out.println("행렬 C");
		Matrix.print(mC);

	}

}
