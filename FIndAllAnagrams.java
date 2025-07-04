// Time complexity - O(n+m)
// Space complexity - O(1)
// Solved on leetcod e- yes
// faced any issues - no
// using 2 hashmaps to store String s and p. Here we are using2 pointers to go through the window, when window size is equal to length of p, we are comparing two maps. Whenevr 2 maps are euqal, we are adding the starting index to the result
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // Count characters in p
        for (int i = 0; i < p.length(); i++) {
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            
            // Shrink window if its size exceeds p's length
            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                smap.put(leftChar, smap.get(leftChar) - 1);
                if (smap.get(leftChar) == 0) {
                    smap.remove(leftChar);
                }
                left++;
            }
            
            // Compare maps
            if (smap.equals(pmap)) {
                result.add(left);
            }
        }
        
        return result;
    }
}
