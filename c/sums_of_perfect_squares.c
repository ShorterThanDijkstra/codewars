#include <stdio.h>
#include <math.h>
#include <stdlib.h>

unsigned int max_square(unsigned int n)
{
	int f = floor(sqrt((double)n));
	return f;
}

unsigned int sum_of_squares(unsigned int n)
{
	if (n == 0)
	{
		return 0;
	}

	if (n == 1)
	{
		return 1;
	}
	int f = max_square(n);
	int min = sum_of_squares(n - f * f);
	int min_f = f;
	while (f > 0)
	{
		f -= 1;
		int tmp = sum_of_squares(n - f * f);
		if (tmp < min)
		{
			min = tmp;
			min_f = f;
		}
	}

	return 1 + sum_of_squares(n - min_f * min_f);
}
int main(int argc, char *args[])
{
	printf("\n%d\n", sum_of_squares(atoi(args[1])));
}
