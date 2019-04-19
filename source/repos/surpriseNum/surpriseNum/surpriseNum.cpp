// surpriseNum.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include <iostream>

#define MAX_INPUT 9999
#define MIN_INPUT 1000

using namespace std;
//재귀의 조각 : 각 자리수를 리턴한다.


//n:입력받은 숫자와, d:해당 진수를 리턴한다
int recursiveSum(int n, int d) {
	//base
	if (n / d == 0) {
		return n % d;
	}

	int peice = n % d;

	return peice + recursiveSum(n/d,d);
}


int main()
{
	
	for (int i = MIN_INPUT; i < MAX_INPUT; ++i) {
		//10진수,12진수,16진수

		int ten = recursiveSum(i, 10);
		int twelve = recursiveSum(i, 12);
		int sixteen = recursiveSum(i, 16);

		if ((ten == twelve) & (twelve == sixteen)) {
			cout << i << endl;
		}
	}
}
