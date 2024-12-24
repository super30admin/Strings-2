// Time Complexity:  Frequency of pMap construction  O(p) and looping through sliding window O(s). So overall time complexity is O(s + p)
// Space Complexity:  O(1) due to hashmap
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

    public class AnagramIndex {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s.length() < p.length()) return result;

            HashMap<Character, Integer> pMap = new HashMap<>();
            HashMap<Character, Integer> sMap = new HashMap<>();

            // Fill frequency map for p
            for (char c : p.toCharArray()) {
                pMap.put(c, pMap.getOrDefault(c, 0) + 1);
            }

            int windowSize = p.length();

            // Fill frequency map for the first window in s
            for (int i = 0; i < windowSize; i++) {
                char c = s.charAt(i);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }

            // Check the first window
            if (pMap.equals(sMap)) {
                result.add(0);
            }

            // Slide the window
            for (int i = windowSize; i < s.length(); i++) {
                // Add the new character to the window
                char inChar = s.charAt(i);
                sMap.put(inChar, sMap.getOrDefault(inChar, 0) + 1);

                // Remove the character that is sliding out of the window
                char outChar = s.charAt(i - windowSize);
                if (sMap.get(outChar) == 1) {
                    sMap.remove(outChar);
                } else {
                    sMap.put(outChar, sMap.get(outChar) - 1);
                }

                // Check if the current window is an anagram
                if (pMap.equals(sMap)) {
                    result.add(i - windowSize + 1);
                }
            }

            return result;
        }

        public static void main(String[] args) {
            AnagramIndex solution = new AnagramIndex();

            // Example test cases
            String s1 = "cbaebabacd";
            String p1 = "abc";
            System.out.println("Indices: " + solution.findAnagrams(s1, p1)); // Output: [0, 6]

            String s2 = "abab";
            String p2 = "ab";
            System.out.println("Indices: " + solution.findAnagrams(s2, p2)); // Output: [0, 1, 2]
        }
    }

