// Time Complexity : O(n*m) n is s length, m is p length
// Space Complexity :  O(m)
// Did this code successfully run on Leetcode : No (Getting TLE for big cases. Need to optimize)
// Any problem you faced while coding this

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        // Return vector
        vector<int> ret_vect;

        // Reference map from string p
        map<char, int> ref_map;
        
        // p length greater than s
        if(p.size() > s.size())
            return ret_vect;
        
        // Create the reference map to compare with possible anagrams
        for(int i = 0; i < p.size(); i++)
        {
            // Found the char
            if(ref_map.find(p[i]) != ref_map.end())
                ref_map[p[i]] += 1;
            // Couldn't find the char
            else
                ref_map.insert({p[i], 1});
        }

        // Logic - The reference map and a map created with an anagram will match

        map<char, int> temp_map;
        
        //Traverse through the string s
        for(int i = 0; i < s.size()-p.size()+1; i++)
        {
            temp_map.clear();
            // Create a temporary map in each iteration for length p
            for(int j = 0; j < p.size(); j++)
            {
                if(temp_map.find(s[i+j]) != temp_map.end())
                    temp_map[s[i+j]] += 1;
                else
                    temp_map.insert({s[i+j], 1});
            }

            // Match with the reference map                
            if(temp_map == ref_map)
                ret_vect.push_back(i);
        }
        return ret_vect;
    }
};