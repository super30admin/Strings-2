// TC: O(m+n)
// SC: O(1) 

import java.util.*;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        if(n>m) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int match = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            if(i>=n){
                int removableIdx = i-n;
                char rch = s.charAt(removableIdx);
                if(map.containsKey(rch)){
                    map.put(rch, map.get(rch)+1);
                    if(map.get(rch)==1) match--;
                }
            }
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) match++;
            }
            if(match==map.size()){
                ans.add(i-n+1);
            }
        }
        return ans;
    }
}
