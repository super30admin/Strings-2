import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // return findAnagramsByComparingMaps(s, p);
         return findAnagramsByUsingMatchCount(s, p);
    }

    // TC: O(M + N) where M is length of s and N is length of p
    // SC: O(1)
    private List<Integer> findAnagramsByUsingMatchCount(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int match = 0, k = p.length();
        for (int i = 0; i < s.length(); i++) {
            // incoming char
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in);
                count--;
                if (count == 0) {
                    match++;
                }
                map.put(in, count);
            }
            if (i >= k) {
                // outgoing char
                char out = s.charAt(i - k);
                if (map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if (count == 1) {
                        match--;
                    }
                    map.put(out, count);
                }
            }
            if (match == map.size()) {
                res.add(i - k + 1);
            }
        }
        return res;
    }

    // TC: O(M + N) where M is length of s and N is length of p
    // SC: O(1)
    private List<Integer> findAnagramsByComparingMaps(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int k = p.length();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            windowMap.put(s.charAt(i), windowMap.getOrDefault(s.charAt(i), 0) + 1);
            if (i >= k) {
                char outgoing = s.charAt(i - k);
                windowMap.put(outgoing, windowMap.get(outgoing) - 1);
                if (windowMap.get(outgoing) == 0) windowMap.remove(outgoing);
            }
            if (windowMap.equals(map)) {
                res.add(i - k + 1);
            }
        }
        return res;
    }
}
