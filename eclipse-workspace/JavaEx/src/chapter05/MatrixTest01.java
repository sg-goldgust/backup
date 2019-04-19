package chapter05;


import java.util.Scanner;

import util.Matrix;
import util.UArray;

public class MatrixTest01 {

	public static void main(String[] args) {
		
		System.out.print("숫자 : ");

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		double[][] unit = Matrix.unit(n);
		Matrix.print(unit);
		// UArray.print(unit);

	}
}
