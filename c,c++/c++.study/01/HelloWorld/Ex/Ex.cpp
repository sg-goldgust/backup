
#include "pch.h"
#include <iostream>
using namespace std;



class CMyData {
	int m_nData;
public :
	CMyData(int nParam) : m_nData(nParam) {};
	void printfData() {
		cout << m_nData << endl;
		cout << this->m_nData << endl;
		cout << CMyData ::m_nData<<endl;
		cout << this->CMyData ::m_nData << endl;
	}
};

class CTest {
	int m_nData=0;
public :
	CTest(int nParam) : m_nData(nParam) {};
	~CTest() {};

	int GetData() const {
		return m_nData;
	}

	int SetData(int nParam) { m_nData = nParam; }
};

int main()
{
    std::cout << "Hello World!\n"; 
	CMyData cmd(3) ,a(10);
	cmd.printfData();

	CTest b(10);
	cout << b.GetData() << endl;

}

