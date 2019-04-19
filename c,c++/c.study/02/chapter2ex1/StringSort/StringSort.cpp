

#define _CRT_SECURE_NO_WARNINGS
#include "string_util.h"

#define size 5



int main()
{
	char movies[size][256] = {
		"amour",
		"les miserables",
		"beasts of the southern wild",
		"silver linings playbook",
		"django unchained"
	};

	sort(movies,size);
	print(movies, size);
}

