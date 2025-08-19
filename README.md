# Strings-2


## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

TC: O(m*n)
SC: O(1)

Approach:-
1. We will run a loop on haystack string 
2. and if we find the first character that matches with the first character in needle we will check for the substring
3. if substring found we return the index else -1

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0 || haystack.length() == 0){
            return 0;
        }

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            char ch = haystack.charAt(i);
            char cn = needle.charAt(0);

            if(ch != cn){
                continue;
            }

            String check = haystack.substring(i, i+needle.length());

            if(check.equals(needle)){
                return i;
            }
        }

        return -1;
    }
}

## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

TC: O(n)
SC: O(1)

Approach:-
1. We will mark the frequency of each character in p string using a hashmap
2. then we will use the concept of sliding window and whenever the length of the current window becomes equal to the length of the p string we will add the index which is pointed by the left pointer to the result list

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
            return res;
        } 

        Map<Character, Integer> freq = new HashMap<>();

        //hashmap to store freq of all the characters of string p
        for (char c : p.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, len = 0;
        //looping to find all the valid anagrams of string p in s
        while (right < s.length()) {
            char ch = s.charAt(right);
            //if the char is present in the hashmap
            if (freq.containsKey(ch)) {
                if (freq.get(ch) > 0) {
                    len++;
                }
                freq.put(ch, freq.get(ch) - 1);
            }
            //if the length of the window is greater than the length of the string p
            if (right - left + 1 > p.length()) {
                char cl = s.charAt(left);
                if (freq.containsKey(cl)) {
                    if (freq.get(cl) >= 0) {
                        len--;
                    }
                    freq.put(cl, freq.get(cl) + 1);
                }
                left++;
            }
            //if the length is qual to the length of string p, we found the anagram 
            if (len == p.length()) {
                res.add(left);
            }

            right++;
        }

        return res;
    }
}