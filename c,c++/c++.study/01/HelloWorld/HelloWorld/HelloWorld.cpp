
#include "pch.h"
#include <iostream>
#include <string>
using namespace std;

void TestFunc(int &rParam);

//int main()

	/*std::cout << "Hello World!\n" << std::endl << "C++" << std::endl;

	std::cout << "olive oil\n"<<"good job!";

	std::cout << 5;
	std::cout << std :: endl << 5U;
	std::cout << std::endl << 10.5F;
	std::cout << std::endl << 3 + 4;
	

	int nAge;
	std::cout << "\n숫자를 입력하세요\n";
	std::cin >> nAge;

	char szJob[32];
	std::cout << "직업을 입력하세요" << std::endl;
	std::cin >> szJob;

	std::string strName;
	std::cout << "이름을 입력하세요" << std::endl;
	std::cin >> strName;

	std::cout << "당신의 이름은" << strName << "이고,"
		<< "나이는" << nAge << "살이며,"
		<< "직업은" << szJob << "입니다.";*/

	/*int a = 10;
	int b(a);
	auto c(b);

	std::cout << a + b + c << std::endl;
	
	int *pData = new int;
	int *pNewData = new int(10);

	std::cout << "-------------------------------------------------------"<<std::endl;

	*pData = 5;
	std::cout << *pData << std::endl;
	std::cout << *pNewData << std::endl;

	delete pData;
	delete pNewData;


	std::cout << "-------------------------------------------------------" << std::endl;
	int *arr = new int[5]{
			10,30,20,40,60};

	for (int i = 0; i < 5; i++) {
		arr[i] = (i + 1) * 10;
	}
	//c로 이를 만들어 보자
	//int *arr;


	std::cout << "-------------------------------------------------------" << std::endl;*/

	/*int nData = 10;
	int &ref = nData;

	ref = 20;
	cout << nData << endl;

	int *pnData = &nData;
	*pnData = 30;
	cout << nData << endl;*/

	//std::cout << "-------------------------------------------------------" << std::endl;

	/*int nData = 0;
	TestFunc(nData);

	cout << nData << endl;

	return 0;*/

	/*int aList[5] = { 10,20,30,40,50 };

	for (int i = 0; i < 5; ++i)
		cout << aList[i] << ' ';

	cout << endl;

	for (auto n : aList)
		cout << n << ' ';

	cout << endl;

}*/

void TestFunc(int &rParam) {
	rParam = 100;
}

void swap(int &rValue1, int &rValue2) {
	int temp = rValue1;
	rValue1 = rValue2;
	rValue2 = temp;
}