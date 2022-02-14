/**
 * Time Complexity:
 * The time complexity is O(n) as we are going through the string only once.
 */

/**
 * Space Complexity:
 * The space complexity of the solution is O(1) as the hash map we have
 * created for calculations cannot have more than 26 characters.
 */



/**
 * Approach:
 * The first intution that comes to mind is brute force but the
 * time complexity will be O(m*n) where m is the length of the string
 * and n is the length of the pattern.
 * 
 * To optimize this solution we think of maintaining a hash map for the frequency of pattern
 * The intution behind this thought is we keep the track of the elements of the pattern in the
 * string. Building on this intution we have to maintain a window too, because the anagram
 * cannot have length greater than the length of the pattern. So, we have to find all
 * the characters of the pattern in the string with a window size of the length of the pattern. 
 * We also maintain a match count which tells us that when the match count is equal to the
 * size of the pattern which means all the characters have been found we have found our anagram.
 * So for each type of character match increments by 1 when its frequency becomes 0 from 1 in the map
 * and decrements by 1 when the frequency goes from 0 to 1. The frequency will increment when the 
 * outgoing character from the window is present in the pattern or map.
 * 
 */

// The code ran perfectly on leetcode

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        int sLen = s.size();
        int pLen = p.size();
        unordered_map<char, int> freqMap;
        for(int i =0; i< pLen; i++){
            if(freqMap.find(p[i])!= freqMap.end()){
                freqMap[p[i]]++;
            } else {
                freqMap.insert(make_pair(p[i],1));
            }
        }
        int match = 0;
        for(int i = 0; i<sLen; i++){
            char in = s[i];
            if(freqMap.find(in) != freqMap.end()){
                int count = freqMap[in];
                count--;
                if(count==0){
                    match++;
                }
                freqMap[in] = count;
            }
            
            if(i>=pLen){
                char out = s[i-pLen];
                if(freqMap.find(out) != freqMap.end()){
                int count = freqMap[out];
                count++;
                if(count==1){
                    match--;
                }
                    freqMap[out] = count;
                }
                
            }
            if(match == freqMap.size()){
                result.push_back(i-pLen +1);
            }
        }
        
        return result;
        
    }
};