import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/**
 * We first make a freq. map of string p. We first construct a
 * window of size n (len. of p). Then we slide it. We process the incoming and outgoing
 * characters and change their frequency accordingly. If the frequency changes from 0->1
 * we decrement match counter and if it goes from 1->0, we increment the match counter.
 * After processing each window we check if the match == map's size and store the start
 * pointer in the res list.
 */

public class Problem2 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        //fill the map
        for(int i=0; i<n; i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;

        for(int i=0; i<m; i++) {
            //incoming
            char in = s.charAt(i);

            if(map.containsKey(in)) {
                map.put(in, map.get(in) - 1);
                if(map.get(in) == 0) match++;
            }

            if(i >= n) {
                //outgoing
                char out = s.charAt(i - n);
                if(map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1) match--;
                }
            }

            if(match == map.size()) res.add(i - n + 1);
        }

        return res;
    }
}
