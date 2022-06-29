import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity : O(N)
//Space Complexity : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        //put p chars in map with count
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //finding number for matches
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            //incoming char if contains in p string then decrease char count by 1
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in,cnt);
                //if there are equal number of elements increase match
                if(cnt == 0) match++;
            }
            //outgoing
            //if outgoing char is not there
            if(i >= p.length()){
                char out =s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                cnt++;
                map.put(out,cnt);
                if(cnt == 1) match--;
                    } 
                }
            
        if(map.size()==match) result.add(i-p.length()+1);
        }
        return result;
    }
}