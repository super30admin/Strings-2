// Time: O(S.length)+O(Order.length*

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        StringBuilder res = new StringBuilder();
        for(int k = 0;k<order.length();k++) {
            char character = order.charAt(k);
            if(map.containsKey(character)) {
                for(int i=0;i<map.get(character);i++){
                    res.append(character);
                }
            }
            map.remove(character);
        }
        for(Character key: map.keySet()){
            for(int i=0;i<map.get(key);i++){
                res.append(key);
            }
        }
        return res.toString();
    }
}