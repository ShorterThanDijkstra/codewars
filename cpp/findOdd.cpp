#include <vector>
#include <iostream>
#include <algorithm>
#include <assert.h>
using namespace std;
int findOdd(const vector<int> &numbers)
{
    assert(numbers.size() > 0);
    vector<int> copy = numbers;
    sort(copy.begin(), copy.end());
    int count = 1;
    int pre = copy.at(0);
    for (size_t i = 1; i < copy.size(); i++)
    {
        int curr = copy.at(i);
        if ((curr != pre) && (count % 2) == 1)
        {
            return pre;
        }
        if (curr != pre)
        {
            pre = curr;
            count = 1;
        }
        else
        {
            count += 1;
        }
    }
    return pre;
}
int main()
{
 //   cout << findOdd({0, 0, 1}) << endl;
    cout << findOdd({20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5})<< endl;
}
