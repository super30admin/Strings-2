// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(int i = 0; i<p.length(); i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0)+1);
        }

        int l = 0, r = 0, match = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            if(pMap.containsKey(c)) {
                int cnt = pMap.get(c);
                cnt--;
                if(cnt==0) match++;
                pMap.put(c, cnt);
            }

            if(r-l >= p.length() && l<r) {
                char lChar = s.charAt(l);
                if(pMap.containsKey(lChar)) {
                    int cnt = pMap.get(lChar);
                    cnt++;
                    if(cnt == 1) match--;
                    pMap.put(lChar, cnt);
                    l++;
                    r++;
                } else {
                    l++;
                    r++;
                }
            } else {
                r++;
            }
            System.out.println(match);
            if(match == pMap.size()) {
                result.add(l);
            }
        }
        return result;
    }
}