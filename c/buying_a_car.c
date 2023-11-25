#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int *nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth)
{

    int endMon = 0;
    double priceOld = startPriceOld;
    double priceNew = startPriceNew;
    double ava = priceOld - priceNew;
    double saving = 0;
    while (ava < 0)
    {
        endMon += 1;
        if (endMon % 2 == 0)
        {
            percentLossByMonth += 0.5;
        }
        priceOld = priceOld * (1.0 - percentLossByMonth / 100.0);
        priceNew = priceNew * (1.0 - percentLossByMonth / 100.0);
        saving += savingperMonth;
        ava = saving + priceOld - priceNew;

        printf("[%d, %f]\n", endMon, ava);
    }
    int *res = (int *)malloc(2 * sizeof(int));

    res[0] = endMon;
    res[1] = round(ava);

    return res;
}

//int main()
//{
//    int *res = nbMonths(2000, 8000, 1000, 1.5);
//    printf("[%d, %d]\n", res[0], res[1]);
//}