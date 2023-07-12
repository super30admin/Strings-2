/*
// Time Complexity : O(N)
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
For the window of length M we compare the hashmap of the characters with that of p's. If true increase index.
*/

#include<string>
#include<vector>
#include<unordered_map>

using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res{}; 
        int n = s.size();
        int m = p.size();
        if(m>n) return res;
        unordered_map<int,int> hash_map{};
        int num_char{};
        int cnt{};
        for(int i{};i<m;++i){
            int idx = p.at(i) - 'a';
            if(hash_map.find(idx) == hash_map.end()){
                hash_map[idx] = 0;
                num_char++;
            } 
            hash_map[idx]++;
        }
        for(int i{};i<n;++i){
            int idx = s.at(i) - 'a';
            if(hash_map.find(idx)!=hash_map.end()){
                hash_map[idx]--;
                if(hash_map[idx] == 0) cnt++;
            }
            if(i>=m){
                int s_idx = s.at(i-m) - 'a';
                if(hash_map.find(s_idx)!=hash_map.end()){
                    if(hash_map[s_idx]==0) cnt--;
                    hash_map[s_idx]++;
                }
            }
            if(cnt == num_char) res.push_back(i-m+1);
        }
        return res;
    }
};