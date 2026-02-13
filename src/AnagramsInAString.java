/*
Problem - Given two strings s and p, return an array of all the start indices of p's anagrams in s.
Approach - So we count the characters of p in a map first.
Then we move a sliding window on s and keep adjusting counts while checking matches.
If all characters match in count, we store the starting index.
Time Complexity - O(m+n)
Space Complexity - O(1) // character map
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if(n>m) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1); // map the characters and their counts for a string P
        }
        int match = 0;
        for(int i = 0; i < m; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int freq = map.get(in);
                freq--;
                map.put(in,freq);
                if(freq == 0) {
                    match++; // if a character of P is found in S increase the match count
                }
            }
            if(i>=n){ // window size until length of string p
                char out = s.charAt(i-n);
                if(map.containsKey(out)) {
                    int freq = map.get(out);
                    freq++;
                    map.put(out, freq);
                    if (freq == 1) {
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i-n+1); // starting index where the match is found
            }
        }
        return result;
    }
}
