## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

// Time Complexity - 0(n)
// Space Complexity - 0(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p == null || p.length() == 0 || s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in);
                count--;
                if (count == 0) {
                    match++;
                }
                map.put(in, count);
            }
            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                if (map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    if (count == 1) {
                        match--;
                    }
                    map.put(out, count);
                }
            }
            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}

## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

// Time Complexity - 0(m + n) where m is the length of the haystack string and n is the length of the needle string.
// Space Complexity - 0(1) because it only uses a fixed-size array last to store the last occurrence of each character in the needle string.

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        int[] last = new int[256];

        for (int i = 0; i < 256; i++) {
            last[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            last[needle.charAt(i)] = i;
        }

        int i = n - 1;
        int j = n - 1;

        while(i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == 0) {
                    return i;
                }
                i--;
                j--;
            }
            else {
                i += n - Math.min(j, 1 + last[haystack.charAt(i)]);
                j = n - 1;
            }
        }
        return -1;   
    }
}