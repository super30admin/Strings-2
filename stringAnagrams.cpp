"""
Intuition: Use a sliding window technique to check for the count of the characters.
Use a hashmap to increase or decrease the count of the characters.
#####################################################################
Time Complexity : O(N), N = length of the string.
Space Complexity : O(N), N = length of the string.
#####################################################################
"""
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> result;
        if ( s.size() == 0) return result;
        map<char, int> count;
        for ( auto letter: p){
            count[letter] += 1;
        }
        
        int slow =0, fast =0, match = 0;
        
        for (int i =0; i < s.size(); i++){
            char incoming = s[i];
            if ( count.find(incoming) != count.end()){
                count[incoming] -=1;
                if ( count[incoming] == 0) match++;
                
            }
            
            if (i >= p.length() ){
                char outgoing = s[i - p.size()];
                if ( count.find(outgoing) != count.end()){
                    count[outgoing] +=1;
                    if ( count[outgoing] == 1) match--;

                }
            }
            
            if ( match == count.size()){
                result.push_back(i - p.size()+1);
            }

        }
        return result;
    }
};