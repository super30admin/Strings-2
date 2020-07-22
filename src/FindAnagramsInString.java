// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/** sliding window of range = p.length, process each incoming and outgoing character
 * 
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
 *
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pCharFreqMap = new HashMap<>();
        
        //create a frequency map out of pattern
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            pCharFreqMap.put(c, pCharFreqMap.getOrDefault(c,0) + 1);
        }
        
        
        int match = 0;
        //sliding window of range = p.length, process each incoming and outgoing character
        for(int i=0; i<s.length();i++){
            char in = s.charAt(i);
            
            //for every incoming char, if its in pattern map, reduce its count, if count becomes zero increase match value
            if(pCharFreqMap.containsKey(in)) {
                int count = pCharFreqMap.get(in);
                count--;
                pCharFreqMap.put(in,count);
                
                if(count == 0) {
                    match++;
                }
            }
            
            int n = p.length();
            //if there is any outgoing character, if its in patter map, increase its count, if count becomes 1, reduce the match value
            if(i >= n) {
                char out = s.charAt(i - n);
                
                if(pCharFreqMap.containsKey(out)) {
                int count = pCharFreqMap.get(out);
                count++;
                pCharFreqMap.put(out,count);
                
                if(count == 1) {
                    match--;
                }
            }
            }
            
            //if match value equal to distinct char in pattern, current i is end of the anagram string, find start and add to result
            if(match == pCharFreqMap.size()) {
                result.add(i - n + 1);
            }
        }
        
        return result;
        
    }
}