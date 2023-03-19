import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Find all anagrams in a string
approach: first iterate on pattern and make freq map; now use sliding window technique and count no.of matches
time: O(len(s))
space: O(1)
 */
public class Problem2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length()) return res;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<p.length();i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }

        int match = 0;

        for(int i=0;i<s.length();i++) {
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                map.put(in, map.get(in)-1);
                if(map.get(in)==0) match++;
            }

            if(i>=p.length()) {
                char out = s.charAt(i-p.length());

                if(map.containsKey(out)) {
                    map.put(out, map.get(out)+1);
                    if(map.get(out)==1) match--;
                }

            }
            if(match==map.size()) res.add(i-p.length()+1);

        }

        return res;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.findAnagrams("baa", "aa");
    }
}
