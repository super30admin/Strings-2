#include<unordered_map>
#include<string>
#include<vector>
#include<iostream>
using namespace std;
class Solution {
    public:
        bool isAnagram(unordered_map<char,int>&actual, unordered_map<char,int>&ref){
            for(auto p:actual) if(p.second!=ref[p.first]) return false;
            for(auto p:ref) if(p.second!=actual[p.first]) return false;
            return true;
        }
        vector<int> findAnagrams(string s, string p) {
            unordered_map<char,int>ref,actual;
            for(auto c:p) ref[c]++;
            int n = s.size(), m = p.size();
            if(m>n) return {};
            vector<int>ans;
            for(int i=0;i<=n-1;i++){
                if(i>m-1) actual[s[i-m]]--;
                actual[s[i]]++;
                if(isAnagram(actual, ref)) ans.push_back(i-m+1);
            }
            return ans;
        }
};
int main() {
    Solution solution;
    string s = "cbaebabacd";
    string p = "abc";
    vector<int> result = solution.findAnagrams(s, p);
    cout << "Anagram starting indices: ";
    for (int index : result) {
        cout << index << " ";
    }
    cout << endl; // Output: [0, 6]
    return 0;
}
// // Time Complexity: O(n*m) where n is the length of s and m is the length of p
// // Space Complexity: O(1) since the character set is fixed (26 lowercase letters)
// // Did this code successfully run on Leetcode: Yes
// // Any problem you faced while coding this: No
// // Your code here along with comments explaining your approach in three sentences only
// // Used a sliding window approach to maintain a frequency count of characters in the current window of string s. Compared this frequency count with the frequency count of string p to check for anagrams. If they matched, recorded the starting index of the window.