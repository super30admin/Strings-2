// Time Complexity : O((n-m)*m) where n and m are lengths of strings s and p respectively
// Space Complexity : O(m) where m is the length of the string p 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Make all possible substrings of s and find if they are anagrams of p

class findAnagrams_BruteForce {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || s.length() < p.length()) return ans; 
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String str = s.substring(i, i + p.length());
            if (isAnagram(str, p)) {
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i > 0) return false;
        }
        return true;
    }
}