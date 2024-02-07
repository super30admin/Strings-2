/*
* Approach:
*  1. Sliding Window with hashmap:
        iterate over p add store the freq in hashmap
* 
*  2. Iterate over s and check in hashmap. if hashmap contains key,
        decrease the freq of char,if freq is 0, increase matchcount

    if size of window == length of s,
        remove the first char of window while adding new char at end,
        revert the effect of outgoing char by modifying the freq of hashmap
* 
*  3. If freq of character is changing from O to 1, matchCount--
    if matchCount == total unique chars(hmap size), add the start index to result.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n+2m)
    n   = length of p
    m   =  length of s
* 
* Space Complexity: O(26) == O(1)
    hashmap
* 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int m = s.length(), n = p.length();

        if (m < n)
            return result;

        HashMap<Character, Integer> hmap = new HashMap<>();

        for (int index = 0; index < n; index++) {
            char ch = p.charAt(index);

            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }

        int match = 0;

        for (int index = 0; index < m; index++) {
            char ch = s.charAt(index);

            // in
            if (hmap.containsKey(ch)) {
                hmap.put(ch, hmap.get(ch) - 1);

                if (hmap.get(ch) == 0) {
                    match++;
                }
            }

            // out
            if (index >= n) {
                char out = s.charAt(index - n);

                if (hmap.containsKey(out)) {
                    hmap.put(out, hmap.get(out) + 1);

                    if (hmap.get(out) == 1) {
                        match--;
                    }
                }
            }

            if (match == hmap.size()) {
                result.add(index - n + 1);
            }
        }

        return result;
    }
}