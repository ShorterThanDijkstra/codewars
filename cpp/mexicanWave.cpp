// https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/cpp
#include <iostream>
#include <cctype>
#include <string>
#include <vector>
using namespace std;
vector<string> wave(string y)
{
   size_t size = y.size();
   vector<string> res;
   for (size_t i = 0; i < size; i++)
   {
      char c = y.at(i);
      if (c == ' ') {
         continue;
      }
      string s = y.substr(0, i);
      s.push_back(toupper(c));
      s += y.substr(i + 1);
      res.push_back(s);
   }
   return res;
}
int main()
{
   string s = " gap ";
   vector<string> v = wave(s);
   cout << v.size() << endl;
   for (string s : v)
   {
      cout << s << endl;
   }
   return 0;
}