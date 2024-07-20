import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 Approach - Sliding Window
 TC - O(m+n), SC - O(m) {m = p.length, n = s.length}
 1. Using hashmap to store frequency of each characters in p
 2. Using sliding window of fixed length of p and start the pointer from i=0 to i = s.length-1
 and check if the window contains the anagram of p.
 3. If window contains the anagram of p, then add the start index of window to list.
 To check whether a window contains an anagram, we will keep a match variable to check if match == map.size(),
 Increment match value whenever the count of a character in hashmap becomes 0 (for incoming character),
 Decrement match value whenever the count of a character in hashmap becomes 1 (for outgoing character)
 */

class FindAllAnagramsStr {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        //base condition
        if(s == null || s.length() ==0 || p.length() > s.length())
            return result;
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int match =0;

        for(int i =0; i < s.length(); i++) {

            //logic for incoming character
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)) {
                int count = map.get(incoming);
                count = count-1;
                map.put(incoming, count);
                if(count == 0) {
                    match++;
                }
            }

            //logic for outgoing character
            if(i >= p.length()) {
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)) {
                    int count = map.get(outgoing);
                    count = count+1;
                    map.put(outgoing, count);
                    if(count == 1) {
                        match--;
                    }
                }
            }

            if(match == map.size()) {
                result.add(i - p.length()+1);
            }
        }

        return result;
    }
}