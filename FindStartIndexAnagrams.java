// In this problem, storing the characters in string p with its frequency in hashmap indicating that many of that character required 
// in any anagram, then iterating through the string s, checking a substring of length p, if char in hashmap, reduce it's frequency,
// and if the frequency becomes zero increase match variable by 1. Whenever match == p.length, indicates we found a anagram, so add
// start index to the result. Also, if the length of substring we are checking becomes greater than p, we remove start character and
// increase it's frequency in map if present. If the frequency becomes 1, decrease match by 1, indicating we lost one matching char.

// Time Complexity : O(m+n) - m for iterating over s and n for iterating over p to build hashmap
// Space Complexity : O(1)  26 characters only at worst
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Base case
        if (s == null || s.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        // Match variable for keeping count how many matching chars we found so far
        int match = 0;
        // HashMap for storing chars in p with its frequency
        HashMap<Character, Integer> map = new HashMap<>();
        // Result list
        List<Integer> result = new ArrayList<>();
        // Iterate through p and put in map
        for (int i = 0; i < p.length(); i++) {
            char c1 = p.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }
        // Iterate through s
        for (int i = 0; i < s.length(); i++) {
            // Take one char at a time
            char incoming = s.charAt(i);
            // Check if char present in map
            if (map.containsKey(incoming)) {
                // get it's frequency
                int count = map.get(incoming);
                // Reduce by 1, because we found one matching char
                count--;
                // If count ==0 that means we found all the occurences of this char that needs
                // to be in anagram
                if (count == 0) {
                    // So increase match by 1
                    match++;
                }
                // put the updated in map
                map.put(incoming, count);
            }
            // If our current window is having more number of chars than chars in p, means
            // we wont find a anagram
            if (i >= p.length()) {
                // So remove the char present at start index of this substring
                char outgoing = s.charAt(i - p.length());
                // Check if the char removed was in map
                if (map.containsKey(outgoing)) {
                    // If yes than get it's frequency
                    int count = map.get(outgoing);
                    // Increase by 1, because we removed it from our window, so now we will require
                    // one more to whatever was already required
                    count++;
                    // Check if the count has become 1
                    if (count == 1) {
                        // Then reduce match, because we lost a matching char
                        match--;
                    }
                    // Put the update value in map
                    map.put(outgoing, count);
                }
            }
            // Check if the match size is same as length of p, means we found a anagram
            if (match == map.size()) {
                // Add the start index of that anagram to our result list
                result.add(i - p.length() + 1);
            }
        }
        // Return result
        return result;
    }
}