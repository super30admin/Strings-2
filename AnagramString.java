// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        int m = s.length();
        int n= p.length();
        List<Integer> res= new ArrayList<>();;

        for(char c: p.toCharArray()){
            map.put(c,map.getOrDefault(c, 0)+1);
        }

        int match=0;
        for(int i=0; i<m; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int freq= map.get(in);
                freq--;
                map.put(in, freq);
                if(freq == 0) match++;
            }

            if(i>=n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int freq= map.get(out);
                    freq++;
                    map.put(out, freq);
                    if(freq==1) match--;
                }
            }

            if(map.size()==match){
                res.add(i-n+1);
            }
        }

        return res;

    }
}
