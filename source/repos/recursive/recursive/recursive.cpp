// recursive.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include <iostream>
#include <vector>

using namespace std;


void printPicked(vector<int>& picked) {
	for (vector<int>::size_type i=0; i != picked.size(); ++i) {
		cout << picked[i]<< " ";
	}
	cout << endl;
}

//n 전체원소의 수
//picked 지금까지 고른 원소들의 번호
//topick 더 고를 원소의 수

void pick(int n, vector<int>& picked, int toPick) {
	if (toPick == 0) {
		printPicked(picked); return;
	}
	//고를 수 있는 가장 작은 번호를 계산;
	int smallest = picked.empty() ? 0 : picked.back() + 1;

	for (int next = smallest; next < n; ++next) {
		picked.push_back(next);
		//{1,2,3} 

		pick(n, picked, toPick - 1);
		//{1,2,3,4}

		picked.pop_back(); //이작업이 있어야 모든 트리의 경우의 수를 탐색하는작업이 가능한다;
	}
}

int main()
{
	/*for (int i = 0; i < 7; ++i) {
		for (int j = i + 1; j < 7; ++j) {
			for (int k = j + 1; k < 7; ++k) {
				cout << i << " " << j << " " << k << endl;
			}
		}
	}*/
	cout << "start" << endl;

	vector<int> A;
	pick(7, A, 4);

	cout << "end";
}

/*int sum(int n) {
	int ret = 0;
	for (int i = 1; i <= n; ++i) {
		ret += i;
	}
	return ret;
}

int recursiveSum(int n) {
	if (n == 1) return 1;
	return n + recursiveSum(n - 1);
}*/



// 프로그램 실행: <Ctrl+F5> 또는 [디버그] > [디버깅하지 않고 시작] 메뉴
// 프로그램 디버그: <F5> 키 또는 [디버그] > [디버깅 시작] 메뉴

// 시작을 위한 팁: 
//   1. [솔루션 탐색기] 창을 사용하여 파일을 추가/관리합니다.
//   2. [팀 탐색기] 창을 사용하여 소스 제어에 연결합니다.
//   3. [출력] 창을 사용하여 빌드 출력 및 기타 메시지를 확인합니다.
//   4. [오류 목록] 창을 사용하여 오류를 봅니다.
//   5. [프로젝트] > [새 항목 추가]로 이동하여 새 코드 파일을 만들거나, [프로젝트] > [기존 항목 추가]로 이동하여 기존 코드 파일을 프로젝트에 추가합니다.
//   6. 나중에 이 프로젝트를 다시 열려면 [파일] > [열기] > [프로젝트]로 이동하고 .sln 파일을 선택합니다.
