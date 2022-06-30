// Time Complexity : O(n + m) 
//              where n : length of i/p string
//                    m : length of pattern string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Sliding window approach.
 * Build a hashmap using pattern string to store character and its frquency. 
 * Iterate over input string, while iterating maintain a sliding window. 
 * For each incoming character check if it is present in map, if yes then decrement frequncy count of that char.
 *          If frequncy becomes 0 then increment match char count.
 * For each outgoing char check if it is present in map, if yes then increment frequncy count of that char.
 *          If frequncy becomes 1 then decrement match char count.
 * If match char count becomes same as number of elements in map then store the start index of window in result.
 */

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        
        if (s.empty() || p.empty())
            return result;
        
        unordered_map<char, int> map;
        
        // Build hashmap of pattern.
        for (char c : p)
        {
            if (map.find(c) == map.end())
            {
                map.insert({c, 0});
            }
            
            map.find(c)->second++;
        }
        
        int match = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            char in = s[i];
            
            auto ele = map.find(in);
            if (ele != map.end())
            {
                ele->second--;
                
                if (ele->second == 0)
                {
                    match++;
                }
            }
            
            if (i >= p.length())
            {
                char out = s[i - p.length()];
                
                auto outEle = map.find(out);
                
                if (outEle != map.end())
                {
                    outEle->second++;
                    
                    if (outEle->second == 1)
                    {
                        match--;
                    }
                }
            }
            
            if (match == map.size())
            {
                result.push_back(i - p.length() + 1);
            }
        }
        
        return result;
    }
};