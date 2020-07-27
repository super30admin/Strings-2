// Time Complexity : O(n+m) // We go through the elements just once
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : undesrtanding outgoing character was a bit tricky
// Your code here along with comments explaining your approach
//1. Create a hashmap to note the frequency of occurence of each character
//2. Go through the string increase the count when a occurence is found. when all matches are found add the result
//3. For the outgoing character increment the count and when the count is '1' the match is lost.
class Solution {
public:
    vector<int> result;
    vector<int> findAnagrams(string s, string p) {
        //edge
        if(s.length()==0 || s.length()<p.length() || p.length()==0 ) return result;
        
        //logic
        unordered_map<char,int> pat_map;
        for(int i=0; i<p.length();i++)
            ++pat_map[p[i]];
        
        int match=0; int count=0;
        //strart string s traversal
        for(int fast=0; fast<s.length();fast++){
            if(pat_map.find(s[fast]) != pat_map.end()) { //contained
                count = pat_map[s[fast]] -1; 
                pat_map[s[fast]] = count; 
                if(count ==0) match++;
               
            }
            if(fast >= p.length()) {
                char c=s[fast-p.length()];
                if(pat_map.find(c) != pat_map.end()){
                    count = pat_map[c] +1; 
                    pat_map[c] = count; //remove the match of the releasing element
                    if (count ==1) match--;
                 }
            }
             if(match==pat_map.size()) result.push_back(fast-p.length()+1); //wait till the pattern length is reached
        }
        
        return result;
    }
};
