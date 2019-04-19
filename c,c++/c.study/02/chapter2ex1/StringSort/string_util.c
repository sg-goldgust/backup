
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>



void swap(char arr[][256], int idx1, int idx2) {
	char temp[256];
	strcpy(temp, arr[idx1]);
	strcpy(arr[idx1], arr[idx2]);
	strcpy(arr[idx2], temp);
}

int findMax(char arr[][256], int length) {
	//char maxStr[256];
	int idx = 0;
	//strcpy(maxStr,movies[0]);
	int value;
	for (int j = 0; j < length; j++) {
		value = strcmp(arr[j], arr[idx]);
		if (value > 0) {
			idx = j;
			//		strcpy(maxStr,movies[j]);
		}
	}
	return idx;
}

void sort(char arr[][256], int len) {
	for (int i = len - 1; i > 0; i--) {
		int maxIx = findMax(arr, i);
		swap(arr, maxIx, i);

	}
}

void print(char arr[][256], int length) {
	for (int i = 0; i < length; i++) {
		puts(arr[i]);
	}
};