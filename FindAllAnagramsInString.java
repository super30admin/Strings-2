/*
 * FindAllAnagramsInString
 *
 * Algorithm approach:
 * - Sliding window over the source string `s` with a frequency map built from pattern `p`.
 * - Maintain counts for characters present in `p`. For each incoming character decrement
 *   its count and for outgoing character increment its count back. Track how many
 *   distinct characters have matched the required frequency.
 *
 * Time complexity: O(S + P) where S = s.length(), P = p.length(). We visit each
 *   character of `s` once and build the frequency map for `p` in O(P).
 * Space complexity: O(K) where K is the number of distinct characters in `p` (<= 26
 *   for lowercase letters), for the frequency map.
 *
 * LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/ (438)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || p.isEmpty() || p.length() > s.length()) {
            return result;
        }
        int n = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int match = 0;

        for (int i = 0; i < s.length(); i++) {
            //incoming char
            char inChar = s.charAt(i);
            if (map.containsKey(inChar)) {
                int count = map.get(inChar) - 1;
                map.put(inChar, count);
                if (count == 0) {
                    match++;
                }
            }

            //outgoing char
            if (i >= n) {
                char outChar = s.charAt(i - n);
                if (map.containsKey(outChar)) {
                    int count = map.get(outChar) + 1;
                    map.put(outChar, count);
                    if (count == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - n + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInString().findAnagrams("cbaebabacd" ,"abc"));
    }
}
