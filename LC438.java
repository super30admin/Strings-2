// Time Complexity : O(n + m) 
// Space Complexity : O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < p.length())return result;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length();i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0;
        int right = 0;
        int match = map.keySet().size();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1); 
                if(map.get(ch) == 0){
                   match--;
                 }
                 if(map.get(ch) == -1){
                   match++;
                 }
            }

            if(i < p.length()){
                if(match == 0){
                    result.add(start);
                }
                continue;
            }

            char prev = s.charAt(start);
            start++;
            if(map.containsKey(prev)){
                map.put(prev, map.get(prev) + 1);
                if(map.get(prev) == 0){
                    match--;
                }
                if(map.get(prev) == 1){
                    match++;
                }
            }
            if(match == 0){
                result.add(start);
            } 
        }

        return result;
    }
}