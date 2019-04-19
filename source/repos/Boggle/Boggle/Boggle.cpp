// Boggle.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include <iostream>
#include <string>

using namespace std;

const int dx[8] = { -1,-1,-1,1,1,1,0,0 };
const int dy[8] = { -1,0,1,-1,0,1,-1,1 }; //다음칸의 상대좌표를 별도의 변수로 분리한다;

const char board[][5] = { {'u','r','l','p','m'},
						 {'x','p','r','e','t'},
						 {'g','i','a','e','t'},
						 {'x','t','n','z','y'},
						 {'x','o','q','r','s'} };

bool inRange(int y, int x) {
	if (0 <= y < 5 & 0 <= x < 5) {
		return true;
	}
	else return false;
}

bool hasWord(int y, int x, const string& word) {

	//시작위치가 범위 밖이면 무조건 실패
	if (!inRange(y, x)) return false;

	//첫 글자가 일치하지 않으면 실패
	if (board[y][x] != word[0]) return false;

	//단어길이가 1이면 성공
	if(word.size() == 1) return true;

	for (int direction = 0; direction < 8; ++direction) {
		int nextY = y + dy[direction]; 
		int nextX = x + dx[direction];

		if (hasWord(nextY, nextX, word.substr(1))) return true;
	}
	return false;
}

int main()
{
    std::cout << "Hello World!\n"; 
	
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
