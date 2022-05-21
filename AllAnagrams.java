import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {

    // Sliding window approach
    // TC: O(n) length of s
    // SC: O(1) - since no matter how long is p string, we'll be storing only 26 characters in a map
    public List<Integer> findAnagrams(String s, String p) {
        if(p == null || p.length() == 0 || s == null || s.length() == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        int match = 0;

        // Add the characters of p string into the mapping with their count
        for(int i=0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i=0; i < s.length(); i++) {
            char in = s.charAt(i);

            // Incoming character
            if(map.containsKey(in)) {
                int count = map.get(in);
                count--;
                if(count == 0){
                    match++;
                }
                map.put(in, count);
            }

            // Outgoing character
            if(i >= p.length()) {
                char out = s.charAt(i - p.length());

                if(map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if(count == 1){
                        match--;
                    }
                    map.put(out, count);
                }
            }

            if(match == map.size()) {
                result.add(i - p.length() + 1); // i - p.length() was the character we moved out
                                                // adding 1 gives the next index
            }
        }

        return result;
    }
}
