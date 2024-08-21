import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    /**
     * Time Complexity: O(n), where n is the length of string 's'.
     * Space Complexity: O(m), where m is the length of string 'p'.
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Create a HashMap to store the frequency of each character in string p
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Populate the frequency map for characters in string p
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0; // Left pointer of the sliding window
        int right = 0; // Right pointer of the sliding window
        int match = 0; // Number of characters with matching frequencies
        ArrayList<Integer> result = new ArrayList<>(); // List to store starting indices of anagrams
        int requiredMatches = map.size(); // Total unique characters in p

        // Traverse the string s with the right pointer
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // Include the current character in the window
            if (map.containsKey(rightChar)) {
                int count = map.get(rightChar) - 1;
                map.put(rightChar, count);
                if (count == 0) {
                    match++; // One more character frequency matched
                }
            }

            // When the window size exceeds the length of p
            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    int count = map.get(leftChar) + 1;
                    map.put(leftChar, count);
                    if (count == 1) {
                        match--; // One character frequency no longer matches
                    }
                }
                left++; // Shrink the window from the left
            }

            // If all character frequencies match, add the start index to the result
            if (match == requiredMatches) {
                result.add(left);
            }
            
            right++; // Expand the window to the right
        }
        
        // Return the list of starting indices of anagrams
        return result;
    }
}
