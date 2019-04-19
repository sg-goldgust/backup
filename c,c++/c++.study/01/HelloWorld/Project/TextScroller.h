#pragma once
class CTextScroller
{
	int m_nLength;
	char *m_pMsg;
public:
	

	CTextScroller(const char* str) ;
	~CTextScroller();

	const char* next();
};

