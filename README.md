# Strings-2


## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().





class Solution {
    //TC O(n+m) SC O(m)
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        
        int m = haystack.length();
        int n = needle.length();
        int[] lps = lps(needle);
        int i = 0;
        int j = 0;
        while(i < m){
            
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j==n) return i-n;
            }else if(haystack.charAt(i) != needle.charAt(j) && j>0){
                j = lps[j-1];
            }else if(haystack.charAt(i) != needle.charAt(j) && j==0){
                i++;
            }
            
            
        }return -1;
    }
        private int[] lps(String needle){
            int i = 1;
            int j = 0;
            int[] lps = new int[needle.length()];
            while(i<needle.length()){
                if(needle.charAt(i) == needle.charAt(j)){
                    j++;
                    lps[i] = j;
                    i++;
                }
                else if(needle.charAt(i) != needle.charAt(j) && j>0){
                    j = lps[j-1];
                }
                else if(needle.charAt(i) != needle.charAt(j) && j==0){
                    lps[i] =0;
                    i++;
                }
            }
        return lps;
        }
        
    }


## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


class Solution {
    // TC O(n+m) SC O(1)
    public List<Integer> findAnagrams(String s, String p) {
        if(p == null || p.length() == 0 || p.length() > s.length()) return new ArrayList<>();
        
        List<Integer>  result = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;
        for(int i =0; i< p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(int i =0; i< s.length(); i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0){
                    match++;
                }
                map.put(in, cnt);
            }
        
        if(i >= p.length()){
            char out = s.charAt(i - p.length());
            if(map.containsKey(out)){
                int cnt = map.get(out);
                cnt++;
                if(cnt == 1){
                    match--;
                }
                map.put(out, cnt);
            }
            
        }
        if(match == map.size()){
            result.add(i-p.length() +1);
        }
        
    }
    return result;}
}
