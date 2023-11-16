// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FindAllAnagram {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length(), pLen = p.length();
            List<Integer> result = new ArrayList<>();

            if(pLen > sLen) return result;

            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < pLen; i++){
                char c = p.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int match = 0;
            int start = 0;
            for(int i = 0; i < sLen; i++){
                char in = s.charAt(i);

                if(map.containsKey(in)){
                    int count = map.get(in);
                    count--;
                    map.put(in, count);
                    if(count == 0)
                        match++;
                }

                if(i >= pLen){
                    char out = s.charAt(start);
                    if(map.containsKey(out)){
                        int count = map.get(out);
                        count++;
                        map.put(out, count);
                        if(count == 1)
                            match--;
                    }
                    start++;
                }

                if(match == map.size()){
                    result.add(start);
                }
            }
            return result;
        }
    }
}
