// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

std::vector<int> findAnagrams(std::string s, std::string p) {
    std::vector<int> result;
    int n = s.length();
    int m = p.length();

    if (n == 0 || m > n) return result;

    std::unordered_map<char, int> map;

    for (char c : p) {
        map[c]++;
    }

    int match = 0;

    for (int i = 0; i < n; i++) {
        char c = s[i];

        if (map.find(c) != map.end()) {
            map[c]--;

            if (map[c] == 0) {
                match++;
            }
        }

        if (i >= m) {
            c = s[i - m];

            if (map.find(c) != map.end()) {
                map[c]++;

                if (map[c] == 1) {
                    match--;
                }
            }
        }

        if (match == map.size()) {
            result.push_back(i - m + 1);
        }
    }

    return result;
}

int main() {
    std::string s = "cbaebabacd";
    std::string p = "abc";

    std::vector<int> result = findAnagrams(s, p);

    std::cout << "Anagram Positions: ";
    for (int pos : result) {
        std::cout << pos << " ";
    }
    std::cout << std::endl;

    return 0;
}
