// Time Complexity : O(n)
// Space Complexity : O(1) hashMap of 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0; i < p.length(); i ++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int pl = 0;
        int match =0;
        for(int i = 0; i < s.length(); i ++){
            //in
            if(map.containsKey(s.charAt(i))){
                int count = map.get(s.charAt(i));
                count --;
                map.put(s.charAt(i), count);
                if(count == 0) {
                    match ++;
                }
            }


            //out
            if(i >= p.length()){
                char c = s.charAt(i - p.length());
                if(map.containsKey(c)){
                    int count = map.get(c) + 1;
                    map.put(c, count);
                    if(count == 1){
                        match --;
                    }
                }
            }

            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}