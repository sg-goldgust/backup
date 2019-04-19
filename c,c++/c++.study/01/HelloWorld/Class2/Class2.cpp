
#include "pch.h"
#include <iostream>
#include "MyData.h"
using namespace std;

int main()
{
    std::cout << "Hello World!\n"; 

	CMyData data;
	data.SetData(10);
	cout << data.GetData() << endl;

	CMyData * pdata = new CMyData;
	
	//delete pdata;
	cout << "프로그램을 종료합니다/" << endl;

	return 0;
}

