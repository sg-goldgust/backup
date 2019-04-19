
#include "pch.h"
#include <iostream>
#include <string>
#define CRT_SECURE_NO_WARNINGS

using namespace std;


class Button {
	string m_sTitle;
	void(*click)();

public:
	
	void Click() {
		cout << m_sTitle << endl;
		cout << "-------------------------------------" << endl;
		if (click) {
			click();
		}
		cout << "-------------------------------------" << endl;
	}

	Button(string title, void(*click)()) {
		m_sTitle = title;
		this->click = click;
	}
};


void SendEmail() {
	cout << "email 전송" << endl;
};

void SendSms() {
	cout << "sns 전송" << endl;
}


int main()
{
	std::cout << "Hello World!\n";

	Button mailButton("전송",SendEmail);
	Button smsButton("전송",SendSms);

	mailButton.Click();
	smsButton.Click();
}