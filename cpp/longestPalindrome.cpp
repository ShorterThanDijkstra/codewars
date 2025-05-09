// https://www.codewars.com/kata/54bb6f887e5a80180900046b/train/cpp
#include <string>
#include <iostream>
using namespace std;

int longest_palindrome(const string &s, const int i, int left, int right) {
    while (left >= 0 && right < s.size() && s.at(left) == s.at(right)) {
        left -= 1;
        right += 1;
    }
    return right - left - 1;
}

int longest_palindrome(const string &s) {
    int max = 0;
    for (int i = 0; i < s.size(); i++) {
        if (const int dist = longest_palindrome(s, i, i - 1, i + 1); dist > max) {
            max = dist;
        }

        if (const int dist = longest_palindrome(s, i, i, i + 1); dist > max) {
            max = dist;
        }
    }

    return max;
}

int main() {
    // std::cout << longest_palindrome("a") << std::endl;
    // std::cout << longest_palindrome("aab") << std::endl;
    // std::cout << longest_palindrome("aab") << std::endl;
    // std::cout << longest_palindrome("abcde") << std::endl;
    std::cout << longest_palindrome("zzbaabcd") << std::endl;
    // std::cout << longest_palindrome("") << std::endl;
}
