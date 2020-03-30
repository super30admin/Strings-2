// Time Complexity : O(m+n) n--> no. characters in string s, m - > no. of characters in string p
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Since we need to identify start index for matching patterns in p, we'll create a frequency map for p.
// While iterating over string s, we can maintain a window of length p and create frequency map for s.
// For each window of length p, we need to compare the frequency maps of p and s to identify if those are anagram or not.
// While shifting the window, count needs to be decremented and 1st character from previous window needs to be removed from freq map of s. The new character needs to be added in freq map of s and count will be incremented.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>(); // result
        int slen = s.length();
        int plen = p.length();
        // edge case checks
        if(s == null || p == null || slen == 0) 
            return result;
        if(plen > slen)
            return result;
        
        int i = 0, count = 0;
        int[] ch1 = new int[26]; // array to map frequency of p
        int[] ch2 = new int[26]; // array to map frequency of elements in s 
        for(int k = 0; k < plen; k++) { // creating frequency map of p
            ch1[p.charAt(k)-'a']++;
        }
        while(i < slen) {
            ch2[s.charAt(i)-'a']++; // added character in frequency map of s
            count++; // count of elements in frequency map of s
            if(ch1[s.charAt(i)-'a'] > 0) { // checking if the current element added in freq map s exists in freq map p
                if(count == plen && anagram(ch1, ch2)) { // checking if the two frequency maps created are anagram 
                    result.add(i-plen+1);
                }
            }
            if(i-plen+1 >= 0) { // if start index is valid
                count--;
                ch2[s.charAt(i-plen+1)-'a']--;
            }
            i++; // increment i to consider next window
        }
        return result;
    }
    
    private boolean anagram(int[] p1, int[] p2) {
        if(Arrays.equals(p1,p2))
            return true;
        return false;
    }
}

