/**
 *  Time Complexity: O(S+P)
 *  Space Complexity: O(1)
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (s == null || s.length() == 0 || p.length() > s.length()) {
            return result;
        }
        
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        
        // get the frequency of all characters in p
        for (int i = 0; i < p.length(); i++) {
            pMap[p.charAt(i) - 'a']++;
            sMap[s.charAt(i) - 'a']++;
        }
        
        // iterate over s, with a sliding window of length p.length()
        // check for the freqency of characters in the window
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // eliminate the frequency of the first char in the last sliding window
            if (i != 0) {
                sMap[s.charAt(i - 1) - 'a']--;
                sMap[s.charAt(i + p.length() - 1) - 'a']++;
            }
            
            if (isAnagram(sMap, pMap)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private boolean isAnagram(int[] sMap, int[] pMap) {
        for (int i = 0; i < 26; i++) {
            if (sMap[i] != pMap[i]) {
                return false;
            }
        }
        
        return true;
    }
}