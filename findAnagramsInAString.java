// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int match = 0;

        for(int i=0; i<p.length(); i++)
        {
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0; i<s.length();i++)
        {
            char in = s.charAt(i);
            if(map.containsKey(in))
            {
                int freq = map.get(in);
                freq--;
                map.put(in, freq);
                if(freq == 0) match++;
                //else if(freq <0) match--;
            }
            if(i >= p.length())
            {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out))
                {
                    int freq = map.get(out);
                    freq++;
                    map.put(out,freq);
                    if(freq == 1) match--;
                    //else if(freq <=0) match++;
                }
            }


            if(map.size() == match)
            {
                result.add(i-p.length()+1);
            }

        }
        return result;

    }
}
