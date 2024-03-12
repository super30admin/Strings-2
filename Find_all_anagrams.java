//TimeComplexity: O(m)
//space complexity:O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) {
           return result;
        }
        for(int i =0; i<p.length();i++) {
            char c = p.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c,0);
            }
            map.put(c, map.get(c)+1);
        }

        int match =0;
        for(int i =0; i<s.length();i++) {
            // incoming character
            char inc = s.charAt(i);
            if(map.containsKey(inc)) {
                map.put(inc,map.get(inc)-1);
                if(map.get(inc) == 0) {
                match++;
                }
            }

            //outgoing character 
            if(i >= p.length()) {
              char out = s.charAt(i-p.length());
              if(map.containsKey(out)) {
                map.put(out,map.get(out)+1);
                if(map.get(out) == 1) {
                match--;
                }
              }
            }
            if(match == map.size()) {
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}