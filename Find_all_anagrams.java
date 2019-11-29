TC: O(n)
SC: O(1)

Runtime: 31 ms, faster than 24.70% of Java online submissions for Find All Anagrams in a String.
Memory Usage: 39.7 MB, less than 36.00% of Java online submissions for Find All Anagrams in a String.

Approach: We use sliding window method.First we have a map of the count of the char in the p string.
If the new letter coming to the window is there in the map we will decrease the count by 1, check if it is 0.If it is 0, we will increase match by 1.if the leaving letter from the window is
there in map, we will increase count by 1 and check if it is 1.If it is 1,we will decrease match by 1.Weheever the match count becomes same as size of map, we will
add the corresponding index to result.



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        if(s==null || p == null || s.length() ==0 || p.length() == 0) return result;
        Map<Character, Integer> map = new HashMap<>();
        int match =0;
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(map);
        
        for(int i=0; i<s.length(); i++){
           char c= s.charAt(i);
            // incoming
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) match++;
            }
            if(i>= p.length()){
                c=s.charAt(i-p.length());
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)==1) match--;// when it was 0, after increasing the counting by 1 we will get 1, so if that is the case it means it was 0 and now it is 1, so decrease match
                }
                
            }
            if(match == map.size()) result.add(i-p.length()+1);
        }
        return result;
    }
}
