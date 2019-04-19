#pragma once
class CMyData
{

	int m_nData;

public:
	CMyData();
	~CMyData();

	CMyData(int &rParam) : m_nData2(rParam) {};
	CMyData(int x, int y, int &rParam) : m_nData(x+y), m_nData2(rParam) {};

	int &m_nData2;

	int GetData(void) { return m_nData; }
	void SetData(int nParam) { m_nData = nParam; }
};

