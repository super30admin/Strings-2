import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        // Frequency array for string p
        int[] parr = new int[26];
        for (char c : p.toCharArray()) {
            parr[c - 'a']++;
        }

        // Frequency array for the current window in s
        int[] temp = new int[26];

        // Initialize the first window
        for (int i = 0; i < p.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }

        // Check if the first window is an anagram
        if (areArraysEqual(parr, temp)) {
            result.add(0);
        }

        // Sliding window approach: slide through s from p.length() to s.length()
        for (int i = p.length(); i < s.length(); i++) {
            // Add the new character to the window (right side)
            temp[s.charAt(i) - 'a']++;

            // Remove the leftmost character from the window (left side)
            temp[s.charAt(i - p.length()) - 'a']--;

            // Check if the current window is an anagram
            if (areArraysEqual(parr, temp)) {
                result.add(i - p.length() + 1);  // Add the starting index of the anagram
            }
        }

        return result;
    }

    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
