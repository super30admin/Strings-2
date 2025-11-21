// Time Complexity : O(m+n) where m and n are the lengths of Strings s and p.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We need to perfrom sliding window as at each we have one incoming character and one outgoing character. When an incoming character
// comes we check if it's present in the hashmap created on characters of p. If yes, we reduce the value of it by 1 and increase the match
// value as we found a valid anagram character. When the parser goes beyond p length then we need to consider the outgoing character. If it
// is present in the map, we increase the value of it by 1 and check if it's equal to 1, reduce the match by 1 which means we let go of a
// matched anagram character.When match equals the map size, the start index is added to result.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int m = s.length();
        int n = p.length();
        int match = 0;
        for(int i=0;i<n;i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0) + 1); //store pattern string characters in a hashmap for freqency
        }

        for(int i=0;i<m;i++){
            char ch = s.charAt(i);//incoming character
            if(map.containsKey(ch)){ //character matched
                int count = map.get(ch) - 1;
                if(count == 0){
                    match++;
                }
                map.put(ch,count);//update hashmap
            }

            if(i >= n){
                char out = s.charAt(i-n);//outgoing character
                if(map.containsKey(out)){ //character matched
                    int count = map.get(out) + 1;
                    if(count == 1){
                        match--;
                    }
                    map.put(out, count);//update hashmap
                }
            }
            if(match == map.size()){
                result.add(i-n+1); //start index
            }
        }
        return result;
    }
}