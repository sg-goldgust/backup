// Operator.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include <iostream>

using namespace std;

class CintArray {
	int * m_pnData;
	int m_nSize;
public:
	CintArray(int nSize) {
		m_pnData = new int[nSize];
		memset(m_pnData,0,sizeof(int)*nSize);
	}

	~CintArray() { delete[] m_pnData; };

	int operator[] (int nIndex) const {
		cout << "operator[] const" << endl;
		return m_pnData[nIndex];
	}

	int& operator[] (int nIndex) {
		cout << "operator[]" << endl;
		return m_pnData[nIndex];
	}

};

void TestFunc(const CintArray &arParam) {
	cout << "TestFunc()" << endl; // 상수형 참조이므로 'operator[] (int nIndex) const'를 호출한다. 
	cout << arParam[3] << endl; 
}

int main()
{
	CintArray arr(5); 
	for (int i = 0; i < 5; ++i) 
		arr[i] = i * 10; 
	
	TestFunc(arr); 
	return 0;
}



