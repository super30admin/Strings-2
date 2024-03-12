// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TC: O(m+n)
//SC: O(n)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int match = 0;
        int n = p.length();
        int m = s.length();
        if(n > m) return result;

        Map<Character, Integer> pMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < m; i++) {

            // in
            char in = s.charAt(i);
            if (pMap.containsKey(in)) {
                int cnt = pMap.get(in);
                cnt--;
                if (cnt == 0) {
                    match++;
                }
                pMap.put(in, cnt);
            }

            // out
            if (i >= n) {
                char out = s.charAt(i - n);
                if (pMap.containsKey(out)) {
                    int cnt = pMap.get(out);
                    cnt++;
                    if (cnt == 1) {
                        match--;
                    }
                    pMap.put(out, cnt);
                }
            }

            if(pMap.size() == match) {
                result.add(i-n + 1);
            }
        }

        return result;
    }
}