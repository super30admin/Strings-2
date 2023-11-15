// ## Problem2 
// Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

// Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int match = 0;
        for(int i=0; i<m; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in) - 1;
                if(cnt == 0){
                    match++;
                }
                map.put(in, cnt);
            }
            if(i>=n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int cnt = map.get(out)+1;
                    if(cnt == 1){
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
        
        if(match == map.size()){
            list.add(i-n+1);
        }
        }
        return list;
    }
}


// # Strings-2

// ## Problem1  Implement strStr() (https://leetcode.com/problems/implement-strstr/)
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        BigInteger hash1 = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);
        for(int i=0; i<n ;i++){
            char c = needle.charAt(i);
            hash1 = hash1.multiply(k).add(BigInteger.valueOf(c - 'a' + 1));
        }
        BigInteger hash2 = BigInteger.ZERO;
        for(int i=0; i<m; i++){
            if(i>=n){
                hash2 = hash2.mod(k.pow(n-1));
            }
            char b = haystack.charAt(i);
            hash2 = hash2.multiply(k).add(BigInteger.valueOf(b - 'a' + 1));
            if(hash1.equals(hash2)) return i-n+1;
        }
        return -1;
    }
}