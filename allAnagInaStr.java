import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //Tc: O(m+n)  Sc: O(m)
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < p.length(); i++)
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int mtch = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char in = s.charAt(i);
            if(map.containsKey(in))
            {
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0) mtch++;
                map.put(in,cnt);
            }

            if(i >= p.length())
            {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out))
            {
                int cnt = map.get(out);
                cnt++;
                if(cnt == 1) mtch--;
                map.put(out,cnt);
            }
            }
            if(mtch == map.size()) res.add(i-p.length()+1);
        }
        return res;
    }
}