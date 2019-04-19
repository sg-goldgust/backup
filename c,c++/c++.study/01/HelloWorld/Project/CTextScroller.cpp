#include "pch.h"
#include "TextScroller.h"

#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <string>
using namespace std;


CTextScroller::CTextScroller(const char* str)
{
	m_nLength = strlen(str);
	m_pMsg = new char[m_nLength+1];
	strcpy(m_pMsg, str);
}


CTextScroller::~CTextScroller()
{
	if (m_pMsg) {
		delete[] m_pMsg;
	}
	cout << "CTextScroller 객체를 제거합니다" << endl;
}

const char *CTextScroller::next() {
	char c = m_pMsg[0];
	for (int i = 1; i < m_nLength; i++) {
		m_pMsg[i - 1] = m_pMsg[i];
	}
	m_pMsg[m_nLength - 1] = c;

	return m_pMsg;


	char c = m_pMsg[0];
	char *buffer = new char[m_nLength+1];
	strcpy(buffer,m_pMsg[1]);
	buffer[m_nLength - 1] = c;
	strcpy(m_pMsg, buffer);
	return m_pMsg;
}

/*char* next()
{	
	char buffer[256] = {NULL};
	char c;
	strcpy(buffer,&pStr[0]);

};*/
