//Time Complexity : O(m+n) where m is the length of string s and n is the length of string p
// Space Complexity : O(n) : space used for the map to store anagrams
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We use a sliding window approach to keep track of the current window in string s.
// 2. We maintain a count of characters in the current window and compare it with the count of characters in string p.
// 3. If the counts match, we have found an anagram and add the starting index to the result list.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         // Create a list to store the starting indices of anagrams
       List<Integer> result = new ArrayList<>();
         // If the input strings are empty or p is longer than s, return an empty list
       if(s.length() == 0 || p.length() > s.length()) return result;
       HashMap<Character, Integer> map = new HashMap<>();
            // Populate the map with the character counts from string p
        for(char c: p.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                 map.put(c,1);
            }
        }
        // Initialize a match counter to track how many characters have been matched
        int match = 0;
        // Iterate through the characters in string s
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // If the character is in the map, decrement its count and check if it matches
            // If the count reaches zero, increment the match counter
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1)
                if(map.get(c) == 0) match++;
            }
            // If the current index is greater than or equal to the length of p,
          if (i >= p.length()) {
                c = s.charAt(i - p.length());
                // If the character is in the map, increment its count
                if (map.containsKey(c)) {

                    map.put(c, map.get(c) + 1);
                    // If the count becomes 1, decrement the match counter
                    // This means we have removed a character from the current window
                    if (map.get(c) == 1) {
                        match--;
                    }
                }
            }
            // If the match counter equals the size of the map, we have found an anagram
        if(match == map.size()) result.add(i-p.length()+1);
        }
        // Return the list of starting indices of anagrams found in string s
        return result;
    }
} 