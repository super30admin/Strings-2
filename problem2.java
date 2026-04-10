    /**
    Time Complexity : O(N)
    Explanation:
    We use sliding window. Each character is processed at most twice
    (once entering window, once leaving).

    Space Complexity : O(1)
    Explanation:
    HashMap stores at most 26 lowercase letters → constant space.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially had difficulty tracking when a window becomes a valid anagram.
    Fixed it using a 'match' counter:
        - When frequency becomes 0 → match++
        - When frequency moves away from 0 → match--
    Also needed to correctly shrink the window when size exceeds p.length().
    */


    class Solution {


        public List<Integer> findAnagrams(String s, String p) {
    
            List<Integer> re = new ArrayList<>();
    
            int left = 0;
            int right = 0;
    
            HashMap<Character, Integer> fmap = new HashMap<>();
    
            // Build frequency map of pattern
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                fmap.put(c, fmap.getOrDefault(c, 0) + 1);
            }
    
            int match = 0;
    
            while (right < s.length()) {
    
                char in = s.charAt(right);
    
                // Process incoming character
                if (fmap.containsKey(in)) {
                    int cnt = fmap.get(in) - 1;
                    if (cnt == 0) match++;
                    fmap.put(in, cnt);
                }
    
                // Maintain window size = p.length()
                if (right >= p.length()) {
    
                    char out = s.charAt(left);
    
                    if (fmap.containsKey(out)) {
                        int cnt = fmap.get(out) + 1;
                        if (cnt == 1) match--;
                        fmap.put(out, cnt);
                    }
    
                    left++;
                }
    
                right++;
    
                // Check if all characters matched
                if (match == fmap.size()) {
                    re.add(left);
                }
            }
    
            return re;
        }
    }