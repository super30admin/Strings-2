//Time = O(n)
//Space = O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Initialize an empty list to hold the starting indices of anagrams of p in s
        List<Integer> result = new ArrayList<Integer>();
        
        // Check for invalid input
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        
        // Initialize two arrays of length 26 to count the occurrences of each lowercase letter in p and s
        int[] pChars = new int[26];
        int[] sChars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pChars[p.charAt(i) - 'a']++;
            sChars[s.charAt(i) - 'a']++;
        }
        
        // Check each substring of length p.length() in s using a sliding window approach
        for (int i = p.length(); i < s.length(); i++) {
            // If the occurrences of each letter in the substring are the same as the occurrences in p, add the starting index of the substring to the result list
            if (Arrays.equals(pChars, sChars)) {
                result.add(i - p.length());
            }
            // Update the counts of the letters in the sliding window and move the window to the right by one character
            sChars[s.charAt(i - p.length()) - 'a']--;
            sChars[s.charAt(i) - 'a']++;
        }
        
        // Check one final time if the occurrences of each letter in the last substring are the same as the occurrences in p and add the starting index of the last substring to the result list if they are the same
        if (Arrays.equals(pChars, sChars)) {
            result.add(s.length() - p.length());
        }
        
        // Return the result list containing the starting indices of all anagrams of p in s
        return result;
    }
}
