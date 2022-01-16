// Time Complexity = O(m+n), where m is length of s and n is length of p
// Space Complexity = O(1), since the hashmap will contain at max 26 values since it contains lower case alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Use sliding window approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s==null || s.length() == 0 || p==null || p.length() == 0) return result;

        // traverse over p and fill the hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int size = p.length();
        int match=0;    // to check the matches, if its equal to p.length() we add slow to the result

        // Traverse string s to find anagrams
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                count--;
                map.put(c, count);
                if (count == 0) {
                    match++;
                }
            }

            // from this point onwards we will have an outgoing character from the window
            if (i >= size) {
                char out = s.charAt(i-size);
                if (map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if(count == 1) {
                        match--;
                    }
                }
            }

            // check if match equals to size of the map, if yes add slow pointer to the result
            if (match == map.size()) {
                result.add(i-size+1);
            }
        }

        return result;
    }
}