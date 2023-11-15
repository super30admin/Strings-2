#include<bits/stdc++.h>
using namespace std;

/*
Approach: Rolling hash: We create hash function to give unique value for a string. Adding element to end of string = 26*oldHash + newCharHash. Removing new elem from st of string = placeValOfStChar - oldHash. Thus in a sliding window of len 'p' we keep on calculating a rolling hash. If any point the val is equal with 'p' then return th st of window.
Time: O(n+m)
Works on leetcode: No. Integer Overflow/
*/

class Solution {
public:
    int strStr(string haystack, string needle) {
        long hashNeedle = 0, mult=1;
        for(int i=needle.size()-1; i>=0; i--) {
            hashNeedle += mult*(needle[i]-'a'+1);
            mult = mult*26;
        }
        // cout<<hashNeedle<<endl;

        long hashHay = 0;
        mult = pow(26,needle.size());
        for(int st=0, end=0; end<haystack.size(); end++) {
            hashHay = (hashHay*(long)26) + (long)(haystack[end]-'a'+1);
            if(end>=needle.size()) {
                hashHay -= (mult*(haystack[st]-'a'+1));
                st++;
            }
            if(hashHay == hashNeedle) {
                return st;
            }
        }
        return -1;
    }
};

int main() {
    Solution S;
    cout<<S.strStr("asad", "sad")<<endl;
}