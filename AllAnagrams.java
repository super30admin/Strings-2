// Time Complexity : O(N) where N is the length of the string s
// Space Complexity : O(1) - since the hashmap will have at most 26 characters

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {


        // refer leetcode solution - compare maps with sliding window
        List<Integer> res = new ArrayList<>();

        if(p.length() > s.length()){
            return res;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0)+1);
        }

        int wStart = 0;
        int winLen = p.length();



        for(int wEnd = 0; wEnd < s.length(); wEnd++){
            char ch = s.charAt(wEnd);

            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);

            if(wEnd - wStart + 1 >= winLen){

                if(pMap.equals(sMap)){
                    res.add(wStart);
                }
                char startChar = s.charAt(wStart);

                sMap.put(startChar, sMap.get(startChar)-1);

                if(sMap.get(startChar) == 0){
                    sMap.remove(startChar);
                }
                wStart++;
            }
        }
        return res;
    }
}