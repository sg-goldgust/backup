#include "pch.h"
#include "Test1.h"
#include <iostream>
using namespace std;

CTest1::CTest1()
{
	m_nData = 10;
	cout << "CTest1 생성자 호출" << endl;
}


CTest1::~CTest1()
{
	cout << "파괴자 호출";
}
