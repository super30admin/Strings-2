// Time Complexity: O(n) n-> length of string s
// Space Complexity: O(m) m-> length of string p
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use sliding window technique. Use hashmap to store char frequency of string p
// 2. While iterating over char in string s, for each char, if present in map, decrement the freq
// 3. If freq == 0, increment match count. For out char, increment the freq and decrement match if freq == 1
// 4. If match == hashmap size, add the start index of anagram in result

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pFreqMap = new HashMap<>();

        List<Integer> indices = new ArrayList<>();
        int match = 0;
        int pLen = p.length();
        int sLen = s.length();

        for(int i=0; i<pLen; i++) {
            char c = p.charAt(i);
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<sLen; i++) {
            char c = s.charAt(i);

            if(pFreqMap.containsKey(c)) {
                int freq = pFreqMap.get(c);
                freq--;
                pFreqMap.put(c, freq);

                if(freq == 0) {
                    match++;
                }
            }

            if(i >= pLen) {
                char out = s.charAt(i - pLen);
                if(pFreqMap.containsKey(out)) {
                    int freq = pFreqMap.get(out);
                    freq++;

                    pFreqMap.put(out, freq);

                    if(freq == 1) {
                        match--;
                    }
                }
            }

            if(match == pFreqMap.size()) {
                indices.add(i - pLen + 1);
            }
        }
        return indices;
    }
}
