

#define _CRT_SECURE_NO_WARNINGS

#include <string.h>
#include <stdlib.h>
#include <stdio.h>


char* getString(char *pmsg) {
	char temp[512];
	printf("%s",pmsg);
	gets(temp);

	char *pstr = (char *)malloc(strlen(temp) + 1);
	strcpy(pstr, temp);

	return pstr;
}

int main()
{
	/*char *pStr = NULL;

	pStr = getString("영화 제목 : ");
	puts(pStr);

	free(pStr);
	pStr = NULL;*/

	char *movies[100] = {NULL};

	//입력
	for (int i = 0; i < 100; i++) {
		puts("\n영화 제목을 입력하시겠습니까?(Y/N) : ");
		char select;
		scanf("%c",&select);
		getchar();

		if (select == 'Y') {
			movies[i] = getString("영화 제목을 입력하세요\n");
			continue;
		}	else { break; }
	}

	//실제 데이터 갯수 찾기
	int count = 0;
	for (int i = 0; i < 100; i++) {
		if (movies[i]) {
			count++;
		}
	}

	//정렬
	for (int i = count; i>0 ;i--) {

		char *maxStr;
		maxStr = movies[0];
		int idx=0 ;
		int compareValue;

		for (int j = 0; j < i;j++) {
			compareValue = strcmp(movies[j],maxStr);
			if (compareValue>0) {
				idx = j;
				maxStr = movies[j];
			}
		}

		//swap
		char *temp;
		temp = movies[idx];
		movies[idx] = movies[i-1];
		movies[i-1] = temp;
	}


	//출력
	for (int i = 0; i < 100;i++) {
		
		if (movies[i] != NULL ) {
			puts("영화제목을 출력합니다.");
			puts("------------------------------------------------------------");
			puts(movies[i]);
			puts("------------------------------------------------------------");
		}
		
	}

}