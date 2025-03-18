// Sliding Window
// TC: O(n)
// SC: O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || p.length() > s.length()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        // max 26 
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int start = 0;
        int end = 0;
        int match = 0;
        while(end < s.length()){
            //incoming character
            char ic = s.charAt(end);
            if(map.containsKey(ic)){
                int icCount = map.get(ic) - 1;
                if(icCount == 0){
                    match++;
                }
                map.put(ic, icCount);
            }
            //outgoing character
            if((end - start + 1) > p.length()){
                char oc = s.charAt(start);
                if(map.containsKey(oc)){
                    int ocCount = map.get(oc) + 1;
                    if(ocCount == 1){
                        match--;
                    }
                    map.put(oc, ocCount);
                }
                start++;
            }
            if(match == map.size()){
                result.add(start);
            }
            end++;
        }
        return result;
    }
}
