#include "pch.h"

#define _CRT_SECURE_NO_WARNINGS


#include <iostream>
#include <string>
#include <windows.h>
using namespace std;


int main()
{
    
	char msg[] = "Hello World ";
	int len = strlen(msg);
	while (1) {
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				cout << msg[j];
			}

			for (int j = 0; j < i; j++) {
				cout << msg[j];
			}

			cout << "\n";
			Sleep(100);
			system("cls");
		}
	}
	cout << "========================================\n";
	char *cpy;
	
	for (int i = 0; i < len; i++) {
		char *p = &msg[i];
		cout << p << endl;
	}

	cout << "========================================\n";
	char buffer[256] = { NULL };

	cout << msg << endl;
	for (int i = 0; i < len; i++) {
		char c = msg[0];
		strcpy(buffer,&msg[1]);
		buffer[len - 1] = c;
		strcpy(msg, buffer);

		cout << msg << endl;

	}

}


