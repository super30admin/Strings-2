// Time Complexity : O(n + m) where n is the length of the string s and m is the length of the string p
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Create a hashmap of the characters of string p.
 * 2. Create a window of length p and slide it over the string s.
 * 3. Add and remove elements from the hashmap as the window slides.
 * 4. If all the characters in sliding window match the characters in the hashmap, add the left pointer to the result.
 * 5. Return the result.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(char ch : p.toCharArray()){
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0, len = s.length(), window = p.length();
        int matched = 0;

        while(right < len){
            char rightChar = s.charAt(right);
            if(pMap.containsKey(rightChar)){
                pMap.put(rightChar, pMap.get(rightChar) - 1);
                if(pMap.get(rightChar) == 0)
                    matched++;
            }

            if(matched == pMap.size()){
                result.add(left);
            }

            if(right >= window - 1){
                char leftChar = s.charAt(left);
                if(pMap.containsKey(leftChar)){
                    if(pMap.get(leftChar) == 0){
                        matched--;
                    }
                    pMap.put(leftChar, pMap.getOrDefault(leftChar, 0) + 1);
                }
                left++;
            }
            right++;
        }

        return result;
    }
}