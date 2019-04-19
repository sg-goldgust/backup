// Inherit.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include <iostream>

using namespace std;

/*class CMyData {
	int m_nData = 0;
public:
	CMyData() { cout << "CMYData()" << endl; }

	~CMyData() {cout<< "파괴한다\n"; }

	int GetData() { return m_nData; }

	virtual void SetData(int nParam) { m_nData = nParam; }
protected:
	void PrintData() { cout << "CMyData::printData()" << endl; }
};

class CMyDataEx : public CMyData {
public:
	CMyDataEx() { cout << "CEX" << endl; }

	void SetData(int nParam) {
		if (nParam < 0)
			CMyData::SetData(0);
		else if (nParam > 10)
			CMyData::SetData(10);
		else
			CMyData::SetData(nParam);
	}

	void TestFunc() {
		PrintData();
		SetData(5);
		cout << CMyData::GetData() << endl;
	}
};*/

class CMyData {
public:
	CMyData() { cout << "CMyData" << endl; }
	CMyData(int nParam) { cout << "CMyData(int)" << endl; }
	CMyData(double dParam) { cout << "double" << endl; }
};

class CMyDataEx : CMyData {
public:
	CMyDataEx() : CMyData() {
		cout << "hi";
	}
	CMyDataEx(double d) : CMyData() {

	}
};

int main()
{
	CMyDataEx a;
	CMyDataEx b(3.3);

    /*std::cout << "Hello World!\n"; 
	CMyDataEx data;

	data.SetData(10);
	cout << data.GetData() << endl;

	data.TestFunc();

	CMyDataEx data2 = data;
	data2.TestFunc();

	CMyDataEx b;
	b.SetData(15);

	CMyData c = b;
	cout << c.GetData() << endl;
	c.SetData(-20);
	cout << c.GetData() << endl;

	CMyData *d = &b;
	cout << d->GetData() << endl;
	d->SetData(-20);
	cout << d->GetData() << endl;

	CMyData &f = b;
	cout << f.GetData() << endl;
	f.SetData(-20);
	cout << f.GetData() << endl;

	return 0;*/
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
