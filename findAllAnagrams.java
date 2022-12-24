// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 * We keep track of all characters and count in the string p and use sliding window to chekc for ocuurences of p in s 
 * by decrementing count when the letter enters the window and incrementign count when letter leaves the window.
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if ( s.length() < p.length() ) return new ArrayList();
        
        Map<Character, Integer> pFreqMap = new HashMap<Character, Integer>();
        List<Integer> result = new ArrayList();
        int sLen = s.length(), match = 0;
        
        //freq map for p { a: 1, b: 1, c:1}
        for ( char ch : p.toCharArray()){
            pFreqMap.put(ch,pFreqMap.getOrDefault(ch,0)+1);
        }
        //iterate through s to find substrings
        for(int j = 0; j < s.length(); j++) {
            char chNew = s.charAt(j);
            // if char is in map
            //incoming char for window -decrease freq
            if(pFreqMap.containsKey(chNew)){
                pFreqMap.put(chNew,pFreqMap.getOrDefault(chNew,0)-1);
                if(pFreqMap.get(chNew) == 0) match++;
            }
            //outgoing char for window -decrease freq
            if(j >= p.length()){
                char chOld = s.charAt(j-p.length());
               if(pFreqMap.containsKey(chOld)){
                pFreqMap.put(chOld,pFreqMap.getOrDefault(chOld,0)+1);
                if(pFreqMap.get(chOld) == 1) match--;
            } 
            }
            
            //if match is eqal to map size, we found our anagram
            if(match == pFreqMap.size()){
                result.add(j-p.length()+1);
            }
        }
         return result;
    }
}
