import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TC: O(n) as all the character are traversed
// SC: O(n) as Map is considered as an extra space which is used in the code below

// Runs successfully on leetcode
// match variable is incremented/decremented based on the incoming or outgoing character.
// If it matches the p string length then the start index is pushed in the list
public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(findAnagrams("abab", "ab")); // [0,1,2]
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int match = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char incoming = s.charAt(i);
            if (map.containsKey(incoming)) {
                map.put(incoming, map.get(incoming) - 1);
                if (map.get(incoming) == 0)
                    match++;
            }
            if (match == map.size())
                list.add(i - p.length() + 1);
            if (i >= p.length() - 1) {
                char outgoing = s.charAt(start);
                if (map.containsKey(outgoing)) {
                    if (map.get(outgoing) == 0)
                        match--;
                    map.put(outgoing, map.get(outgoing) + 1);
                }
                start++;
            }
        }
        return list;
    }
}