// Time Complexity : O((n-m)*m) where n and m are lengths of strings s and p respectively
// Space Complexity : O(m) where m is the length of the string p 

<-----Brute Force---->
class Solution {    
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

<------Sliding Window Aproach--->
// Time Complexity : O(n) where n is the length of the string s 
// Space Complexity : O(1) because size of hashmap is fixed to 26

class Solution {    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || s.length() < p.length()) return ans; 
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                map.put(in, map.get(in) - 1);
                if (map.get(in) == 0) match++;
            }
            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if (map.get(out) == 1) match--;
                }
            }
            if (match == map.size()) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}

