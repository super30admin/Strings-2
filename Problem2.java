//T.C : O(n) where n is the size of the s string
//S.C : O(1) assuming there will be 26 alphabets in the hashmap
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int match=0;
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                if(count ==0){
                    match++;
                }
                map.put(in,count);
            }
            if(i >= p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count ==1){
                        match--;
                    }
                    map.put(out,count);
                }
            }
            if(map.size() == match){
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }
}
