/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
                int[] map = new int[26];
        List<Integer> list = new ArrayList<>();
        int winSize = p.length();
        
        for (int i = 0; i < winSize; i++) {
            char c = p.charAt(i);
            map[c-'a']++;
        }
            
        for (int L = 0, R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            map[c-'a']--;
            
            while (map[c-'a'] < 0) {
                char left = s.charAt(L++);
                map[left-'a']++;
            }
            
            if (R-L+1 == winSize) list.add(L);
        }
        
        return list;
    }
}
