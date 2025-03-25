// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

//Approach: 
//1. Create a hashmap for string p and string s.
//2. Check if the size of string s is less than string p, return empty vector.
//3. Check the first window of size p in string s and compare the hashmap of string p and string s.
//4. If they are equal, add the starting index of the window to the result vector.
//5. For the remaining windows, slide the window by adding the next character and removing the first character of the window.
//6. If the hashmap of string p and string s are equal, add the starting index of the window to the result vector.
//7. Return the result vector.

class Solution {
    public:
        vector<int> findAnagrams(string s, string p) {
            unordered_map<char, int> s_map;
            unordered_map<char, int> p_map;
            vector<int> result; 
            if(s.size() < p.size()){return result;}
            for(char c : p){
                p_map[c]++;
            }
            //Check first window
            for(int i = 0; i < p.size(); i++){
                s_map[s[i]]++;
            }
            if(s_map == p_map){
                result.push_back(0);
            }
            //Remaining windows
            for(int i = p.size(); i < s.size(); i++){
                s_map[s[i]]++;
                s_map[s[i - p.size()]]--;
    
                if(s_map[s[i - p.size()]] == 0){
                    s_map.erase(s[i - p.size()]);
                }
                if(s_map == p_map){
                    result.push_back(i - p.size() + 1);
                }
            }
    
            return result;
        }
    };