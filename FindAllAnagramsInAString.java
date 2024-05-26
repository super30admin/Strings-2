import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = p.length();
        int m = s.length();
        if(n > m) return result;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i< n; i++)
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int match = 0;
        for(int i=0; i<m ; i++)
        {
            //incoming character
            char in = s.charAt(i);
            if(map.containsKey(in))
            {
                int cnt = map.get(in);
                cnt--;
                if(cnt==0) match++;
                map.put(in, cnt);
            }

            //outgoing character
            if( i >= n)
            {
                char out = s.charAt(i-n); // if we want to give out the index // if we want to give out the length (i-n+1)
                if(map.containsKey(out))
                {
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt==1) match--;
                    map.put(out, cnt);
                }

            }
            if(match == map.size())
            {
                result.add(i-n+1);
            }
        }
        return result;
    }
}
