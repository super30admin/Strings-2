package Strings2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class question98_FindAllAnagramsInString {
    /* Created by palak on 7/14/2021 */

    /*
    Using Sliding Window and HashMap
        Time Complexity: O(n + m) => O(n)
        Space Complexity: O(n)
    */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p.length() > s.length()) return result;

        HashMap<Character, Integer> map = new HashMap<>();
        //insert p into the map
        for(int i = 0; i < p.length() ; i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int match = 0;

        for(int i = 0 ; i < s.length() ; i++) {
            //Check if incoming character is present in map and then perform certain steps.
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int count = map.get(in);
                count--;
                if(count == 0) match++;
                map.put(in, count);
            }
            //Check for the outgoing character in the sliding window
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if(count == 1) match--;
                    map.put(out, count);
                }
            }
            if(match == map.size()) result.add(i - p.length() + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}