// https://www.codewars.com/kata/52de553ebb55d1fca3000371/train/cpp
#include <vector>
#include <iostream>
static long findMissing(std::vector<long> list)
{
    /*
    gap = (last - first) / (size_origin - 1)
        = (last - first) / size
    */
    long size = list.size();
  
    long last = list.at(size - 1);
    long first = list.at(0);
    long gap = (last - first) / (size);
    for (long i = 0; i < size - 1; i++)
    {
        if (list.at(i + 1) - list.at(i) != gap)
        {
            return list.at(i + 1) - gap;
        }
    }
    throw std::invalid_argument("not found");
}

int main()
{
    std::cout << findMissing({1, 3, 5, 9, 11}) << std::endl;
    std::cout << findMissing({1, 7, 10, 13}) << std::endl;
    std::cout << findMissing({1, 4, 7, 13}) << std::endl;
    std::cout << findMissing({1, 7, 10}) << std::endl;
}