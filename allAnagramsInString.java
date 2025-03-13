// Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

// Time Complexity : O(m+n)
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, first take hashmap with character and frequency in string p. then traverse string s like window. when element is present in key for
 * incoming decrease count and if match is 0 increase match. If element is present in map for out going element increase count and if match is
 * 1 decrease match and after every iteration if match= size of map return index which is i-m+1 where m is p length. 
 */
 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< m;i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int i = 0;
        int match = 0;
        while(i<n){
            //incoming
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                int count = map.get(ch);
                if(count == 0){
                    match++;
                }
            }
            //outgoing
            if(i>=m){
                char out = s.charAt(i-m);
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count == 1){
                        match--;
                    }
                    map.put(out, count);
                }
            }
            if(match == map.size()) result.add(i-m+1);
            i++;
        }
        return result;
    }
}