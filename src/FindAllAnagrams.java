// Time Complexity:  O(s)
// Space Complexity: O(1)

import java.util.*;

class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int match = 0;

        for(int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            // incoming character
            if(map.containsKey(c)) {
                int freq = map.get(c);
                freq--;
                map.put(c, freq);
                if(freq == 0)                                // getting character matching with pattern
                    match++;
            }

            // outgoing character
            if(i >= p.length()) {
                char oldChar = s.charAt(i-p.length());
                if(map.containsKey(oldChar)) {
                    int freq = map.get(oldChar);
                    freq++;
                    map.put(oldChar, freq);
                    if(freq == 1)                            // outgoing character was matching with pattern
                        match--;
                }
            }

            if(match == map.size())
                result.add(i-p.length()+1);
        }

        return result;

    }
}

//// ****************************** ANOTHER METHOD ******************************
//// Time Complexity:  O(s)
//// Space Complexity: O(1)
//
//class FindAllAnagrams {
//    public List<Integer> findAnagrams(String s, String p) {
//
//        List<Integer> result = new ArrayList<>();
//
//        int[] pFreq = new int[26];
//        int[] sFreq = new int[26];
//
//        // getting frequency array
//        for(int i=0; i<p.length(); i++) {
//            pFreq[p.charAt(i)-'a']++;
//        }
//
//        for(int i=0; i<s.length(); i++) {
//
//            // new character
//            sFreq[s.charAt(i)-'a']++;
//
//            // old character
//            if(i>=p.length()) {
//                sFreq[s.charAt(i-p.length())-'a']--;
//            }
//
//            // if same substring
//            if(Arrays.equals(sFreq, pFreq)) {
//                result.add(i-p.length()+1);
//            }
//        }
//
//        return result;
//
//    }
//}