// Time Complexity : O(m)+O(n); m length of p, n length of s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create a frequency map from given pattern and maintain counter variable denotes total number of deviations. it will always be equal to sum of absolute vals of values in map
// 2. For incoming chars, decrease entry in map and if entry is non-negative decrease counter else increase counter
// 3. For outgoing chars, increase entry in map and if entry is positive increase counter else decrease counter
// 4. When counter==0, add start to result array

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if(s.size()==0 || p.size()==0 || s.size()<p.size())
            return {};
        map<char, int> hash;
        for(char c:p)
            hash[c]++;
        int start=0, end=0,counter=p.size();
        vector<int> result;
        // counter denotes total number of deviations. it will always be equal to sum of absolute vals of values in map
        while(end<s.size()){
            
            // in
            if(hash.find(s[end]) != hash.end()){
                hash[s[end]]--;
                if(hash[s[end]] >= 0)
                    counter--;
                else
                    counter++;
            }
            end++;
            
            // out
            if(end-start>p.size()){
                if(hash.find(s[start]) != hash.end()){
                    hash[s[start]]++;
                    if(hash[s[start]] > 0)
                        counter++;
                    else
                        counter--;
                }
                start++;
            }
            cout<<counter<<endl;
            cout<<s[start]<<" "<<s[end]<<" ";
            
            // perfect match
            if(counter==0)
                result.emplace_back(start);
        }
        return result;
    }
};