/**
LeetCode Submitted : YES
Time Complexity : O(S.length()) + O(p.length())
Space Complexity : O(1) Hashmap of characters array

The idea is to use incoming and outgoing character to keep track of match count. Initially we add characters and frequency of each characters in a hashmap and then keep track of match count such that if match count is equal to hash map size add index to the resultant list. Also, for each incoming character we check if we exists in hash map and decrease count of that character and if character count == 0 increase match count. Also, for each outgoing character we increase frequency of that character in hash map and if match == 1 decrease match count.

**/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     
        List<Integer> result = new ArrayList<>();
        
        if(s == null || p == null || s.length() < 1 || p.length() < 1 || s.length()  < p.length())
            return result;
        
        
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        //Adding frequency of each characters of P array in Map
        for(int i = 0; i< p.length();i++){
            char  c = p.charAt(i);
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        
        //Iterating the String S to find all anagrams such that window size is p length
        int match = 0;
        for(int i = 0; i< s.length();i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                map.put(in,map.get(in) - 1);
                
                if(map.get(in) == 0)
                    match ++;
            }
            
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    map.put(out,map.get(out) + 1);
                
                    if(map.get(out) == 1)
                        match --;
                }
            }
            
            if(match == map.size())
                result.add(i-p.length()+1);
        }
        
        return result;
    }
}
