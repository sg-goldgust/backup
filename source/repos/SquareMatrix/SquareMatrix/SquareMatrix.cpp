// SquareMatrix.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include <iostream>
#include <string.h>
using namespace std;


class SquareMatrix {
private:
	int size;
	int** arr;
	//int arr[size][size];

public:
	SquareMatrix(int n);
	~SquareMatrix();

	SquareMatrix operator*(const SquareMatrix &a);
	int* operator[](int i);
	int getSize() const;
	void printMatrix();

};

//초기화
SquareMatrix::SquareMatrix(const int n) {
	size = n;
	arr = new int*[size]; //행렬 높이에 대한 

	for (int i = 0; i < n; ++i) {
		arr[i] = new int[size];
		//memset(arr[i],1,sizeof(arr));
	}
	for (int i = 0; i < size; ++i) {
		for (int j = 0; j < size; ++j) {
			arr[i][j] = 2;
		}
	}
	/*SquareMatrix::size = n;
	int arrTemp[n][n];
	SquareMatrix::arr = arrTemp;*/
}
//소멸자
SquareMatrix::~SquareMatrix() {
	for (int i = 0; i < size; i++) {
		delete[] arr[i];
	}
	delete[] arr;
}

//size getter
int SquareMatrix::getSize() const {
	return size;
}

//print matrix
void SquareMatrix::printMatrix() {
	for (int i = 0; i < size; ++i) {
		for (int j = 0; j < size; ++j) {
			cout << arr[i][j] << " ";
		}
		cout << endl;
	}
}
// * 연산자 오버라이딩
SquareMatrix SquareMatrix::operator*(const SquareMatrix &a) {
	SquareMatrix temp(size);
	for (int i = 0; i < size; i++) //초기화
		for (int j = 0; j < size; j++)
			temp.arr[i][j] = 0;

	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			for (int k = 0; k < size; k++) {
				temp.arr[i][j] += arr[i][k] * a.arr[k][j];
			}
	return temp;
}

int* SquareMatrix::operator[](int i)
{
	return arr[i];
}

SquareMatrix Identity(int n) {
	SquareMatrix base(n);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (i == j)
				base[i][j] = 1;
			else
				base[i][j] = 0;

	return base;
}

SquareMatrix pow(const SquareMatrix& A, int m) {
	cout << m << endl;
	if (m == 0) return Identity(A.getSize());
	if (m % 2 > 0) return pow(A, m - 1) * A;
	SquareMatrix half = pow(A, m / 2);

	return half * half;
}

int main()
{
    std::cout << "Hello Matrix!\n"; 
	SquareMatrix test(2);
	test.printMatrix();

	SquareMatrix rlt = pow(test, 2);
	rlt.printMatrix();

}

// 프로그램 실행: <Ctrl+F5> 또는 [디버그] > [디버깅하지 않고 시작] 메뉴
// 프로그램 디버그: <F5> 키 또는 [디버그] > [디버깅 시작] 메뉴

// 시작을 위한 팁: 
//   1. [솔루션 탐색기] 창을 사용하여 파일을 추가/관리합니다.
//   2. [팀 탐색기] 창을 사용하여 소스 제어에 연결합니다.
//   3. [출력] 창을 사용하여 빌드 출력 및 기타 메시지를 확인합니다.
//   4. [오류 목록] 창을 사용하여 오류를 봅니다.
//   5. [프로젝트] > [새 항목 추가]로 이동하여 새 코드 파일을 만들거나, [프로젝트] > [기존 항목 추가]로 이동하여 기존 코드 파일을 프로젝트에 추가합니다.
//   6. 나중에 이 프로젝트를 다시 열려면 [파일] > [열기] > [프로젝트]로 이동하고 .sln 파일을 선택합니다.
