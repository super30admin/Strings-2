//Time : O(n)
//Space : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Arrays to store character counts
        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // Count the frequency of characters in p
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        int matches = 0;
        // Initial comparison
        for (int i = 0; i < 26; i++) {
            if (pCount[i] == windowCount[i]) {
                matches++;
            }
        }

        // Sliding window over s
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (matches == 26) {
                result.add(i); // If all characters match, add the starting index
            }

            // Slide the window by adding the next character and removing the previous one
            int startCharIndex = s.charAt(i) - 'a';
            int endCharIndex = s.charAt(i + p.length()) - 'a';

            // Remove the character going out of the window
            windowCount[startCharIndex]--;
            if (windowCount[startCharIndex] == pCount[startCharIndex]) {
                matches++;
            } else if (windowCount[startCharIndex] + 1 == pCount[startCharIndex]) {
                matches--;
            }

            // Add the character coming into the window
            windowCount[endCharIndex]++;
            if (windowCount[endCharIndex] == pCount[endCharIndex]) {
                matches++;
            } else if (windowCount[endCharIndex] - 1 == pCount[endCharIndex]) {
                matches--;
            }
        }

        // Check the last window
        if (matches == 26) {
            result.add(s.length() - p.length());
        }

        return result;
    }
}
