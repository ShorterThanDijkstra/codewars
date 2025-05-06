#include <iostream>
bool IsLeapYear(int year)
{
  if (year % 100 == 0)
  {
    return year % 400 == 0;
  }
  return year % 4 == 0;
}
int main()
{
  std::cout << IsLeapYear(2024) << std::endl;
  std::cout << IsLeapYear(1900) << std::endl;
  return 0;
}
