
	#define _CRT_SECURE_NO_WARNINGS
	#include <stdio.h>
	#include <string.h>
	#include "헤더.h"
	#include <time.h>

int findMax(int arr[], int end);

void swap(int arr[], int idx1, int idx2);

void printArray(int numbers[], int length);

void swap2(int *pA, int *pB);

char * getString();

void printArray2(char *arr[], int s);

main()
{
/*	printf("코더에게는 작은 한걸음이지만 프로그래머에게는");
	printf(" 거대한 도약이다!\n");
	return 0; */

	/*printf("나는 성적이 %c입니다\n", 'A');
	printf("나의 키는 %dcm입니다\n", 175);
	printf("나는 현재 %s를 마친 상태입니다\n", "Java");
	printf("나의 기부니가 매우 %c습니다\n" ,'좋');*/

/*  int gift1=0, gift2, gift3, gift4;
	int total; 

	printf("엄마를 위하여 얼마나 돈을 쓸건가요?");
	scanf_s("%d", gift1);
	printf("아빠를 위하여 얼마나 돈을 쓸것인가요?");
	scanf_s("%d", &gift2);
	printf("동생을 위하여 얼마나 돈을 쓸건가요?");
	scanf_s("%d", &gift3);
	printf("형아를 위하여 돈을 얼마나 쓸건가요?");
	scanf_s("%d", &gift4);

	total = gift1 + gift2 + gift3 + gift4;
	printf("총 사용한 금액은 : %d", total);  */

	/*char hero[34] = "spiderman";
	char hero2[25];
	// char hero3[];

	strcpy(hero2, "the incredible hulk");

	printf("%s가 가장 좋아하는 슈퍼히어로는 %s.\n", "도훈", hero);
	printf("%s가 가장 좋아하는 슈퍼히어로는 %s.\n", "시언", hero2);

	char movie[2];
	char movie2[2];

	movie[0] = 'a';
	movie[1] = '\0';
	movie2[0] = 'a';
	movie2[1] = 'b';

	printf("%s",movie);
	printf(movie);
	printf("\n");
	printf("%s",movie2);

	/*int age;
	char childname[] = "Tomansgicha";
	printf("\n%s는 %d명의 아이를 가지고 있다.", FAMILY, KIDS);
	age = 11;
	strcpy(childname, "tomato");
	printf("\n%s는 입만열면 구라임\n", childname);*/

	/*char firstInitial;
	int age;
	printf("당신의첫글자?");
	scanf("%c", &firstInitial);
	printf("당신의 나이?");
	scanf("%d" ,&age);
	printf("정리하자면 당신의 첫글자는[%c]이고 당신의 나이는[%d]라는 소리 맞소?", firstInitial, age);
	printf("\n");*/

	/*float cost;
	printf("\n여러분 지역에서는 도나츠가 얼마나 하나요?");
	printf(" ($XX.XX와 같이 입력하세요)\n");
	scanf(" $%f",&cost);
	printf("%f", cost);
	
	fflush(stdin);
	getchar();

	char str[256];
	printf("\n\n문장을 입력하세요:");
	gets(str);

	puts(str);

	printf("%d",sizeof(str));

	printf("\n-------------------------------------------------\n");
	char str2[256] = "Hello World";
	printf("str %d\n", sizeof(str2));
	printf("str length %d\n", strlen(str2));

	
	char str3[] = "C is fun";
	int length = strlen(str3);
	for (int i = 0; i < length; i++) {
		putchar(str3[i]);
	}
	putchar('\n');*/


	//getchar(); //get char를 두번 써야하는가 ?

	/*int i;
	char msg[25];

	printf("최대 25개 이내의 문자를 입력하고 엔터키를 누르시오...\n");
	for (i = 0; i < 25; i++) {
		msg[i] = getchar();
		if (msg[i] == '\n') {
			i--;
			break;
		}
	}
	msg[i + 1] = 0;
	putchar('\n');

	int i;
	int hasUpper = 0, hasLower = 0, hasDigit = 0;
	char user[25], password[25];

	printf("사용자 이름은?: ");
	scanf("%s",user);
	printf("암호를 생성하세요");
	scanf("%s", password);*/

	/*char first[25] = "눈사람";
	char last[52] = "올라프";

	strcat(first, last);
	puts(first);


	char a[25];
	char b[25];
	printf(" a 문자열 하나를 입력하세요 :");
	gets(a);
	printf(" b 문자열 하나를 입력하세요 :");
	gets(b);

	int result = strcmp(a, b);
	printf("%d",result);*/

	/*char city[15];

	char st[10];
	char fullLocation[] = "";

	puts("현재 살고 있는 도시는?");
	gets(city);

	puts("어떤 도에 살고 있나요?(2글자 약어)");
	gets(st);

	strcat(fullLocation, city);
	strcat(fullLocation, ", ");
	strcat(fullLocation, st);

	int years = 10;
	sprintf(fullLocation, " %s,%s에서 %d년 살았습니다", st, city, years);

	puts("\n 당신이 사는 곳은");
	puts(fullLocation);

	char buf[256] = "200";

	int value = atoi(buf);
	printf("%d\n", value);

	

	return(0);*/
	
	/*#define size 8
	
	
	time_t t;
	srand(time(&t));
	
	int arr[size];
	for (int i = 0; i < size; i++) {
		arr[i] = (rand() % 3 + 1);
	}

	
	

	for (int i = 0; i < size; i++) {

		int idx = findMax(arr,size-i);
		swap(arr, idx, size - 1 - i);

		/* int t = arr[size - 1 - i];
		arr[idx] = t;
		arr[size -1- i] = arr[idx];*/
	/*#define SCORE_LEN 10	

	int gameScores[SCORE_LEN] = {12,5,21,15,32,10 };
	int totalpoints = 0;
	int i;
	float avg;

	for (i = 0; i < 6; i++) {
		totalpoints += gameScores[i];
	}

	avg=((float)totalpoints/10);*/

	/*int kids;
	int *pKids;
	float price;
	float *pPrice;

	char code;
	char *pCode;

	price = 17.50;
	pPrice = &price;

	pCode = &code;
	pKids = &kids;

	printf("아 몇명 입니까? :");
	scanf("%d", pKids);


	printf("코드번호 : ");
	scanf("%d", pCode);

	printf("%d", kids);

	int a = 3;
	int b = 4;
	swap2(&a, &b);
	printf("\n%d", a);

	int a = 3;
	int b = 4;


	return(0); */

	/*char str1[] = "Hello";
	char str2[] = "Hello";

	char *pStr1 = "Hello";
	char *pStr2 = "Hello";

	(str1 == str2) ? puts("str1,str2 동일") : puts("str1,str2 다르다"); //예상 : 다르다
	(str1 == pStr1) ? puts("동일") : puts("다르다"); //예상 : 다르다.
	(pStr1 == pStr2) ? puts("동일") : puts("다르다"); //예상 : 같다.

	char *pStr3 = getString();
	puts(pStr3);*/

	/*int i;
	int ctr = 0;
	char ans;

	char *arr[9] = {
		"Amour",
		"Argo",
		"Beasts of ths Southern Wild",
		"Django Unchained",
		"Les Miserables",
		"Life of pi", "Lincon",
		"Silver Linings Playbook",
		"Zero Dark Thirty"
	};

	for (i = 0; i < 9; i++) {
		puts(*(arr+i));
	}*/

	#define size 5

	char movies[size][256];

	for (int i = 0; i < size; i++) {
		puts("영화제목을 입력하세요 :");
		gets(movies[i]);
	}

//	for (int i = 0; i < size; i++) {
//		puts(movies[i]);
//	}
	
	
	
	char temp[256];
	int ix;

	puts("몇번째 영화를 수정할까요?");
	scanf("%d", &ix);

	getchar();

	puts("새로 넣을 영화를 입력하세요:");
	gets(temp);

	puts("---------------------------------");
	strcpy(movies[ix-1], temp);
	puts("---------------------------------");


	printArray2(movies,size);
	puts("---------------------------------");

}

void printArray2(char arr[][256],int s) {
	for (int i = 0; i < s; i++) {
 		puts((char *)arr[i]);
	
			
	}
}

char * getString() {
	char str[] = "Hello";
	return str;
}

void swap2(int *pA, int *pB) {
	int temp = *pB;
	*pA = *pB;
	*pB = temp;
}

	

void swap(int arr[], int idx1, int idx2) {
	int temp = arr[idx2];
	arr[idx2] = arr[idx1];
	arr[idx1] = temp;
}

int findMax(int arr[],int end) {

	int maxValue = arr[0];
	int idx = 0;

	for (int j = 0; j < end; j++) {

		if (maxValue < arr[j]) {
			maxValue = arr[j];
			idx = j;
		}
	}
	return maxValue;
}

void initRandom(int numbers[], int length) {
	for (int i = 0; i < length; i++) {
		numbers[i] = 4;
		//length에 대한 address만 오기때문에 값을 계산하는 것이 불가능하다.
	}
}

void printArray(int numbers[], int length) {
	for (int i = 0; i < length; i++) {
		printf("%d", numbers[i]);
	}
}

void sort(int numbers[], int length) {
	for (int j = length - 1; j > 0; j--) {
		int maxIx = findMax(numbers, j);
		swap(numbers, maxIx, j);
	}
}





