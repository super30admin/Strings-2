import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: O(m+n), m is length of s string and n is length of p string
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Iterate through s, expanding the window one character at a time.
 * Add the new character to sMap.
 * If the window size exceeds p.length(), remove the leftmost character from sMap to maintain a window of size p.length().
 * After adjusting sMap, compare it with pMap.
 * If they match, the start index (i - p.length() + 1) is an anagram's starting position, so add it to the result list.
 */

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        // get the frequency of all characters in p string
        for (char c: p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int pLen = p.length();
        List<Integer> result = new ArrayList<>();
        // Slide over s string while checking if the pMap and sMap are equal
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (i >= pLen) {
                char oldChar = s.charAt(i - pLen);
                if (sMap.get(oldChar) == 1) {
                    sMap.remove(oldChar);
                } else {
                    sMap.put(oldChar, sMap.get(oldChar) - 1);
                }
            }

            if (sMap.equals(pMap)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagrams obj = new FindAllAnagrams();
        List<Integer> result = obj.findAnagrams("abgcabcgaaabcbabc", "cba");
        System.out.println(result);
        assert (result.equals(List.of(3,4,10,12,14)));
    }
}