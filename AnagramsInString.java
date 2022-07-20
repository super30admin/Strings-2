// Time Complexity : O(n+m) where n and m are length of strings
// Space Complexity : O(1) where n is length of needle, since only 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class AnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> result = new ArrayList<>();
        if(m>n) return result;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<m;i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int slow = 0;
        int match = 0;
        for(int i=0;i<n;i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt==0){
                    match++;
                }
                map.put(in,cnt);
            }

            if(i>=m){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt==1){
                        match--;
                    }
                    map.put(out,cnt);
                }
            }

            if(map.size()==match) result.add(i-p.length()+1);
        }

        return result;
    }

    public static void main(String [] args){
        AnagramsInString as = new AnagramsInString();
        System.out.println(as.findAnagrams("cbaebabacd", "abc"));
    }
}