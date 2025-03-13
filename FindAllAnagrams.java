//The idea here is to not check for all substrings for anagrams. Instead we use sliding window technique to process only one incoming and one outgoing character each time from our window.
//We maintain a frequency map of characters from p string and when we iterate through s string, we decrease the count if the incoming character exists in the map and when count becomes zero we increase the match count
//When processing the outgoing character, we increase the count of that from the map if exists and when count becomes 1, we decrease the match count.
//Whenever match equals map size, we then add the index of the starting anagram to the result
//Time Complexity: O(n)
//Space Complexity: O(1)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sl = s.length(); int pl = p.length();
        if(pl > sl) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<p.length(); i++){
            Character ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int match = 0;
        for(int i = 0; i<sl; i++){
            //in
            Character in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0){
                    match++;
                }
                map.put(in, cnt);
            }

            //out
            if(i >= pl){
                Character out = s.charAt(i-pl);
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1){
                        match--;
                    }
                    map.put(out, cnt);
                }
            }

            if(match == map.size()){
                result.add(i-pl+1);
            }
            
        }
        return result;
    }
}