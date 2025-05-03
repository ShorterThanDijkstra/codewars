#include <string>
#include <vector>
#include <iostream>

using namespace std;
vector<string> number(const vector<string> &lines)
{
    vector<string> vec;
    vec.reserve(lines.size());
    size_t i = 0;
    while (i < lines.size())
    {
        string line = to_string(i + 1) + ": " + lines.at(i);
        vec.push_back(line);
        i += 1;
    }
    return vec;
}

int main()
{
    vector<string> lines = {"hello", "world", "I miss you"};
    vector<string> number_lines = number(lines);
    for (size_t i = 0; i < number_lines.size(); i++)
    {
        string line = number_lines.at(i);
        cout << line << endl;
    }
}