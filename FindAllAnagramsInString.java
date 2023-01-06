import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time Complexity :O(m+n) n is the length of string s, m is the length of string p
// But m is always < n (given in question) ~= O(n)
// Space Complexity : O(26) ~= O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();


        //pattern length > string s length - then return empty list
        if(p.length() > s.length())
            return result;

        HashMap<Character,Integer> map = new HashMap<>();

        //Make the frequency map for pattern String p
        for(int i = 0 ; i < p.length() ; i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int match = 0;

        //traverse the string s
        for(int i = 0 ; i < s.length() ; i++){
            //incoming character
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in,cnt);

                if(cnt == 0)
                    match++;
            }

            if(i >= p.length()){
                //outgoing character
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out,cnt);

                    if(cnt == 1)
                        match--;
                }
            }

            if(match == map.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}
