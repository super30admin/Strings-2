//  Time Complexity: O(m + n)
//  Space Complexity: O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1 );
        }

        int n = p.length();
        int left = 0;
        int match = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) match++;
            }

            if(i>=n){
                left = i - n;
                char out = s.charAt(left);
                if(map.containsKey(out)){
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1) match--;
                }
            }

            if(map.size() == match){
                result.add(i - n + 1);
            }
        }
        return result;
    }
}