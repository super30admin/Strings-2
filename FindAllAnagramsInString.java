// Time Complexity : O(n) where n = len of s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use sliding window technique with a hashmap to store character counts of pattern p.
//   - As window moves over s, decrement count for incoming character and increment for outgoing character.
//   - Maintain a match counter to track how many characters fully matched.
//   - If match count equals hashmap size, add window start index to result.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();

        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;  //keep no of char matched with p
        for(int i = 0; i < m; i++) {
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int freq = map.get(in);
                freq--;
                map.put(in, freq);
                if(freq == 0) {
                    match++;
                }
            }

            if(i >= n) {
                char out = s.charAt(i - n);
                if(map.containsKey(out)) {
                    int freq = map.get(out);
                    freq++;
                    map.put(out, freq);
                    if(freq == 1) {
                        match--;
                    }
                }
            }

            if(match == map.size()) {
                result.add(i - n + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString obj = new FindAllAnagramsInString();

        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println("Anagram indices: " + obj.findAnagrams(s1, p1)); // Expected: [0, 6]

    }
}
