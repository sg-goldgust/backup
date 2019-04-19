// ConsoleApplication4.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

const int INF = 987654321;
vector<int> menu;
int M; //요리가능한 음식종류의 수 

bool canEverybodyEat(const vector<int>& menu) {

};



int selectMenu(vector<int>& menu, int food) {
	if (food == M) {
		if (canEverybodyEat(menu)) return menu.size();
		return INF;
	}
	int ret = selectMenu(menu, food + 1);
	menu.push_back(food);
	ret = min(ret, selectMenu(menu, food + 1));
	menu.pop_back();
	return ret;
}






int main()
{
    std::cout << "Hello World!\n"; 
	vector<int> v;
	v = { 1,2,3 };
	vector<int>::iterator itr;

	for (itr = v.begin(); itr != v.end(); ++itr)
		cout << *itr << endl;

	set<int> intSet;
	intSet = { 4,5,6 };
	set<int>::iterator itr2;
	for (itr2 = intSet.begin(); itr2 != intSet.end(); ++itr2)
		cout << *itr2 << endl;

}

int majority(const vector<int>& A) {
	/*int n = A.size();
	vector<int> count(101);
	for (int i = 0; i < n; ++i)
		count[A[i]]++;

	int majority = 0;
	for (int i = 1; i <= 100; ++i) {
		if (count[i] > majority) majority = i;
	}

	return majority;*/

}

vector<double> movingAverage(const vector<double>& A, int M) {
	vector<double> ret;
	int N = A.size();
	/*for (int i = M - 1; i < N; ++i) {
		double partialSum = 0;
		for (int j = 0; j < M; ++j) {
			partialSum += A[i - j];
		}
		ret.push_back(partialSum / M);
	}
	return ret;*/
	double partialSum = 0;
	for (int i = 0; i < M - 1; ++i) {
		partialSum += A[i];
	}
	for (int i = M - 1; i < N; ++i) {
		partialSum += A[i];
		ret.push_back(partialSum / M);
		partialSum -= A[i - M + 1];
	}
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
