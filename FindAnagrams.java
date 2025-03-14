import java.util.ArrayList;
import java.util.List;

/*
 * TC = O(26*m) = O(m) where m is the size of s
 * SC = O(26) = O(1)
 */
public class FindAnagrams  {
    /**
     * Encapsulated array that functions as a CharMap
     * and allows for easy comparison via equals method
     */
    static class CharMap {
        int[] counts;
        int size;

        CharMap() {
            counts = new int[26];
            size = 0;
        }

        void increment(char c) {
            if(counts[c - 'a'] == 0) size++;
            counts[c - 'a']++;
        }

        void decrement(char c) {
            counts[c - 'a']--;
            if(counts[c - 'a'] == 0) size--;
        }

        @Override
        public boolean equals(Object other) {
            if(!(other instanceof CharMap ocm)) return false;
            if(this == ocm) return true;
            if(this.size != ocm.size) return false;
            for(int i = 0; i < 26; i++) {
                if(this.counts[i] != ocm.counts[i]) return false;
            }
            return true;
        }
    }
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        if(n > m) return new ArrayList<>();
        CharMap pMap = new CharMap();
        CharMap sMap = new CharMap();
        int j = 0;
        // create maps for the first n characters
        for(char c: p.toCharArray()) {
            pMap.increment(c);
            sMap.increment(s.charAt(j++));
        }
        List<Integer> result = new ArrayList<>();
        if(pMap.equals(sMap)) result.add(0);
        for(int i = n; i < m; i++) {
            //remove the last element from sMap
            //and add the next one
            sMap.decrement(s.charAt(i - n));
            sMap.increment(s.charAt(i));
            //if the maps are equal at this point
            //add the corresponding index to the list
            if(pMap.equals(sMap)) result.add(i - n + 1);
        }
        return result;
    }
}