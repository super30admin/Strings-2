
//tc is O(n)
//sc is O(1)
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        if (s == null || p == null || p.length() > s.length() || s.length() == 0 || p.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int match = 0;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char incomingChar = s.charAt(i);

            if (map.containsKey(incomingChar)) {
                int count = map.get(incomingChar);
                count--;
                if (count == 0) {
                    match++;
                }

                map.put(incomingChar, count);
            }

            if (i >= p.length()) {
                char outgoingChar = s.charAt(i - p.length());
                if (map.containsKey(outgoingChar)) {
                    int count = map.get(outgoingChar);
                    count++;
                    if (count == 1) {
                        match--;

                    }

                    map.put(outgoingChar, count);
                }

            }

            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}