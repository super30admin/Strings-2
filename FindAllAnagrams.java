// Time complexity:- O(n * m)
// Space complexity:- O(m + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences
/**
 * Approach: 
 * This problem is about finding all starting indices in string 's' where anagrams of string 'p' occur.
 * I used a sliding window approach to iterate through 's', and for each window, I compared the frequency of characters with those in 'p' using hash maps.
 * The sliding window moves one character at a time, updating the maps, and whenever the maps match, the current start index is added to the result.
 */ 
class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        
        int sLen = s.length();
        int pLen = p.length();

        // List to store the starting indices of anagrams
        List<Integer> result = new ArrayList<>();
        
        // If the length of string s is smaller than p, it's impossible to find anagrams
        if (sLen < pLen) {
            return result;
        } 
        
         // Create a map (pMap) to store the frequency of each character in string p
        Map<Character, Integer> pMap = new HashMap<>();
        
        for(int i = 0; i < pLen; i++) {

            char ch = p.charAt(i);

            // If the character is not in pMap, add it with frequency 1
            // If it's already in pMap, increment its frequency
            if(!pMap.containsKey(ch)){
                pMap.put(ch, 1);
            } else {
                pMap.put(ch, pMap.get(ch)+1);
            }
        }

        // Initializing the sliding window indices
        int st = 0;
        int end = pLen-1;

        // Create a map (sMap) to store the frequency of characters in the current window of s
        Map<Character, Integer> sMap = new HashMap<>();

         // Fill the sMap with characters from the first window of s
        for(int i = st; i <= end; i++) {
            char ch = s.charAt(i);

            if(!sMap.containsKey(ch)){
                sMap.put(ch, 1);
            } else {
                sMap.put(ch, sMap.get(ch)+1);
            }
        }

        // Variable to track how many characters match in both sMap and pMap
        int matched = 0;
        // Compare the frequencies in sMap with pMap for the first window
        for (Map.Entry<Character, Integer> entry: sMap.entrySet()) {
            char sMapKey = entry.getKey();
            int sMapVal = entry.getValue();

            if(pMap.containsKey(sMapKey) && pMap.get(sMapKey) == sMapVal) {
                matched++;
            } 
           
        }

        // If all characters match, add the start index of the window to the result
        if(matched == pMap.size()) {
            result.add(st);
        }
        
        while (end < sLen-1) {
            
            st++;
            end++;

            char out = s.charAt(st - 1);
            char in = s.charAt(end);

            //before removing out character from sMap 
            if(sMap.containsKey(out) && pMap.containsKey(out) && sMap.get(out).equals(pMap.get(out))) {
                matched--;
            }      
            //removing 'out' character from sMap
            sMap.put(out, sMap.get(out)-1);

            //after removing, check if value became zero
            if(sMap.get(out) == 0) {
                sMap.remove(out);
            }

            //after removing check if both maps contain same key and value
            if(sMap.containsKey(out) && pMap.containsKey(out) && sMap.get(out).equals(pMap.get(out))) {
                matched++;
            }

            //before adding 'in' character to sMap
            if(sMap.containsKey(in) && pMap.containsKey(in) && sMap.get(in).equals(pMap.get(in))) {
                matched--;
            }
            
            //adding 'in' chracter to the sMap
            
            if(sMap.containsKey(in)) {
                sMap.put(in, sMap.get(in) + 1);
            } else {
                sMap.put(in, 1);
            }
           
            // after adding 'in' character to sMap
            if(sMap.containsKey(in) && pMap.containsKey(in) && sMap.get(in).equals(pMap.get(in))) {
                matched++;
            }
            // If all characters match, add the start index of the current window to the result
            if(matched == pMap.size()) {
                result.add(st);
            }

        }
         // Return the list of indices where anagrams of p are found in s
        return result;
    }
}
     