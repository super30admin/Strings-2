#include<bits/stdc++.h>
using namespace std;

/*
Approach: Nested loop: String matching from every start position. We basically start at every possible start position in s. Then from this st, we go on to check if the next len(p) chars match with 'p'. If yes return this start index.
Time: O(m*m)
Works on leetcode: Yes
*/

class Solution {
public:
    int strStr(string haystack, string needle) {
        for(int i=0; i<(int)haystack.size()-(int)needle.size()+1; i++) {
            if(matches(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    bool matches(string &haystack, string &needle, int st) {
        for(int i=0; i<needle.size(); i++) {
            if(haystack[st+i] != needle[i]) {
                return false;
            }
        }
        return true;
    }
};

int main() {
    Solution S;
    cout<<S.strStr("abb", "abaaa")<<endl;
}